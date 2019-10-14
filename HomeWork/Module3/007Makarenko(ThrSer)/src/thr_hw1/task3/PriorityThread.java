package thr_hw1.task3;

public class PriorityThread extends Thread {
    private int n, limit;

    public PriorityThread(int n) {
        this.n = n;
        limit = n + 15;
    }

    @Override
    public void run() {
        System.out.println("Inside thread #" + getId() + " with priority of " + getPriority());
        for (int i = n; i < limit; i++) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public int getLimit() {
        return limit;
    }
}
