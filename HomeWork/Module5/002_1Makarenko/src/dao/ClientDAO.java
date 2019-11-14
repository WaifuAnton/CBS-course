package dao;

import java.util.List;
import entities.Client;

/**
 * Created by Asus on 31.01.2018.
 */
public interface ClientDAO {

    List<Client> getAll();

    void add(Client client);

    Client getById(int id);

    void updateAge(int id, int newAge);

    void remove(int id);

}
