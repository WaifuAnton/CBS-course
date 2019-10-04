import java.util.Scanner;

public class Bank {
    static void accountInformation(int debt)
    {
        Scanner scanner = new Scanner(System.in);
        int payment = 0;
        do {
            System.out.print("Enter your payment: ");
            payment = scanner.nextInt();
            if (payment < 100)
                System.out.println("Too small value");
        } while (payment < 100);
        debt -= payment;
        System.out.println("You gave " + payment + " money. Do you want to continue? (y/n)");
        String answer = scanner.next();
        switch (answer)
        {
            case "y":
                accountInformation(debt);
                break;
            case "n":
                break;
            default:
                System.out.println("Unknown symbol");
                break;
        }
        System.out.println("Your payment is " + payment);
        if (debt < 0)
            System.out.println("Your extra money is " + debt + "\n");
        else
            System.out.println("Your debt is " + debt + "\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your debt: ");
        int debt = scanner.nextInt();
        accountInformation(debt);
    }
}
