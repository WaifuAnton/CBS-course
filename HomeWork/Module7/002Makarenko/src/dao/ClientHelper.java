package dao;

import entity.Client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientHelper implements ClientDAO {
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
                        resultSet.getInt("age"), resultSet.getString("phone"),
                        resultSet.getString("auth_string"));
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
            byte[] array = new byte[32];
            new Random().nextBytes(array);
            String seed = new String(array);

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            String beforeHash = client.getPassword() + seed;
            byte[] hash = messageDigest.digest(beforeHash.getBytes());

            preparedStatement = connection.prepareStatement("INSERT INTO clients(name, age, phone, auth_string) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, client.getName());
            preparedStatement.setInt(2, client.getAge());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.setString(4, new String(hash));
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement("SELECT MAX(id) AS id FROM clients");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            long id = resultSet.getLong("id");

            preparedStatement = connection.prepareStatement("INSERT INTO seed(id, seed) VALUES (?, ?)");
            preparedStatement.setInt(1, (int) id);
            preparedStatement.setString(2, seed);
            preparedStatement.execute();
        }
        catch (SQLException | NoSuchAlgorithmException e) {
            System.out.println(e.getCause());
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
            System.out.println(e.getCause());
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop?useSSL=false&serverTimezone=UTC", "root", "root");
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
            System.out.println(e.getCause());
        }
    }
}
