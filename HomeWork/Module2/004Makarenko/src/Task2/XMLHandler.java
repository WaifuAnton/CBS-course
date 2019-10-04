package Task2;

public class XMLHandler extends AbstractHandler {
    @Override
    public void open() {
        System.out.println("XML document is opened");
    }

    @Override
    public void create() {
        System.out.println("XML document is created");
    }

    @Override
    public void change() {
        System.out.println("XML document is changed");
    }

    @Override
    public void save() {
        System.out.println("XML document is saved");
    }
}
