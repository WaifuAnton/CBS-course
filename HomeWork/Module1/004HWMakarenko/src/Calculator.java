import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class Calculator {
    public static void main(String[] args) {
        double operator1 = Math.random() * 100,
                operator2 = Math.random() * 100;
        System.out.print("Enter a sign: ");
        Scanner sc = new Scanner(System.in);
        String sign = sc.next();
        switch (sign)
        {
            case "+":
                System.out.println(operator1 + " + " + operator2 + " = " + (operator1 + operator2));
                break;
            case "-":
                System.out.println(operator1 + " - " + operator2 + " = " + (operator1 - operator2));
                break;
            case "*":
                System.out.println(operator1 + " * " + operator2 + " = " + (operator1 * operator2));
                break;
            case "/":
                System.out.println(operator1 + " / " + operator2 + " = " + (operator1 / operator2));
                break;
            case "^":
                System.out.println(operator1 + " ^ " + operator2 + " = " + Math.pow(operator1, operator2));
                break;
            default:
                System.out.println("No such operator");
        }
    }
}
