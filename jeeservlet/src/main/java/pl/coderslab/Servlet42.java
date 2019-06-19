package pl.coderslab;

import pl.Util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/newsletter")
public class Servlet42 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/servlet/index45.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("unregistered", "0");
        cookie.setMaxAge(86400);
        resp.addCookie(cookie);

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Newsletter VALUES (null, ?, ?)");
            preparedStatement.setString(1, req.getParameter("name"));
            preparedStatement.setString(2, req.getParameter("email"));
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

        resp.sendRedirect("/newsletter");
    }
}
