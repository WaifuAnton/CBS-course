package thr_hw2.task3;

public class Main {
    static Integer x = 10, y = 5;
    public static void main(String[] args) {
        ProblemThread1 problem1 = new ProblemThread1();
        ProblemThread2 problem2 = new ProblemThread2();
        problem1.start();
        problem2.start();
    }
}

