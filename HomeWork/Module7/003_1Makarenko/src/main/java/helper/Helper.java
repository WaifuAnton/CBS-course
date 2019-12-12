package helper;

import org.hibernate.SessionFactory;

import java.util.List;

public abstract class Helper<E> {
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public abstract List<E> getAll();

    public abstract E getById(long id);

    public abstract void add(E element);

    public abstract void update(long id, E element);

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
