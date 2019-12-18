package command;

import entity.User;
import helper.UserHelper;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("name");
        String password = req.getParameter("password");

        UserHelper userHelper = new UserHelper();
        User user = userHelper.getByLogin(login);

        boolean exists = user != null;
        if (exists) {
            req.getSession().setAttribute("user", user);
        }
        else
            req.setAttribute("doesNotExist", "Can't find the user");
        return exists ? "controller?action=main" : "login.jsp";
    }
}
