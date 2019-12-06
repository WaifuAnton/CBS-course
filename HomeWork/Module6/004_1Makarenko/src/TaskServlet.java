import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import task3.dao.CarJDBCDao;
import task3.dao.ClientJDBCDao;
import task3.dao.DAOFactory;
import task3.dao.IDAOFactory;
import task3.entitiy.Car;
import task3.entitiy.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IDAOFactory factory = DAOFactory.getInstance();
        String table = req.getParameter("table");
        PrintWriter writer = resp.getWriter();
        Gson gson = new GsonBuilder().create();
        String data = "";
        switch (table) {
            case "client":
                ClientJDBCDao clientDAO = new ClientJDBCDao();
                List<Client> clients = clientDAO.getAll();
                data = gson.toJson(clients);
//                for (Client client : clients) {
//                    data = gson.toJson(client, Client.class);
//                    writer.write(data + "\n");
//                }
                break;
            case "car":
                CarJDBCDao carJDBCDao = new CarJDBCDao();
                List<Car> cars = carJDBCDao.getAll();
                data = gson.toJson(cars);
//                for (Car car : cars) {
//                    data = gson.toJson(car, Car.class);
//                    writer.write(data + "\n");
//                }
                break;
            default:
                writer.write("Can't find the argument\n");
                return;
        }
        writer.write(data);
        writer.close();
    }
}
