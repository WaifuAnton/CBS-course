package threads;

public class Class1 extends Thread {
    private int i = 1;

    public int getI() {
        System.out.println("In Class1");
        System.out.println("i = " + i + '\n');
        return i;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        getI();
    }
}
