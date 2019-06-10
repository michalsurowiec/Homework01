package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = "/servlet352")
public class Servlet352 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;UTF-8");

        HttpSession session = req.getSession();
        List<Product> list = (List<Product>) session.getAttribute("basket");
        PrintWriter out = resp.getWriter();

        double totalSum = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            double sum = product.getPrice() * product.getQuantity();
            totalSum += sum;
            out.println(product.getName() + " - " + product.getQuantity() + " x " + product.getPrice() + "zł = " + sum + "zł");
        }
        out.println("SUMA: " + totalSum);
    }
}
