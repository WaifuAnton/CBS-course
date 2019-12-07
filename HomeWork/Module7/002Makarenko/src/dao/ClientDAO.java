package dao;

import java.util.List;
import entity.Client;

public interface ClientDAO {

    List<Client> getAll();

    void add(Client client);

    Client getById(int id);

    void updateAge(int id, int newAge);

    void remove(int id);

}
