import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        final double PI = 3.14159265359;
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        double area = PI * Math.pow(radius, 2);
        System.out.println(area);
    }
}
