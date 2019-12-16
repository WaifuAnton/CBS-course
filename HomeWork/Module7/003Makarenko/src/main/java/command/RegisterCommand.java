package command;

import entity.Salt;
import entity.User;
import helper.MeshPassword;
import helper.SaltHelper;
import helper.UserHelper;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;
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
            byte[] saltB = new byte[32];
            new Random().nextBytes(saltB);
            String hash = MeshPassword.mesh(password, saltB);
            SaltHelper saltHelper = new SaltHelper();
            int id = userHelper.getByLogin(user.getLogin()).getId();
            Salt salt = new Salt(id, new String(saltB));
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        }
        else
            req.setAttribute("notAdd", "User already exists");
        return created ? "main.jsp" : "register.jsp";
    }
}
