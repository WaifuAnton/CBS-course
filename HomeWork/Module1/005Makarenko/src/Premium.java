import java.util.Scanner;

public class Premium {
    public static void main(String[] args) {
        System.out.print("Enter experience (in years): ");
        Scanner scanner = new Scanner(System.in);
        int years = scanner.nextInt();
        if (years < 0)
        {
            System.out.println("Experience cannot be negative");
            return;
        }
        System.out.print("Enter a salary: ");
        double salary = scanner.nextDouble();
        double premium = 0;
        if (years < 5)
            premium = salary * 0.1;
        else if (5 <= years && years < 10)
            premium = salary * 0.15;
        else if (10 <= years && years < 15)
            premium = salary * 0.25;
        else if (15 <= years && years < 20)
            premium = salary * 0.35;
        else if (20 <= years && years < 25)
            premium = salary * 0.45;
        else
            premium = salary * 0.5;
        System.out.println("For a person with " + years + " years of experience premium is " + premium);
    }
}
