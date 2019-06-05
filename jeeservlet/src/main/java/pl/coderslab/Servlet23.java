package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(urlPatterns = "/servlet23")
public class Servlet23 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("/home/michal/Pulpit/Warsztaty/Homework01/jeeservlet/oop.txt");
        Scanner scannerFile = new Scanner(file);
        while (scannerFile.hasNextLine()) {
            resp.getWriter().println(scannerFile.nextLine());
        }
    }
}
