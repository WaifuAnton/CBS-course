import java.util.Scanner;

public class Parity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        String result1 = (num ^ 1) == num + 1 ? "Even" : "Odd";
        System.out.println(result1);
        String result2 = (num & 1) == 0 ? "Even" : "Odd";
        System.out.println(result2);
    }
}
