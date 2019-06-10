package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet (urlPatterns = "/servlet351")
public class Servlet351 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;UTF-8");

        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        String productAdded = "";

        if (session.getAttribute("basket") != null) {
            productAdded = "Produkt został dodany";
        }

        out.println("<form action='' method='post'>");
        out.println("nazwa <input type='text' name='name'/><br>");
        out.println("liczba <input type='number' name='quantity'/><br>");
        out.println("cena <input type='text' name='price'/><br>");
        out.println("<input type='submit' value='wyślij'/>");
        out.println("</form>");

        if (!(productAdded.equals(""))) {
            out.println(productAdded);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("basket") == null) {
            session.setAttribute("basket", new ArrayList<Product>());
        }

        List list = (List<Product>) session.getAttribute("basket");
        list.add(new Product(req.getParameter("name"), Integer.parseInt(req.getParameter("quantity")), Double.parseDouble(req.getParameter("price"))));
        session.setAttribute("basket", list);

    }
}
