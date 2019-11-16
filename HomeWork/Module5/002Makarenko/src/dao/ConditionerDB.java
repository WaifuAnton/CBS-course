package dao;

import entities.Conditioner;
import entities.ElectricityItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConditionerDB implements DAO {
    @Override
    public void add(ElectricityItem item) {
        Conditioner conditioner = (Conditioner) item;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO conditioners VALUES (default, ?, ?, ?, ?, ?)");

            statement.setString(1, item.getName());
            statement.setInt(2, item.getPower());
            statement.setInt(3, ((Conditioner) item).getMinTemperature());
            statement.setInt(4, ((Conditioner) item).getMaxTemperature());
            statement.setInt(5, item.isTurnedOn() ? 1 : 0);

            statement.execute();

            System.out.println("values added");
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
            statement = connection.prepareStatement("DELETE FROM conditioners WHERE conditioners.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Conditioner " + id + " has been deleted");
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
        Conditioner item = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM conditioners WHERE conditioners.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int power = resultSet.getInt("power");
                String name = resultSet.getString("name");
                int minTemperature = resultSet.getInt("minTemperature");
                int maxTemperature = resultSet.getInt("maxTemperature");
                boolean turnedOn = resultSet.getInt("turnedOn") == 1 ? true : false;

                item = new Conditioner(name, power, minTemperature, maxTemperature);
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
        List<ElectricityItem> conditioners = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM conditioners");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int power = resultSet.getInt("power");
                String name = resultSet.getString("name");
                int minTemperature = resultSet.getInt("minTemperature");
                int maxTemperature = resultSet.getInt("maxTemperature");
                boolean turnedOn = resultSet.getBoolean("turnedOn");

                Conditioner item = new Conditioner(name, power, minTemperature, maxTemperature);
                conditioners.add(item);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
        return conditioners;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityItems?serverTimezone=UTC",
                    "root", "root");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void closeConnection(Connection connection, Statement statement) {
        try {
            connection.close();
            statement.close();
        }
        catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
