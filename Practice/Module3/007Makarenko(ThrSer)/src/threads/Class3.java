package threads;

public class Class3 extends Thread {
    private int i = 3;

    public int getI() {
        System.out.println("In Class3");
        System.out.println("i = " + i + '\n');
        return i;
    }

    @Override
    public void run() {
        try {
            sleep(3000);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        getI();
    }
}
