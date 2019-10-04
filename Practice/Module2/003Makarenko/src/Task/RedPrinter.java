package Task;

public class RedPrinter extends Printer {
    @Override
    public void print(String value) {
        System.err.println(value);
    }
}
