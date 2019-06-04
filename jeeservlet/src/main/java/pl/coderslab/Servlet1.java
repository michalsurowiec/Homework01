package pl.coderslab;

import org.apache.commons.io.output.StringBuilderWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet1")
public class Servlet1 extends HttpServlet {

    StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        stringBuilderWriter.append("To jest test").append(",czy ten StringBuilder działa jak powinien.").append(" Oby tak");
        PrintWriter out = resp.getWriter();
        out.println(stringBuilderWriter.toString());
    }
}
