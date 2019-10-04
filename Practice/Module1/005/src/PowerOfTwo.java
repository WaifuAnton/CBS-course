import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.print("Enter your value: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String result = (num & num - 1) == 0 ? "YES" : "NO";
        System.out.println(result);
    }
}
