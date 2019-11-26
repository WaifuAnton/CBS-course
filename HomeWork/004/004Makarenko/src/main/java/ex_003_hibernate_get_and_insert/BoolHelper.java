package ex_003_hibernate_get_and_insert;

import ex_003_hibernate_get_and_insert.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BoolHelper {
    private SessionFactory sessionFactory;

    public BoolHelper() { sessionFactory = HibernateUtil.getSessionFactory(); }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Book addBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.close();
        return book;
    }

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Book.class);
        List<Book> bookList = criteria.list();
        session.close();
        return bookList;
    }

    public Book getById(long id) {
        Session session = sessionFactory.openSession();
        Book book = (Book) session.get(Book.class, id);
        session.close();
        return book;
    }
}
