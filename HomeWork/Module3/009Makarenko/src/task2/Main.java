package task2;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt() % 20 + 1);
            System.out.println(list.get(i));
        }
        int result = list.stream().map(l -> l * l).reduce(0, Integer::sum);
        System.out.println(result);
    }
}
