import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String login, password;
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher;
        do {
            System.out.println("Enter your login: ");
//            login = scanner.next();
            login = "Login";
            matcher = pattern.matcher(login);
        } while (!matcher.matches());
        pattern = Pattern.compile("([a-z]+[A-Z]+[0-9]+)");
        password = "AAAAAf+f89";
        matcher = pattern.matcher(password);
        System.out.println(matcher.matches());
//        do {
//            System.out.println("Enter your password: ");
////            password = scanner.next();
//            password = "RanDom_pasS12";
//            matcher = pattern.matcher(password);
//        } while (!matcher.matches());
    }
}
