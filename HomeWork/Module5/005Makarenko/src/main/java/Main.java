import entity.Book;

/**
 * Created by Asus on 04.11.2017.
 */
public class Main {

 //   private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        BookHelper bh = new BookHelper();
        Book book = new Book();
        book.setName("Not War and Peace");
        bh.update(2, book);
        bh.getSessionFactory().close();
    }

}
