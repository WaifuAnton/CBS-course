import dao.ClientJDBCDao;
import entities.Client;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client0 = new Client(1, "Jago", 32, "093-32-234-234");
        Client client1 = new Client(12, "Some Name", 12, "0988-88-888");
        ClientJDBCDao clientJDBCDao = new ClientJDBCDao();
//        clientJDBCDao.add(client1);
//        clientJDBCDao.add(client0);
//        Client client2 = clientJDBCDao.getById(1);
//        System.out.println(client2);
        List<Client> clients = clientJDBCDao.getAll();
        System.out.println(clients);
        clientJDBCDao.updateAge(6, 38);
        clients = clientJDBCDao.getAll();
        System.out.println(clients);
        clientJDBCDao.remove(6);
        clients = clientJDBCDao.getAll();
        System.out.println(clients);
    }
}
