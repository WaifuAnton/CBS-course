package thr_hw1.task2;

public class Second extends Thread {
    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Inside second thread");
    }
}
