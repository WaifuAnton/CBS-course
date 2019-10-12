package thr_hw;

public class Class10 extends Thread {
    private static Integer i = 1;

    public Class10(Integer i) {
        this.i = i;
    }

    public Class10() {

    }

    @Override
    public void run() {
            for (int j = 0; j < 10; j++) {
                synchronized (i) {
                    System.out.println(i++);
                    System.out.println(Thread.currentThread().getName());
                }
        }
    }
}
