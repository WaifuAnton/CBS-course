import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        setIntegerList(linkedList, N);
        System.out.println(getMinimum(linkedList));
    }

    static void setIntegerList(LinkedList<Integer> linkedList, int N)
    {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            linkedList.add(num);
        }
    }

    static int getMinimum(LinkedList<Integer> linkedList)
    {
        int min = linkedList.getFirst();
        for (int i = 0; i < linkedList.size(); i++) {
            if (min > linkedList.get(i))
                min = linkedList.get(i);
        }
        return min;
    }
}
