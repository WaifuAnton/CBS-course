import java.util.ArrayList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext())
        {
            int temp = iterator.next();
            iterator.set(temp + 1);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
    }
}
