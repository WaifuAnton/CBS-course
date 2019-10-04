package task2;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        final int N = 1;
        Worker[] workers = new Worker[N];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < workers.length; i++) {
            System.out.println("Worker #" + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Position: ");
            String position = scanner.nextLine();
            System.out.print("Works from: ");
            String date = scanner.nextLine();
            workers[i] = new Worker(name, position, date);
        }
        System.out.print("Enter desired experience: ");
        int experience = scanner.nextInt();
        for (int i = 0; i < workers.length; i++) {
            int curExp = LocalDate.now().getYear() - (workers[i].getDate().getYear() + 1900);
            if (curExp > experience)
                System.out.println(workers[i]);
        }
    }
}
