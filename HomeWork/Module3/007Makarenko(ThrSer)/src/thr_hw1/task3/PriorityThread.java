package thr_hw1.task3;

public class PriorityThread extends Thread {
    @Override
    public void run() {
        System.out.println("Inside thread #" + getId() + " with priority of " + getPriority());
    }
}
