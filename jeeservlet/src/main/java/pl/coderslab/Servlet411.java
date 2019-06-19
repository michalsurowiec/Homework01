package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/servlet411")
public class Servlet411 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = new Cookie("language", "pl");
        for (Cookie eachCookie : cookies) {
            if (eachCookie.getName().equals("language")) {
                cookie = eachCookie;
                break;
            }
        }

        Map<String, String> lang = new HashMap<>();
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Ehre");
        lang.put("es", "Hola");
        lang.put("fr", "Bienvenue");

        Set<String> keySet = lang.keySet();
        for (String key : keySet) {
            if (key.equals(cookie.getValue())) {
                req.setAttribute("greeting", lang.get(key));
            }
        }

        resp.addCookie(cookie);
        getServletContext().getRequestDispatcher("/servlet/index44.jsp").forward(req, resp);
    }
}
