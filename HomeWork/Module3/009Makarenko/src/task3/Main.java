package task3;

public class Main {
    public static void main(String[] args) {
        Anonymous anonymous = new Anonymous() {
            @Override
            public void DoSomething(double val) {
                Lambda lambda = d -> d * d;
                double result = lambda.LFunction(val);
                System.out.println("This function does something with double value");
                System.out.println("The result is " + result);
            }
        };
        anonymous.DoSomething(23.12345);
    }
}
