package Task2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side1, side2;
        System.out.print("side1: ");
        side1 = scanner.nextDouble();
        System.out.print("side2: ");
        side2 = scanner.nextDouble();
        Rectangle rectangle = new Rectangle();
        rectangle.setSide1(side1);
        rectangle.setSide2(side2);
        System.out.println("Area = " + rectangle.area());
        System.out.println("Perimeter = " + rectangle.perimeter());
    }
}