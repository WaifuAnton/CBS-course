package command;

import interfaces.Command;

import javax.servlet.http.HttpServletRequest;

public class ReturnDeviceCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return null;
    }
}
