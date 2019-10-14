package thr_hw2.task3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProblemThread1 extends Thread {
    private Lock curThread = new ReentrantLock();
    @Override
    public void run() {
        curThread.lock();
        try {
            sleep(1000);
            System.out.print("Getting x value: ");
            System.out.println(Main.x);
            System.out.print("Trying to get y value: ");
            sleep(500);
            System.out.println(Main.y);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            curThread.unlock();
        }
    }
}
