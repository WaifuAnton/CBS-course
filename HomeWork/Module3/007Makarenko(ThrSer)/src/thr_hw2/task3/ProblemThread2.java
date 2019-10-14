package thr_hw2.task3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProblemThread2 extends Thread {
    private Lock curThread = new ReentrantLock();
    @Override
    public void run() {
        curThread.lock();
        try {
            sleep(2000);
            System.out.print("Getting y value: ");
            System.out.println(Main.y);
            System.out.print("Trying to get x value: ");
            sleep(1000);
            System.out.println(Main.x);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            curThread.unlock();
        }
    }
}
