import java.util.Scanner;

public class CustomerArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N: ");
        int N = scanner.nextInt();
        int[] customArray = new int[N];
        int maxValue = customArray[0],
                minValue = customArray[0];
        int sum = 0;
        for (int i = 0; i < customArray.length; i++)
        {
            customArray[i] = (int)(Math.random() * 40) - 20;
            System.out.print(customArray[i] + " ");
            if (maxValue < customArray[i])
                maxValue = customArray[i];
            if (minValue > customArray[i])
                minValue = customArray[i];
            sum += customArray[i];
        }
        System.out.print("\nOdd: ");
        for (int i = 0; i < customArray.length; i++)
            if (customArray[i] % 2 != 0)
                System.out.print(customArray[i] + " ");
        System.out.println("\nsum = " + sum);
        System.out.println("average = " + (double)sum / N);
        System.out.println("min = " + minValue);
        System.out.println("max = " + maxValue);
    }
}
