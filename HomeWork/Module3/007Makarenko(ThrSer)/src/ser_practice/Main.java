package ser_practice;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("src\\ser_practice\\animals.bin");
        try {
            Animal cat = new Animal("cat", 5, 7);
            Animal human = new Animal();
            Animal dog = new Animal("dog", 7, 26);
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(cat);
            outputStream.writeObject(human);
            outputStream.writeObject(dog);
            outputStream.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
