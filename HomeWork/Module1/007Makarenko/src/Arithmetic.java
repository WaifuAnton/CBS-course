import java.util.Scanner;

public class Arithmetic {
    static int add(int op1, int op2)
    {
        return op1 + op2;
    }

    static int sub(int op1, int op2)
    {
        return op1 - op2;
    }

    static int mult(int op1, int op2)
    {
        return op1 * op2;
    }

    static double div(int op1, int op2)
    {
        if (op2 == 0)
        {
            System.out.println("Don't divide by zero!");
            return Double.POSITIVE_INFINITY;
        }
        return (double) op1 / op2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first value: ");
        int op1 = scanner.nextInt();
        System.out.print("Enter the second value: ");
        int op2 = scanner.nextInt();
        System.out.print("Enter a sign: ");
        String sign = scanner.next();
        int result = 0;
        switch (sign)
        {
            case "+":
                result = add(op1, op2);
                System.out.println("The result is " + result);
                break;
            case "-":
                result = sub(op1, op2);
                System.out.println("The result is " + result);
                break;
            case "*":
                result = mult(op1, op2);
                System.out.println("The result is " + result);
                break;
            case "/":
                double division = div(op1, op2);
                System.out.println("The result is " + division);
                break;
        }
    }
}
