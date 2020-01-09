package command;

import interfaces.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, Command> commands;
    private static CommandFactory factory;

    private CommandFactory() {
        commands = new HashMap<>();
        commands.put("register", new RegisterCommand());
        commands.put("login", new LoginCommand());
        commands.put("main", new MainCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("add_money", new AddMoneyCommand());
    }

    public static CommandFactory getInstance() {
        if (factory == null)
            factory = new CommandFactory();
        return factory;
    }

    public Command getCommand(HttpServletRequest req) {
        String action = req.getParameter("action");
        return commands.get(action);
    }
}
