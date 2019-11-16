package dao;

import entities.ElectricityItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public ElectricityItem getByID(int id) {
        return null;
    }

    @Override
    public List<ElectricityItem> getAll() {
        return null;
    }
}
