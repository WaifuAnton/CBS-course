import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> families = new HashMap<>();
        families.put("Moscow", "Ivanov");
        families.put("Kyiv", "Petrov");
        families.put("London", "Abramovich");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.next();
        System.out.println(families.get(city));
    }
}
