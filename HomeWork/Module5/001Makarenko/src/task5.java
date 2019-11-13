import java.sql.*;

public class task5 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        final String URL = "jdbc:mysql://localhost:3306/joinsdb?useSSL=false";
        final String LOGIN = "root";
        final String PASSWORD = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load success\n");

            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            String second = "SELECT e.*, i.birthday FROM Employees AS e\n" +
                    "JOIN Info AS i\n" +
                    "ON i.status = \"not married\" AND e.id = i.id_employee";
            String first = "SELECT e.*, i.city FROM Employees AS e\n" +
                    "JOIN Info AS i\n" +
                    "ON e.id = i.id_employee";
            String third = "SELECT e.*, i.birthday FROM Employees AS e \n" +
                    "JOIN Positions AS p\n" +
                    "ON p.pos = \"Manager\" AND e.id = p.id_employee\n" +
                    "JOIN Info AS i\n" +
                    "ON i.id_employee = e.id";

            statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery(third);
            while (resultSet1.next()) {
                int id = resultSet1.getInt("id");
                String name = resultSet1.getString("name");
                String phone = resultSet1.getString("phone");
                String second_phone = resultSet1.getString("second_phone");
                java.sql.Date birthday = resultSet1.getDate("birthday");
                System.out.println(id + "\t" + name + "\t" + phone + "\t" + second_phone + "\t" + birthday);
            }
            System.out.println();

            statement = connection.createStatement();
            ResultSet resultSet2 = statement.executeQuery(second);
            while (resultSet2.next()) {
                int id = resultSet2.getInt("id");
                String name = resultSet2.getString("name");
                String phone = resultSet2.getString("phone");
                String second_phone = resultSet2.getString("second_phone");
                java.sql.Date birthday = resultSet2.getDate("birthday");
                System.out.println(id + "\t" + name + "\t" + phone + "\t" + second_phone + "\t" + birthday);
            }
            System.out.println();

            statement = connection.createStatement();
            ResultSet resultSet3 = statement.executeQuery(first);
            while (resultSet3.next()) {
                int id = resultSet3.getInt("id");
                String name = resultSet3.getString("name");
                String phone = resultSet3.getString("phone");
                String second_phone = resultSet3.getString("second_phone");
                String city = resultSet3.getString("city");
                System.out.println(id + "\t" + name + "\t" + phone + "\t" + second_phone + "\t" + city);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
        finally {
            try {
                statement.close();
                connection.close();
            }
            catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
