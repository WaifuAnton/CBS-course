import java.util.Scanner;

public class Calculator {
    static double average(int n1, int n2, int n3) {
        return (n1 + n2 + n3) / 3.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt(),
                n2 = scanner.nextInt(),
                n3 = scanner.nextInt();
        System.out.println(average(n1, n2, n3));
    }
}
