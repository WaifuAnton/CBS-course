package command;

import entity.User;
import helper.UserHelper;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("name");
        String password = req.getParameter("password");
        UserHelper userHelper = new UserHelper();
        Set<User> users = userHelper.getAll();
        User user = new User(login);
        boolean created = false;
        if (!users.contains(user))
        {
            created = true;
            userHelper.add(user);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        }
        else
            req.setAttribute("notAdd", "User already exists");
        return created ? "main.jsp" : "register.jsp";
    }
}
