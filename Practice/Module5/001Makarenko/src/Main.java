import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/joinsdb";
        final String LOGIN = "root";
        final String PASSWORD = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load success");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSetEmployees = statement.executeQuery("SELECT * FROM employees");
            while (resultSetEmployees.next())
            {
                String name = resultSetEmployees.getString("name");
                String phone = resultSetEmployees.getString("phone");
                String second_phone = resultSetEmployees.getString("second_phone");
                System.out.println(name + ", " + phone + ", " + second_phone);
            }
            System.out.println();
            ResultSet resultSetPositions = statement.executeQuery("SELECT * FROM positions");
            while (resultSetPositions.next())
            {
                String position = resultSetPositions.getString("pos");
                int salary = resultSetPositions.getInt("salary");
                System.out.println(position + ", " + salary);
            }
            System.out.println();
            ResultSet resultSetInfo = statement.executeQuery("SELECT * FROM info");
            while (resultSetInfo.next())
            {
                String city = resultSetInfo.getString("city");
                System.out.println(city);
            }
            connection.close();
            statement.close();
        }
        catch (SQLException e) {
            e.getCause();
        }
        finally {

        }
    }
}
