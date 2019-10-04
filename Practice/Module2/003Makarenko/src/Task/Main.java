package Task;

public class Main {
    public static void main(String[] args) {
        Printer redPrinter = new RedPrinter();
        redPrinter.print("RED ALERT");
        Printer greenPrinter = new GreenPrinter();
        greenPrinter.print("GREEN ALERT");
    }
}
