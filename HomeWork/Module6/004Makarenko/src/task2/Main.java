package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import task2.entity.Currency;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String nbu = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        try {
            URL url = new URL(nbu);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Currency[] currencies = gson.fromJson(reader, Currency[].class);
            Currency[] task = new Currency[4];
            for (int i = 0, n = 0; i < currencies.length; i++) {
                Currency temp = currencies[i];
                boolean condition = temp.getCc().equals("RUB") || temp.getCc().equals("EUR") || temp.getCc().equals("CNY")
                        || temp.getCc().equals("USD");
                if (condition)
                    task[n++] = temp;
            }
            for (int i = 0; i < task.length; i++)
                System.out.println(task[i]);
        }
        catch (MalformedURLException e) {
            System.out.println(e.getCause());
        }
        catch (IOException e) {
            System.out.println(e.getCause());
        }
//        Currency[] currencies =
    }
}
