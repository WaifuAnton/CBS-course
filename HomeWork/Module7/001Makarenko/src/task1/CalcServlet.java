package task1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        List<Double> params = new ArrayList<>();
        Enumeration<String> allParams = req.getParameterNames();
        while (allParams.hasMoreElements()) {
            String name = allParams.nextElement();
            String val = req.getParameter(name);
            params.add(Double.valueOf(val));
        }
        double add, mult, div, sub;
        add = mult = div = sub = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><title>calc</title></head></body>");

        for (int i = 0; i < params.size(); i++)
            for (int j = 0; j < params.size(); j++) {
                if (i == j)
                    continue;

                stringBuilder.append("<p>");
                add = CalcOperations.add(params.get(i), params.get(j));
                mult = CalcOperations.mult(params.get(i), params.get(j));
                div = CalcOperations.div(params.get(i), params.get(j));
                sub = CalcOperations.sub(params.get(i), params.get(j));

                stringBuilder.append(params.get(i) + " + " + params.get(j) + " = " + add + "<br>");
                stringBuilder.append(params.get(i) + " - " + params.get(j) + " = " + sub + "<br>");
                stringBuilder.append(params.get(i) + " * " + params.get(j) + " = " + mult + "<br>");
                stringBuilder.append(params.get(i) + " / " + params.get(j) + " = " + div + "<br>");
                stringBuilder.append("</p>");
           }

       String code = stringBuilder.toString();
       writer.print(code);
       writer.close();
    }
}
