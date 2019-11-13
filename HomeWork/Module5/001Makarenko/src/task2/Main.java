package task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/joinsdb?useSSL=false";
        final String LOGIN = "root";
        final String PASSWORD = "root";

        FileReader in = null;
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success");
            in = new FileReader("src/task2/input.txt");
            BufferedReader reader = new BufferedReader(in);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            String str1, str2, str3;
            do {
                str1 = reader.readLine();
            } while (str1.equals(""));
            do {
                str2 = reader.readLine();
            } while (str2.equals(""));
            do {
                str3 = reader.readLine();
            } while (str3.equals(""));

            statement = connection.createStatement();
            ResultSet resultSetEmployees = statement.executeQuery(str1);
            while (resultSetEmployees.next()) {
                String name = resultSetEmployees.getString("name");
                String phone = resultSetEmployees.getString("phone");
                String second_phone = resultSetEmployees.getString("second_phone");
                System.out.println(name + "\t" + phone + "\t" + second_phone);
            }
            System.out.println();

            statement = connection.createStatement();
            ResultSet resultSetPosition = statement.executeQuery(str2);
            while (resultSetPosition.next()) {
                String pos = resultSetPosition.getString("pos");
                int salary = resultSetPosition.getInt("salary");
                System.out.println(pos + "\t" + salary);
            }
            System.out.println();

            statement = connection.createStatement();
            ResultSet resultSetInfo = statement.executeQuery(str3);
            while (resultSetInfo.next()) {
                String city = resultSetInfo.getString("city");
                System.out.println(city);
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver loading failed");
            e.getMessage();
        }
        catch (FileNotFoundException e) {
            System.out.println("File reading failed");
            e.getMessage();
        }
        catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
                connection.close();
                in.close();
            }
            catch (SQLException | IOException | NullPointerException e) {
                e.getMessage();
            }
        }
    }
}
