package helper;

import entity.Author;
import helper.interfaces.BaseDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorHelper implements BaseDAO<Author>, AutoCloseable {
    private SessionFactory sessionFactory;
    private Session session;
    private MP3Helper mp3Helper;

    public void setMp3Helper(MP3Helper mp3Helper) {
        this.mp3Helper = mp3Helper;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        session = sessionFactory.openSession();
    }

    public void close() {
        session.close();
        sessionFactory.close();
    }

    public int add(Author entity) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        return entity.getId();
    }

    public int addList(List<Author> entities) {
        session.beginTransaction();
        for (Author entity : entities)
            session.save(entity);
        session.getTransaction().commit();
        return entities.get(0).getId();
    }

    public Author getById(int id) {
        return session.get(Author.class, id);
    }

    public List<Author> getAll() {
        Criteria criteria = session.createCriteria(Author.class);
        return criteria.list();
    }

    public boolean delete(int id) {
        session.beginTransaction();
        Author author = getById(id);
        if (author == null) {
            session.getTransaction().commit();
            return false;
        }
        session.delete(author);
        session.getTransaction().commit();
        return true;
    }

    public boolean update(int id, Author entity) {
        session.beginTransaction();
        Author author = getById(id);
        if (author == null) {
            session.getTransaction().commit();
            return false;
        }
        session.merge(entity);
        session.getTransaction().commit();
        return true;
    }

    public Map<String, Integer> groupByNames() {
        Map<String, String> temp = mp3Helper.getAllMapped();
        List<Author> all = getAll();
        Map<String, Integer> result = new HashMap<>();
        for (Author author : all) {
            int n = 0;
            for (String song : temp.keySet())
                if (temp.get(song).equals(author.getName()))
                    result.put(author.getName(), ++n);
        }
        return result;
    }
}
