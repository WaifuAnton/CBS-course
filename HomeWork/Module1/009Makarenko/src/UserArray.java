import java.util.Scanner;

public class UserArray {
    static void showArray(final int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static int[] increaseLengthByOne(int[] array)
    {
        int[] temp = array;
        array = new int[temp.length + 1];
        for (int i = 0; i < temp.length; i++)
            array[i] = temp[i];
        array[array.length - 1] = 0;
        return array;
    }

    static int[] addToBegin(int[] array, int value)
    {
        int[] temp = array;
        array = new int[temp.length + 1];
        array[0] = value;
        for (int i = 0; i < temp.length; i++) {
            array[i + 1] = temp[i];
        }
        return array;
    }

    public static void main(String[] args) {
        final int N = 5;
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++)
            array[i] = (int)(Math.random() * 40 -20);
        array = increaseLengthByOne(array);
        showArray(array);
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        array = addToBegin(array, num);
        showArray(array);
    }
}
