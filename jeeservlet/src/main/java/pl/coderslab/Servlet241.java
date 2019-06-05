package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet241")
public class Servlet241 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i <=7; i++) {
            resp.getWriter().println("<a href='http://localhost:8080/jeeservlet_war_exploded/servlet242?id=" + i + "'>Id " + i + "</a> <br>");
        }

    }
}
