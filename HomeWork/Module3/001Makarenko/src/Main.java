import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}
