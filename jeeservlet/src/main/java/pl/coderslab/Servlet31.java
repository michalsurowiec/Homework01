package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet (urlPatterns = "/servlet31")
public class Servlet31 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;UTF-8");

        Map<String, Double> map = new HashMap<>();
        map.put("EUR->USD", 1.1234);
        map.put("USD->EUR", 0.8902);
        map.put("EUR->PLN", 4.2782);
        map.put("PLN->EUR", 0.2337);
        map.put("USD->PLN", 3.7929);
        map.put("PLN->USD", 0.2637);

        double amount = Double.parseDouble(req.getParameter("amount"));
        resp.getWriter().println(amount * map.get(req.getParameter("exchangeType")));
    }
}
