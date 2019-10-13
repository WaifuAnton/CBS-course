package thr_practice2;

public class Normal extends Thread {
    @Override
    public void run() {
        System.out.println("Inside normal thread");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting normal thread");
    }
}
