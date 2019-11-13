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
            statement = connection.createStatement();

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

            statement.executeQuery(third);
            ResultSet resultSet1 = statement.getResultSet();

            while (resultSet1.next()) {
                String phone = resultSet1.getString("phone");
                System.out.println(phone);
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
