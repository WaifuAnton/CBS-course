import java.util.Scanner;

public class NumbersCheck {
    static boolean isPositive(int num)
    {
        if (num > 0)
        {
            System.out.println("Value is positive");
            return true;
        }
        else if (num < 0)
        {
            System.out.println("Value is negative");
            return false;
        }
        System.out.println("Value is zero");
        return false;
    }

    static boolean isPrime(int num)
    {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
            {
                System.out.println("Value isn't prime");
                return false;
            }
        }
        System.out.println("Value is prime");
        return true;
    }

    static boolean isDividedBy(int num)
    {
        final int[] numbers = {2, 5, 3, 6, 9};
        boolean isDivided = false;
        for (int i = 0; i < numbers.length; i++) {
            if (num % numbers[i] == 0)
            {
                System.out.println("Value is completely divided by " + numbers[i]);
                isDivided = true;
            }
        }
        if (!isDivided)
            System.out.println("Value is not completely divided by any of the numbers");
        return isDivided;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        isPositive(num);
        isPrime(num);
        isDividedBy(num);
    }
}
