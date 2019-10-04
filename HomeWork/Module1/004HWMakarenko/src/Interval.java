import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int num = sc.nextInt();
        if (num >= 0 && num <= 14)
            System.out.println("[0 - 14]");
        else if (num > 14 && num <= 35)
            System.out.println("[15 - 35]");
        else if (num > 35 && num <= 50)
            System.out.println("[36 - 50]");
        else if (num > 50 && num <= 100)
            System.out.println("[50 - 100]");
        else
            System.out.println("Outside the range of [0 -100]");
    }
}
