package task2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            File Encryptme = new File("src\\task2\\Encryptme.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Encryptme));
            File IamEncrypted = new File("src\\task2\\IamEnrypted.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(IamEncrypted));
            Pattern pattern = Pattern.compile("(?<!\\S)(?:Без|в|для|за|из|к|на|над|о|об|от|по|под|пред|при|про|с|у|через)(?!\\S)", Pattern.CASE_INSENSITIVE);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String[] strArray = str.split(" ");
                String[] temp = new String[strArray.length];
                String output = "";
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = strArray[i];
                    Matcher matcher = pattern.matcher(temp[i]);
                    if (matcher.matches())
                        temp[i] = "Java";
                    output += (temp[i] + " ");
                }
                bufferedWriter.write(output + "\n");
            }
            bufferedReader.close();
            bufferedWriter.close();
        }
        catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
