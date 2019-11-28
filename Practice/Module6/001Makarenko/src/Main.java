import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/computers.xml");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null)
                System.out.println(line);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
