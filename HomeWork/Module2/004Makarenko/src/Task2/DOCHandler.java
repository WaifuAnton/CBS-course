package Task2;

public class DOCHandler extends AbstractHandler {
    @Override
    public void save() {
        System.out.println("DOC document is saved");
    }

    @Override
    public void open() {
        System.out.println("DOC document is opened");
    }

    @Override
    public void change() {
        System.out.println("DOC document is changed");
    }

    @Override
    public void create() {
        System.out.println("DOC document is created");
    }
}
