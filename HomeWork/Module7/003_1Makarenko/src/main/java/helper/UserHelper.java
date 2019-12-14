package helper;

import entity.Kettle;
import entity.User;
import org.hibernate.Criteria;

import java.util.List;

public class UserHelper extends Helper<User> {
    @Override
    public List<User> getAll() {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    @Override
    public User getById(long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void add(User element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(long id, User element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User temp = session.get(User.class, id);
        if (temp != null) {
            element.setId(id);
            session.merge(element);
        }
        else
            session.save(element);
        session.getTransaction().commit();
    }
}
