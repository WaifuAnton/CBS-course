package task3.dao;

import task3.entitiy.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientJDBCDao implements ClientDAO {
    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM clients");
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Client client = new Client(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("age"), resultSet.getString("phone"));
                clients.add(client);
            }
        }
        catch (SQLException e) {
            e.getMessage();
        }
        finally {
            closeConnection(connection, statement);
        }
        return clients;
    }

    @Override
    public void add(Client client) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");
            preparedStatement.setString(1, client.getName());
            preparedStatement.setInt(2, client.getAge());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public Client getById(int id) {
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM clients WHERE id = ?");
            statement.setInt(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            resultSet.next();
            return new Client(resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getInt("age"), resultSet.getString("phone"));
        }
        catch (SQLException e) {
            e.getMessage();
        }
        finally {
            closeConnection(connection, statement);
        }
        return null;
    }

    @Override
    public void updateAge(int id, int newAge) {
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE clients SET age = ? WHERE id = ?");

            statement.setInt(1, newAge);
            statement.setInt(2, id);

            int updatedValues = statement.executeUpdate();
            System.out.println("Values updated: " + updatedValues);
        } catch (SQLException e) {
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
            statement = connection.prepareStatement("DELETE FROM clients WHERE id = ?");

            statement.setInt(1, id);

            int deletedValues = statement.executeUpdate();
            System.out.println("Values deleted: " + deletedValues);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection, statement);
        }
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop?useSSL=false", "root", "root");
        }
        catch (SQLException e) {
            System.out.println(e.getCause());
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
