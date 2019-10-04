public class Task3 {
    public static void main(String[] args) {
        System.out.println("---Rectangle---");
        final int height = 5;
        final int width = 5;
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
                System.out.print("*");
            System.out.println();
        }
        System.out.print("\n---Square triangle---");
        for (int i = 0; i <= height; i++)
        {
            for (int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
        System.out.println("\n---Triangle---");
        for (int i = 0; i < height; i++)
        {
            for (int j = height - 1; j > i; j--)
                System.out.print(" ");
            for (int k = 0; k <= i; k++)
                System.out.print("*");
            for (int l = 0; l < i; l++)
                System.out.print("*");
            System.out.println();
        }
        System.out.println("\n---Rhombus---");
        for (int i = 0; i < height - 1; i++)
        {
            for (int j = height - 1; j > i; j--)
                System.out.print(" ");
            for (int k = 0; k <= i; k++)
                System.out.print("*");
            for (int l = 0; l < i; l++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < i; j++)
                System.out.print(" ");
            for (int k = height * 2 - 1 - i; k > i; k--)
                System.out.print("*");
            System.out.println();
        }
    }
}
