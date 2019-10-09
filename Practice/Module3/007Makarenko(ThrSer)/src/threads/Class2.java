package threads;

public class Class2 extends Thread {
    private int i = 2;

    public int getI() {
        System.out.println("In Class2");
        System.out.println("i = " + i + '\n');
        return i;
    }

    @Override
    public void run() {
        try {
            sleep(2000);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        getI();
    }
}
