package Task;

public class GreenPrinter extends Printer {
    @Override
    public void print(String value) {
        super.print(value);
        System.out.println((char)27 + "[34m" + value);
    }
}
