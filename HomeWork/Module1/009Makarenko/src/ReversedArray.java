import java.util.Scanner;

public class ReversedArray {
    static void showArray(final int[] array)
    {
        for (int a : array)
            System.out.print(a + " ");
        System.out.println();
    }

    static int[] myReverse(final int[] array)
    {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = array[array.length - i - 1];
        return result;
    }

    static int[] subArray(final int[] array, int index, int count)
    {
        int[] result = new int[count];
        for (int i = 0; i < array.length; i++)
            result[i] = array[i];
        if (count > array.length)
            for (int i = array.length; i < count; i++)
                result[i] = 1;
        return result;
    }

    public static void main(String[] args) {
        final int N = 5;
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 40 -20);
        }
        showArray(array);
        int[] reverse = myReverse(array);
        showArray(reverse);
        Scanner scanner = new Scanner(System.in);
        int index, count;
        System.out.print("index (less then " + array.length + "): ");
        index = scanner.nextInt();
        System.out.print("count: ");
        count = scanner.nextInt();
        int[] sub = subArray(array, index, count);
        showArray(sub);
    }
}
