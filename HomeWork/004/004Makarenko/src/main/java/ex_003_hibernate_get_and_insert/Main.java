package ex_003_hibernate_get_and_insert;

import ex_003_hibernate_get_and_insert.entity.Author;
import ex_003_hibernate_get_and_insert.entity.Book;

/**
 * Created by Asus on 01.11.2017.
 */
public class Main {

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        BoolHelper bh = new BoolHelper();

        for (int i = 0; i < 100; i++) {
            Author author = new Author();
            author.setName("Lev" + (i + 1));
            author.setLastName("Tolstoy" + (i + 1));
            ah.addAuthor(author);
        }

        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            Author author = ah.getAuthorById(i + 1);
            book.setAuthor_id(author.getId());
            book.setName("War and Peace" + (i + 1));
            bh.addBook(book);
        }

        ah.getSessionFactory().close();
        bh.getSessionFactory().close();
    }
}
