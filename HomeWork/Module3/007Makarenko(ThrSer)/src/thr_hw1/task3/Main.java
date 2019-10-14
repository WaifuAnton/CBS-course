package thr_hw1.task3;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        PriorityThread min = new PriorityThread(i);
        PriorityThread max = new PriorityThread(min.getLimit());
        PriorityThread norm = new PriorityThread(max.getLimit());
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        norm.setPriority(Thread.NORM_PRIORITY);
        min.start();
        norm.start();
        max.start();
    }
}
