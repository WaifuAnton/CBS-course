package ser_hw.task2;

import ser_practice.Animal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        File file = new File("src\\ser_practice\\animals.bin");
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            Animal cat = (Animal) inputStream.readObject();
            Animal human = (Animal) inputStream.readObject();
            Animal dog = (Animal) inputStream.readObject();
            System.out.println(cat);
            System.out.println(human);
            System.out.println(dog);
            inputStream.close();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
