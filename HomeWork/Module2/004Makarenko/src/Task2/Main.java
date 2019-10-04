package Task2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String typeOfDocument;
        AbstractHandler handler = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of document do you open?");
        typeOfDocument = scanner.next();
        typeOfDocument = typeOfDocument.toLowerCase();
        switch (typeOfDocument) {
            case "txt":
                handler = new TXTHandler();
                break;
            case "doc":
                handler = new DOCHandler();
                break;
            case "xml":
                handler = new XMLHandler();
                break;
        }
        if (handler != null) {
            handler.create();
            handler.open();
            handler.change();
            handler.save();
        }
    }
}
