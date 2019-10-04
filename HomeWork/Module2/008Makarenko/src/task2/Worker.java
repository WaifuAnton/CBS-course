package task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Worker {
    private String name = "Ivanov I.I.";
    private String position = "manager";
    private Date date;

    public Worker(String name, String position, String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.date = sdf.parse(date);
        }
        catch (ParseException exc) {
            System.out.println("Wrong format, setting up the date to default");
            this.date = sdf.parse("01.01.2000");
        }
        this.name = name;
        this.position = position;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + ", hired in " + date + ", works as " + position;
    }
}
