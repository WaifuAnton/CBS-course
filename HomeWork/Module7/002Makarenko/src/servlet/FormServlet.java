package servlet;

import dao.ClientHelper;
import entity.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");

        Client client = new Client(0, name, age, phone, password);
        ClientHelper clientHelper = new ClientHelper();
        List<Client> allClients = clientHelper.getAll();

        boolean exists = false;
        for (Client temp : allClients)
            if (client.equals(temp)) {
                exists = true;
                break;
            }
        if (!exists)
            clientHelper.add(client);

        req.setAttribute("clients", clientHelper.getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("clients.jsp");
        requestDispatcher.forward(req, resp);
    }
}
