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

            statement.setString(1, conditioner.getName());
            statement.setInt(2, conditioner.getPower());
            statement.setInt(3, conditioner.getMinTemperature());
            statement.setInt(4, conditioner.getMaxTemperature());
            statement.setInt(5, conditioner.isTurnedOn() ? 1 : 0);

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
            statement = connection.prepareStatement("DELETE FROM conditioners WHERE conditioners.id = ?");
            statement.setInt(1, id);
            statement.execute();

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
        Conditioner conditioner = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM conditioners WHERE conditioners.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int power = resultSet.getInt("power");
                String name = resultSet.getString("name");
                int minTemperature = resultSet.getInt("minTemperature");
                int maxTemperature = resultSet.getInt("maxTemperature");
                boolean turnedOn = resultSet.getInt("turnedOn") == 1;

                conditioner = new Conditioner(name, power, minTemperature, maxTemperature);
                if (turnedOn)
                    conditioner.turnOn();
                else
                    conditioner.turnOff();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
        return conditioner;
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

                Conditioner conditioner = new Conditioner(name, power, minTemperature, maxTemperature);
                if (turnedOn)
                    conditioner.turnOn();
                else
                    conditioner.turnOff();

                conditioners.add(conditioner);
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
