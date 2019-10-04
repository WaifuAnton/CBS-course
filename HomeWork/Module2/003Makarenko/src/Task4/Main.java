package Task4;
import java.util.Scanner;

public class Main {
    static final int[] proKeys = {
            123,
            456,
            789
    };

    static final int[] expertKeys = {
            987,
            654,
            321
    };

    public static void main(String[] args) {
        DocumentWorker documentWorker = null;
        System.out.print("Do you have a key? (y/n) ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        switch (answer) {
            case "y":
                int key = 0;
                System.out.println("Enter your key: ");
                key = scanner.nextInt();
                for (int i = 0; i < 3; i++) {
                    if (key == proKeys[i]) {
                        System.out.println("You are using pro version");
                        documentWorker = new ProDocumentWorker();
                        break;
                    }
                    else if (key == expertKeys[i]) {
                        System.out.println("You are using expert version");
                        documentWorker = new ExpertDocumentWorker();
                        break;
                    }
                }
                if (documentWorker == null) {
                    System.out.println("You have entered the wrong key. Standard version will be used");
                    documentWorker = new DocumentWorker();
                }
                break;
            default:
                System.out.println("You are using standard version");
                break;
        }
        documentWorker.openDocument();
        documentWorker.editDocument();
        documentWorker.saveDocument();
    }
}
