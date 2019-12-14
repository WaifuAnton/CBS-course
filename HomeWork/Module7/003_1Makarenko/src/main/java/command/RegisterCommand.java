package command;

import entity.User;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    @Override
    public void execute(HttpServletRequest req) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

    }
}
