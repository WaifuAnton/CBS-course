package interfaces;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    public void execute(HttpServletRequest req);
}
