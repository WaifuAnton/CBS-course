package helper;

import entity.Author;
import entity.MP3;
import helper.interfaces.BaseDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MP3Helper implements BaseDAO<MP3>, AutoCloseable {
    private SessionFactory sessionFactory;
    private Session session;
    private AuthorHelper authorHelper;

    public void setAuthorHelper(AuthorHelper authorHelper) {
        this.authorHelper = authorHelper;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        session = sessionFactory.openSession();
    }

    public int add(MP3 entity) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        return entity.getId();
    }

    public int addList(List<MP3> entities) {
        session.beginTransaction();
        for (MP3 entity : entities)
            session.save(entity);
        session.getTransaction().commit();
        return entities.get(0).getId();
    }

    public MP3 getById(int id) {
        return session.get(MP3.class, id);
    }

    public List<MP3> getAll() {
        Criteria criteria = session.createCriteria(MP3.class);
        return criteria.list();
    }

    public boolean delete(int id) {
        session.beginTransaction();
        MP3 song = getById(id);
        if (song == null) {
            session.getTransaction().commit();
            return false;
        }
        session.delete(song);
        session.getTransaction().commit();
        return true;
    }

    public boolean update(int id, MP3 entity) {
        session.beginTransaction();
        MP3 song = getById(id);
        if (song == null) {
            session.getTransaction().commit();
            return false;
        }
        session.merge(entity);
        session.getTransaction().commit();
        return true;
    }

    public Map<String, String> getAllMapped() {
        List<MP3> all = getAll();
        Map<String, String> result = new HashMap<>();
        for (MP3 mp3 : all) {
            Author author = authorHelper.getById(mp3.getAuthorId());
            result.put(mp3.getSong(), author.getName());
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        session.close();
        sessionFactory.close();
    }
}
