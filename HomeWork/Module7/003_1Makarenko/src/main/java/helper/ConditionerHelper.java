package helper;

import entity.Conditioner;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class ConditionerHelper extends Helper<Conditioner> {
    @Override
    public List<Conditioner> getAll() {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Conditioner.class);
        List<Conditioner> conditioners = criteria.list();
        session.close();
        return conditioners;
    }

    @Override
    public Conditioner getById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Conditioner conditioner = session.get(Conditioner.class, id);
        session.close();
        return conditioner;
    }

    @Override
    public void add(Conditioner element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(long id, Conditioner element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Conditioner temp = session.get(Conditioner.class, id);
        if (temp != null) {
            element.setId(id);
            session.merge(element);
        }
        else
            session.save(element);
        session.getTransaction().commit();
    }
}
