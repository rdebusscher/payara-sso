package be.rubus.support.basic.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/secured/other")
public class OtherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().print("<html><body>");
        resp.getOutputStream().print("Other Servlet - Secured");
        resp.getOutputStream().print("<br/>");
        resp.getOutputStream().print("<a href='hello'>Hello Servlet</a>");
        resp.getOutputStream().print("</body></html>");

    }
}
