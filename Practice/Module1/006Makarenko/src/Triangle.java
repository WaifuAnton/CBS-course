public class Triangle {
    public static void main(String[] args) {
        final int height = 5;
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
