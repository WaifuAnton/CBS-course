import java.util.Scanner;

public class Calculator {
    static double divide(int i)
    {
        System.out.print(i + " / 5 = ");
        return i / 5.0;
    }

    static void calculate(int i1, int i2, int i3)
    {
        System.out.println(divide(i1));
        System.out.println(divide(i2));
        System.out.println(divide(i3));
    }

    public static void main(String[] args) {
        System.out.print("i1: ");
        int i1, i2, i3;
        Scanner scanner = new Scanner(System.in);
        i1 = scanner.nextInt();
        System.out.print("i2: ");
        i2 = scanner.nextInt();
        System.out.print("i3: ");
        i3 = scanner.nextInt();
        calculate(i1, i2, i3);
    }
}
