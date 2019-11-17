package dao;

import entities.ElectricityItem;
import entities.WashingMachine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WashingMachineDB implements DAO {
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
        WashingMachine washingMachine = (WashingMachine) item;
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO washingMachines VALUES (default, ?, ?, ?, ?)");

            statement.setString(1, washingMachine.getName());
            statement.setInt(2, washingMachine.getPower());
            statement.setInt(3, washingMachine.getMaxClothesWeight());
            statement.setInt(4, washingMachine.isTurnedOn() ? 1 : 0);

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
            statement = connection.prepareStatement("DELETE FROM washingMachines WHERE washingMachines.id = ?");
            statement.setInt(1, id);
            statement.execute();

            System.out.println("washingMachine " + id + " has been deleted");
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
        WashingMachine washingMachine = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM washingMachines WHERE washingMachines.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int power = resultSet.getInt("power");
                String name = resultSet.getString("name");
                int liters = resultSet.getInt("liters");
                boolean turnedOn = resultSet.getInt("turnedOn") == 1;

                washingMachine = new WashingMachine(name, power, liters);
                if (turnedOn)
                    washingMachine.turnOn();
                else
                    washingMachine.turnOff();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
        return washingMachine;
    }

    @Override
    public List<ElectricityItem> getAll() {
        List<ElectricityItem> washingMachines = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM washingMachines");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int power = resultSet.getInt("power");
                String name = resultSet.getString("name");
                int maxClothesWeight = resultSet.getInt("maxClothesWeight");
                boolean turnedOn = resultSet.getBoolean("turnedOn");

                WashingMachine washingMachine = new WashingMachine(name, power, maxClothesWeight);
                if (turnedOn)
                    washingMachine.turnOn();
                else
                    washingMachine.turnOff();

                washingMachines.add(washingMachine);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
        return washingMachines;
    }
}
