package pack;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File readme = new File("src\\pack\\readme.txt");
            FileReader reader = new FileReader(readme);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
