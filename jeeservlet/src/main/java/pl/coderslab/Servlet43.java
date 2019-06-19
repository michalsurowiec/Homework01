package pl.coderslab;

import pl.Util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/guest-book")
public class Servlet43 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM GuestBook ORDER BY id DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> guestList = new ArrayList<>();
            while (resultSet.next()) {
                String guest = resultSet.getString("name") + ", " + resultSet.getString("description");
                guestList.add(guest);
            }
            req.setAttribute("guestList", guestList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/servlet/index46.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO GuestBook VALUES (null, ?, ?)");
            preparedStatement.setString(1, req.getParameter("name"));
            preparedStatement.setString(2, req.getParameter("description"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/guest-book");
    }
}
