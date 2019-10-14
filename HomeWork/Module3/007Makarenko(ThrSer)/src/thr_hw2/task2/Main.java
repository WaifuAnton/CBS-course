package thr_hw2.task2;

public class Main {
    public static Integer x = 10, y = 5;
    public static void main(String[] args) {
        ProblemThread1 problem1 = new ProblemThread1();
        ProblemThread2 problem2 = new ProblemThread2();
        problem1.start();
        problem2.start();
    }
}

