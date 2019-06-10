package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/servlet33")
public class Servlet33 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;UTF-8");

        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();

        if (session.getAttribute("text1") == null) {
            session.setAttribute("text1", "");
        }
        if (session.getAttribute("text2") == null) {
            session.setAttribute("text2", "");
        }
        if (session.getAttribute("text3") == null) {
            session.setAttribute("text3", "");
        }
        if (session.getAttribute("text4") == null) {
            session.setAttribute("text4", "");
        }
        if (session.getAttribute("text5") == null) {
            session.setAttribute("text5", "");
        }

        out.println("<form action='' method='post'>");
        out.println("text1<input type='text' name='text1'/ value='" + session.getAttribute("text1") +"'><br>");
        out.println("text2<input type='text' name='text2'/ value='" + session.getAttribute("text2") +"'><br>");
        out.println("text3<input type='text' name='text3'/ value='" + session.getAttribute("text3") +"'><br>");
        out.println("text4<input type='text' name='text4'/ value='" + session.getAttribute("text4") +"'><br>");
        out.println("text5<input type='text' name='text5'/ value='" + session.getAttribute("text5") +"'><br>");
//        out.println("text2<input type='text' name='text2'/><br>");
//        out.println("text3<input type='text' name='text3'/><br>");
//        out.println("text4<input type='text' name='text4'/><br>");
//        out.println("text5<input type='text' name='text5'/><br>");
        out.println("<input type='submit' value='wyślij'/>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        session.setAttribute("text1", req.getParameter("text1"));
        session.setAttribute("text2", req.getParameter("text2"));
        session.setAttribute("text3", req.getParameter("text3"));
        session.setAttribute("text4", req.getParameter("text4"));
        session.setAttribute("text5", req.getParameter("text5"));

        out.println(session.getAttribute("text1"));
        out.println(session.getAttribute("text2"));
        out.println(session.getAttribute("text3"));
        out.println(session.getAttribute("text4"));
        out.println(session.getAttribute("text5"));
    }
}
