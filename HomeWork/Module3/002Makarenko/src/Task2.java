import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String userStr;
        final int N = 5;
        for (int i = 0; i < N; i++) {
            userStr = scanner.next();
            list.add(userStr);
        }
        doubleValues((ArrayList<String>) list);
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> tmp = (ArrayList<String>) list;
            System.out.println(tmp.get(i));
        }
    }

    static void doubleValues(ArrayList<String> list)
    {
        int n = list.size();
        ArrayList<String> tmp = new ArrayList<>();
        tmp.addAll(list);
        for (int i = 0, j = 0; i < tmp.size(); i++, j += 2) {
            list.add(j, tmp.get(i));
        }
    }
}
