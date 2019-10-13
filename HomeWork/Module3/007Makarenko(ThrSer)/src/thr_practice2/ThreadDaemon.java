package thr_practice2;

public class ThreadDaemon extends Thread {
    public ThreadDaemon() {
        setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println(getName() + ", id - " + getId() + ", priority - " + getPriority() + ", daemon - " + isDaemon());
    }
}
