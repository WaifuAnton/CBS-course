import entity.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public BookHelper() { sessionFactory = HibernateUtil.getSessionFactory(); }

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery cq = cb.createQuery(Book.class);
//        Root<Book> root = cq.from(Book.class);
//        cq.select(root);
//        Query<Book> query = session.createQuery(cq);
//        List<Book> bookList = query.getResultList();
        Criteria criteria = session.createCriteria(Book.class);
        List<Book> bookList = criteria.list();
        session.close();
        return bookList;
    }

    public void update(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    public void update(long id, Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book temp = session.get(Book.class, id);
        if (temp != null)
            {
                book.setId(temp.getId());
                session.merge(book);
            }
        else
            session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    public Book getById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book book = session.get(Book.class, id);
        return book;
    }
}
