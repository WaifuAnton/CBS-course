package task3;

import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            File randomNum = new File("src\\task3\\randomNum.bin");
            Random random = new Random();
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(randomNum));
            final int N = 5100;
            int i = 0;
            while (i++ < N)
                outputStream.writeInt(random.nextInt() % 100);
            outputStream.close();
            DataInputStream inputStream = new DataInputStream(new FileInputStream(randomNum));
            while (inputStream.available() > 0)
                System.out.println(inputStream.readInt() + " ");
            inputStream.close();
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
