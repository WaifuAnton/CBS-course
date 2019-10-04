import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = 4;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(scanner.next());
        }
        String city;
        System.out.print("City: ");
        city = scanner.next();
        for (int i = 0; i < N; i += 2) {
            if (arrayList.get(i).equals(city)) {
                System.out.println(arrayList.get(i + 1));
                break;
            }
        }
    }
}
