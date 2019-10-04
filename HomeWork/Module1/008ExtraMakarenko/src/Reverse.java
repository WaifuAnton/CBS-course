import java.util.Scanner;

public class Reverse {
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

    static int reverse(int num)
    {
        int result = 0;
        for (int i = numberOfDigits(num); i > 0; i--) {
            int temp = num % 10;
            result += temp * Math.pow(10, i - 1);
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print("Value: ");
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        System.out.println(reverse(val));
    }
}
