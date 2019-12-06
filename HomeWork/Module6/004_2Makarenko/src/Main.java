import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entitiy.Client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        URL url = new URL("http://localhost:8080/web_war_exploded/task?table=client");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Client[] clients;
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        clients = gson.fromJson(reader, Client[].class);
        for (Client client : clients)
            System.out.println(client.getName());
    }
}
