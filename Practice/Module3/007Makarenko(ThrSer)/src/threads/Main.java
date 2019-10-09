package threads;

public class Main {
    public static void main(String[] args) {
        Class1 c1 = new Class1();
        Class2 c2 = new Class2();
        Class3 c3 = new Class3();
        c1.start();
        c2.start();
        c3.start();
    }
}
