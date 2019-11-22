package ex_003_generated_id;

import ex_003_generated_id.entity.Author;

import java.util.List;

/**
 * Created by Asus on 04.11.2017.
 */
public class Main {

 //   private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
         AuthorHelper ah = new AuthorHelper();

        Author newAuthor = new Author("Andrey");
        newAuthor.setLastName("Andreev");
        ah.addAuthor(newAuthor);

         List<Author> authors = ah.getAuthorList();

        for (Author author : authors ) {
            System.out.println(author.getId() + " " + author.getName() + " " + author.getLastName());
        }




    }

}
