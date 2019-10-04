import java.util.Scanner;

public class Sum {
    static int sumOfDigits(int num)
    {
        int sum = 0;
        int temp = numberOfDigits(num);
        for (int i = 0; i < temp; i++) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    static int numberOfDigits (int num)
    {
        int n = 1;
        while (num / 10 != 0)
        {
            n++;
            num /= 10;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.print("Value: ");
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        System.out.println(sumOfDigits(val));
    }
}
