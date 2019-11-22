package ex_001_select_and_insert;



import ex_001_select_and_insert.entity.Author;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class Main {

 //   private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

        Author author = new Author();

        author.setName("Nikolay");

        ah.addAuthor(author);



        List<Author> authorList = ah.getAuthorList();

        for (Author a : authorList) {
          System.out.println(a.getId() + " " + a.getName());
         }

         HibernateUtil.getSessionFactory().close();

    }

}
