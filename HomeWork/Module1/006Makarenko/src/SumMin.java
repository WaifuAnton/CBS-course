import java.util.Scanner;

public class SumMin {
    public static void main(String[] args) {
        System.out.println("---Task 1---");
        System.out.print("Enter the first number: ");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        int sum = 0;
        for (int i = num1; i <= num2; i++)
            sum += i;
        System.out.println("Sum = " + sum);
        System.out.println("---Task2---");
        System.out.print("Enter the first number: ");
        num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        num2 = scanner.nextInt();
        sum = 0;
        for (int i = num1; i <= num2; i++)
            if (i % 2 == 1)
                System.out.print(i + " ");
    }
}
