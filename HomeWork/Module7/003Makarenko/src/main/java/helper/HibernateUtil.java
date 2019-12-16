package helper;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        catch (HibernateException e) {
            System.out.println(e.getCause());
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
