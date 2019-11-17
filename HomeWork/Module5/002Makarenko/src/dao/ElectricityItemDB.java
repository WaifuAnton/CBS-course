package dao;

import entities.ElectricityItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElectricityItemDB implements DAO {
    @Override
    public void add(ElectricityItem item) {
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO items VALUES (default, ?, ?, ?)");

            statement.setString(1, item.getName());
            statement.setInt(2, item.getPower());
            statement.setInt(3, item.isTurnedOn() ? 1 : 0);

            statement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM items WHERE items.id = ?");
            statement.setInt(1, id);
            statement.execute();

            System.out.println("kettle " + id + " has been deleted");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
    }

    @Override
    public ElectricityItem getByID(int id) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ElectricityItem item = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM items WHERE items.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int power = resultSet.getInt("power");
                boolean turnedOn = resultSet.getInt("turnedOn") == 1;

                item = new ElectricityItem(power);
                if (turnedOn)
                    item.turnOn();
                else
                    item.turnOff();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
        return item;
    }

    @Override
    public List<ElectricityItem> getAll() {
        List<ElectricityItem> items = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM items");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int power = resultSet.getInt("power");
                boolean turnedOn = resultSet.getBoolean("turnedOn");

                ElectricityItem kettle = new ElectricityItem(power);
                if (turnedOn)
                    kettle.turnOn();
                else
                    kettle.turnOff();

                items.add(kettle);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
        return items;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityItems?serverTimezone=UTC",
                    "root", "root");
        }
        catch (SQLException e) {
            e.getMessage();
        }
        return connection;
    }

    private void closeConnection(Connection connection, Statement statement) {
        try {
            connection.close();
            statement.close();
        } catch (SQLException | NullPointerException e) {
            e.getMessage();
        }
    }
}
