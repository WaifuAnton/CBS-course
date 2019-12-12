package helper;

import entity.ElectricityItem;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Helper<E extends ElectricityItem> {
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    protected Session session;
    
    public List<E> getAll() {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(E.class);
        List<E> Es = criteria.list();
        session.close();
        return Es;
    }
    
    public E getById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        E E = (E) session.get(ElectricityItem.class, id);
        session.close();
        return E;
    }
    
    public void add(E element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(long id, E element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        E temp = (E) session.get(ElectricityItem.class, id);
        if (temp != null) {
            element.setId(id);
            session.merge(element);
        }
        else
            session.save(element);
        session.getTransaction().commit();
    }
}
