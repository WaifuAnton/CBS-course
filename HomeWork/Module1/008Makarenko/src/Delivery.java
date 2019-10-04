import java.util.Scanner;

public class Delivery {
    static long factorial(int n)
    {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        /*
        Рекурсія використовує стек для зберігання і доступу до даних. При роботі дані спочатку записуються в стек, а потім,
        при досягненні певної умови, починають читатися з принципом LIFO і оброблятися в решті коду. Для обчислення факторіалу
        перебор більш ефективний, бо він одразу виконує дію над числами, не чекаючи запису в стек; хоча алгоритми, для яких
        найкраще підходить рекурсія, існують (той же QuickSort або дерева)
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        System.out.println("The number of possible ways is " + factorial(n));
    }
}
