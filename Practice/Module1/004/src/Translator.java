import java.util.Scanner;

public class Translator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String RusWord = sc.next();
        switch (RusWord)
        {
            case "сухой":
                System.out.println("dry");
                break;
            case "ясный":
                System.out.println("bright");
                break;
            case "жаркий":
                System.out.println("hot");
                break;
            case "солнечный":
                System.out.println("sunny");
                break;
            case "теплый":
                System.out.println("warm");
                break;
            case "холодный":
                System.out.println("cold");
                break;
            case "прохладный":
                System.out.println("cool");
                break;
            case "облачный":
                System.out.println("cloudy");
                break;
            case "морозный":
                System.out.println("frosty");
                break;
            case "ветреный":
                System.out.println("windy");
                break;
            default:
                System.out.println("нет слова");
                break;
        }
    }
}
