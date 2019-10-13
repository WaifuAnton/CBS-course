package thr_hw1.task3;

public class Main {
    public static void main(String[] args) {
        PriorityThread min = new PriorityThread();
        PriorityThread norm = new PriorityThread();
        PriorityThread max = new PriorityThread();
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        norm.setPriority(Thread.NORM_PRIORITY);
        min.start();
        norm.start();
        max.start();
    }
}
