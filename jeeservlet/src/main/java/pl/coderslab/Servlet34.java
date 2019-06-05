package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet34")
public class Servlet34 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;UTF-8");

        Cookie[] cookies = req.getCookies();
        boolean absentCookie = true;
        for (Cookie cookieEach : cookies) {
            if ("visits".equals(cookieEach.getName())){
                resp.getWriter().println("Witaj, odwiedziłeś nas już " + cookieEach.getValue() + " razy");
                int visitsCount = Integer.parseInt(cookieEach.getValue());
                visitsCount++;
                String value = "" + visitsCount;
                cookieEach.setValue(value);
                resp.addCookie(cookieEach);
                absentCookie = false;
            }
        }
        if(absentCookie) {
            resp.getWriter().println("Witaj pierwszy raz na naszej stronie");
            Cookie cookie = new Cookie("visits", "1");
            cookie.setMaxAge(60*60*24*365);
            resp.addCookie(cookie);
        }
    }
}
