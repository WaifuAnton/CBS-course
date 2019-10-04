import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Mari Ivanna");
        list.add("Olga Olga");
        list.add("Fizruk");
        list.add("He will be the last to show");
        list.add("Headmaster");
        list.add("A guy who will survive");
        list.add("A guy who will betray");
        list.add("He will be the first to show");
        int index1 = list.indexOf("He will be the first to show");
        System.out.println(list.get(index1));
        int index2 = list.indexOf("He will be the last to show");
        System.out.println(list.get(index1));
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
