import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        try {
            URL url = new URL("https://old.bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=EUR&date=20191205&json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Currency[] euros = gson.fromJson(reader, Currency[].class);
            System.out.println(euros[0]);
        }
        catch (MalformedURLException e) {
            System.out.println(e.getCause());
        } catch (IOException e) {
            System.out.println(e.getCause());
        }
    }
}
