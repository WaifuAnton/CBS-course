import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        int height = 0, width = 0;
        System.out.print("Enter the height: ");
        Scanner scanner = new Scanner(System.in);
        height = scanner.nextInt();
        System.out.print("Enter the width: ");
        width = scanner.nextInt();
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
