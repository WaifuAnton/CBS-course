package ex_002_insert_and_update;

import ex_002_insert_and_update.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Asus on 04.11.2017.
 */
public class Main {

 //   private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        //AuthorHelper ah = new AuthorHelper();
        Author author;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 0; i < 200; i++) {
            author = new Author(("Taras" + (i + 1)), ("Shevchenko" + (i + 1)));
            session.save(author);
            if (i % 10 == 0)
                session.flush();
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
    }

}
