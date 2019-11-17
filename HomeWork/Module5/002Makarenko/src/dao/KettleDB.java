package dao;

import entities.ElectricityItem;
import entities.Kettle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KettleDB implements DAO {
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

    @Override
    public void add(ElectricityItem item) {
        Kettle kettle = (Kettle) item;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO kettles VALUES (default, ?, ?, ?, ?)");

            statement.setString(1, kettle.getName());
            statement.setInt(2, kettle.getPower());
            statement.setInt(3, kettle.getLiters());
            statement.setInt(4, kettle.isTurnedOn() ? 1 : 0);

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
            statement = connection.prepareStatement("DELETE FROM kettles WHERE kettles.id = ?");
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
        Kettle kettle = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM kettles WHERE kettles.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int power = resultSet.getInt("power");
                String name = resultSet.getString("name");
                int liters = resultSet.getInt("liters");
                boolean turnedOn = resultSet.getInt("turnedOn") == 1;

                kettle = new Kettle(name, power, liters);
                if (turnedOn)
                    kettle.turnOn();
                else
                    kettle.turnOff();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
        return kettle;
    }

    @Override
    public List<ElectricityItem> getAll() {
        List<ElectricityItem> kettles = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM kettles");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int power = resultSet.getInt("power");
                String name = resultSet.getString("name");
                int liters = resultSet.getInt("liters");
                boolean turnedOn = resultSet.getBoolean("turnedOn");

                Kettle kettle = new Kettle(name, power, liters);
                if (turnedOn)
                    kettle.turnOn();
                else
                    kettle.turnOff();

                kettles.add(kettle);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
        return kettles;
    }
}
