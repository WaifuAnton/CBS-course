import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.print("Enter a sign: ");
        Scanner scanner = new Scanner(System.in);
        String sign = scanner.next();
        int operator1, operator2;
        System.out.print("1st number: ");
        operator1 = scanner.nextInt();
        System.out.print("2nd number: ");
        operator2 = scanner.nextInt();
        switch (sign) {
            case "+":
                System.out.println(operator1 + " + " + operator2 + " = " + add(operator1, operator2));
                break;
            case "-":
                System.out.println(operator1 + " - " + operator2 + " = " + sub(operator1, operator2));
                break;
            case "*":
                System.out.println(operator1 + " * " + operator2 + " = " + mul(operator1, operator2));
                break;
            case "/":
                System.out.println(operator1 + " / " + operator2 + " = " + div(operator1, operator2));
                break;
            case "^":
                System.out.println(operator1 + " ^ " + operator2 + " = " + Math.pow(operator1, operator2));
                break;
            default:
                System.out.println("No such operator");
        }
    }

    static int add(int op1, int op2)
    {
        return op1 + op2;
    }

    static int sub(int op1, int op2)
    {
        return op1 - op2;
    }

    static int mul(int op1, int op2)
    {
        return op1 * op2;
    }

    static int div(int op1, int op2)
    {
        int result = op1 / op2;
        try {
            return result;
        }
        catch (ArithmeticException arExc) {
            System.out.println("Don't divide by zero!");
            return -1;
        }
    }
}
