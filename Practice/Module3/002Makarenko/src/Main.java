import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String userStr = scanner.nextLine();
        while (!userStr.equals("end"))
        {
            list.add(userStr);
            userStr = scanner.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            String temp = ((ArrayList<String>)list).get(i);
            System.out.println(temp);
        }
    }
}
