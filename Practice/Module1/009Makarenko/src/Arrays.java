import java.util.Random;

public class Arrays {
    public static void main(String[] args) {
        final int SIZE = 10;
        int[] array = new int[SIZE];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int)(Math.random() * 100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = array.length - 1; i >=0; i--)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
