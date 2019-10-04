import java.util.Scanner;

public class Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of clients: ");
        int n = scanner.nextInt();
        int result = 1, mult = 1;
        do {
            result *= mult++;
        } while (mult <= n);
        System.out.println("The amount of possible ways is " + result);
    }
}
