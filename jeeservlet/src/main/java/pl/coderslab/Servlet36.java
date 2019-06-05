package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet36")
public class Servlet36 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;UTF-8");
        PrintWriter out = resp.getWriter();

        String[] numTable = req.getParameterValues("num");

        double average = 0.0;
        int sum = 0;
        int timeAll = 1;
        out.println("Liczby:");
        for (String number : numTable) {
            out.println(" - " + number);
            sum += Integer.parseInt(number);
            timeAll *= Integer.parseInt(number);
        }
        average = (average+sum) / 4;
        out.println("Średnia:");
        out.println(" - " + average);
        out.println("Suma:");
        out.println(" - " + sum);
        out.println("Iloczyn:");
        out.println(" - " + timeAll);
    }

}
