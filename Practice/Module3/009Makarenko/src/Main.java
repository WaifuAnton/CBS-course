import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        Calculateble calcSum = (a, b) -> a + b;
        Calculateble calcDiff = (a, b) -> a - b;
        Calculateble calcMult = (a, b) -> a * b;
        Calculateble calcDiv = (a, b) -> {
            if (b == 0)
                System.out.print("Dividing by zero, ");
            return a / b;
        };
        System.out.println(calcSum.Calculate(x, y));
        System.out.println(calcDiff.Calculate(x, y));
        System.out.println(calcMult.Calculate(x, y));
        System.out.println(calcDiv.Calculate(x, y));
    }
}
