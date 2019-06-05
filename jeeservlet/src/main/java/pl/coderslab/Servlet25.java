package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@WebServlet(urlPatterns = "/servlet25")
public class Servlet25 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random rng = new Random();
        int[] tableRNG = new int[10];

        resp.getWriter().println("Tablica 10 losowych nieposortowanych liczb");
        for (int i = 0; i < 10; i++) {
            tableRNG[i] = rng.nextInt(100) + 1;
            resp.getWriter().print(tableRNG[i] + ", ");
        }

        resp.getWriter().println("\n\nTablica 10 posortowanych liczb");
        Arrays.sort(tableRNG);
        for (int randomNumber : tableRNG) {
            resp.getWriter().print(randomNumber + ", ");
        }
    }
}
