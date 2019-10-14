package thr_hw2.task2;

public class ProblemThread1 extends Thread {
    @Override
    public void run() {
        synchronized (Main.x) {
            System.out.println("Getting x value");
            try {
                sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Trying to get y value");
            synchronized (Main.y) {
                System.out.println("Getting y value");
            }
        }
    }
}
