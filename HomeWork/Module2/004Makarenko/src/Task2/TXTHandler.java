package Task2;

public class TXTHandler extends AbstractHandler {
    @Override
    public void open() {
        System.out.println("TXT document is opened");
    }

    @Override
    public void create() {
        System.out.println("TXT document is created");
    }

    @Override
    public void change() {
        System.out.println("TXT document is changed");
    }

    @Override
    public void save() {
        System.out.println("TXT document is saved");
    }
}
