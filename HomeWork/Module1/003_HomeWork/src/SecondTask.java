import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        int resultINT = (x + y + z) / 3; //змінна int, втрата точності
        double resultDOUBLE = (x + y + z) / 3.; //змінна double, втрат немає
        System.out.println("INT - " + resultINT);
        System.out.println("DOUBLE - " + resultDOUBLE);
    }
}
