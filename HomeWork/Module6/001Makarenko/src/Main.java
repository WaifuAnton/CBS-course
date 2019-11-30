import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/computers.xml");
//        Pattern pattern = Pattern.compile("^<*>$");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                int index = line.lastIndexOf('/');
                if (index >= 0)
                    line = line.substring(0, index + 1);
                if (Pattern.matches("^< |\t*.+/$", line)) {
                    int index1 = line.indexOf('>');
                    int index2 = line.lastIndexOf('<');
                    System.out.println(line.substring(index1 + 1, index2));
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
