import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        final int n = 8;
        ArrayList<String> animalList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String animal = scanner.next();
            animalList.add(i, animal);
        }
        System.out.println(animalList);
        animalList.remove(7);
        animalList.remove(5);
        animalList.remove(3);
        System.out.println("after removing:");
        System.out.println(animalList + ", size = " + animalList.size());
    }
}
