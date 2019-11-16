package dao;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.getMessage();
        }
    }

    public static synchronized DAOFactory getFactory() {
        if (factory == null)
            factory = new DAOFactory();
        return factory;
    }
}
