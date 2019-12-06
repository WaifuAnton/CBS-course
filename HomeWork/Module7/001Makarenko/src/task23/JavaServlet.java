package task23;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class JavaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("C:\\Users\\makar\\Desktop\\Прога\\Попочка\\Java\\CBS course\\HomeWork\\Module7\\001Makarenko\\web\\java.html");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str;
        while ((str = bufferedReader.readLine()) != null)
            stringBuilder.append(str);
        bufferedReader.close();
        PrintWriter writer = resp.getWriter();
        writer.write(stringBuilder.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
