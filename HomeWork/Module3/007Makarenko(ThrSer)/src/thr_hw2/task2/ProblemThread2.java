package thr_hw2.task2;

public class ProblemThread2 extends Thread {
    @Override
    public void run() {
        synchronized (Main.y) {
            System.out.println("Getting y value");
            try {
                sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Trying to get x value");
            synchronized (Main.x) {
                System.out.println("Getting x value");
            }
        }
    }
}
