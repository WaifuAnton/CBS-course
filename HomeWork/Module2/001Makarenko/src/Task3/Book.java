package Task3;

public class Book {
    public static void main(String[] args) {
        Author author = new Author("Strange Guy");
        Title title = new Title("Stranger");
        Content content = new Content("Some Strange Guy was writing a Strange book");
        author.show();
        title.show();
        content.show();
    }
}
