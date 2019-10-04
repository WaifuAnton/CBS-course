import java.util.Scanner;

public class Conversion {
    static double convert()
    {
        double sumOriginal = 0, exchangeRate = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of money: ");
        sumOriginal = scanner.nextDouble();
        System.out.print("Enter current exchange rate: ");
        exchangeRate = scanner.nextDouble();
        return sumOriginal * exchangeRate;
    }

    public static void main(String[] args) {
        double sumNew = convert();
        System.out.println("Your new amount of new money is " + sumNew);
    }
}
