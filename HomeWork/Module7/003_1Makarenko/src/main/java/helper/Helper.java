package helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class Helper<E> {
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    protected Session session;

    public abstract List<E> getAll();

    public abstract E getById(long id);

    public abstract void add(E element);

    public abstract void update(long id, E element);

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
