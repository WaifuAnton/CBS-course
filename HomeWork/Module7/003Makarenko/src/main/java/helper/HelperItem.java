package helper;

import entity.ElectricityItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class HelperItem <E extends ElectricityItem> extends Helper<E> {
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    protected Session session;

    public abstract List<E> getAll();
}
