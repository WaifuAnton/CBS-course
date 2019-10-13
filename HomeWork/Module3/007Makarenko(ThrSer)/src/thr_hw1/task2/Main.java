package thr_hw1.task2;

public class Main {
    public static void main(String[] args) {
        First first = new First();
        Second second = new Second();
        System.out.println("Inside main thread");
        first.start();
        second.start();
    }
}
