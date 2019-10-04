import java.util.Scanner;

public class MainCode {
    public static void main(String[] args) {
        System.out.print("Enter 3-digit number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = 0;
        for (int i = 0; i < 3; i++)
        {
            int n = num % 10;
            result += n;
            num /= 10;
        }
        System.out.println("result = " + result);
    }
}
