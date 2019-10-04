package task2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            File Encryptme = new File("src\\task2\\Encryptme.txt");
            FileReader reader = new FileReader(Encryptme);
        }
        catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
