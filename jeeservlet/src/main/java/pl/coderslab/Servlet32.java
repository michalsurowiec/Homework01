package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/servlet32")
public class Servlet32 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;UTF-8");

        String userNumber = req.getParameter("binaryNumber");
        int decimalNumber = 0;
        int power = 0;
        if (Pattern.matches("^[01]+$", userNumber)) {
            for (int i = userNumber.length() - 1; i >= 0; i--) {
                if (userNumber.charAt(i) == '1') {
                    decimalNumber += Math.pow(2, power);
                }
                power++;
            }
            resp.getWriter().println(userNumber + " to liczba " + decimalNumber);
        } else {
            resp.getWriter().println("Niepoprawna liczba!");
        }

    }
}
