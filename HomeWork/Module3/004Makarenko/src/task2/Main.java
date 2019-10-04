package task2;

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("src\\task2\\io.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            String line;
            while (!(line = new Scanner(System.in).nextLine()).equals("q"))
                bufferedWriter.write(line + "\n");
            bufferedWriter.close();
            BufferedReader bufferReader = new BufferedReader(new FileReader(file));
            while ((line = bufferReader.readLine()) != null)
                System.out.println(line);
            bufferReader.close();
        }
        catch (FileNotFoundException notFound) {
            System.out.println(notFound.getMessage());
        }
        catch (BufferOverflowException overflow) {
            System.out.println(overflow.getMessage());
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
