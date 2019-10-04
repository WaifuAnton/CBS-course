package task3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Date curDate = new Date(), inputDate;
        try {
            curDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String str = (new Scanner(System.in)).nextLine();
            inputDate = sdf.parse(str);
        }
        catch (ParseException e) {
            e.getMessage();
            System.out.println("Setting up an input date to default");
            inputDate = new Date();
        }
        Date result = new Date(curDate.getTime() - inputDate.getTime());
        System.out.println(result.getYear() + " " + result.getMonth() + " " + result.getDate() + " " + result.getHours() + " " +
                result.getMinutes() + " " + result.getSeconds());
    }
}
