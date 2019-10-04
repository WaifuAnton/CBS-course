import java.util.List;
import java.util.Scanner;

public class Calculation {
    static boolean isPrime(int num)
    {
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0)
                return false;
        return true;
    }

    static void factorization(int num)
    {
        for (int i = 2; i <= num / 2; i++) {
            if (isPrime(i) && num % i == 0)
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        System.out.print("Value: ");
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        factorization(val);
    }
}
