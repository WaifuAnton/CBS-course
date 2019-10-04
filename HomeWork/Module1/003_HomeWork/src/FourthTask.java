import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("h = ");
        double h = sc.nextDouble();
        System.out.print("R = ");
        double R = sc.nextDouble();
        double V = Math.PI * R*R * h,
                S = 2 * Math.PI * R * (R + h);
        System.out.println("V = " + V + "\nS = " + S);
    }
}
