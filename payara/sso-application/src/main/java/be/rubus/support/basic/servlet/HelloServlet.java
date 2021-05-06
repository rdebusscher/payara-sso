package be.rubus.support.basic.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/secured/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().print("<html><body>");
        resp.getOutputStream().print("Application 2 - Secured");
        if (req.getUserPrincipal() != null) {
            resp.getOutputStream().print("<br/>");
            resp.getOutputStream().print(String.format("User name : %s", req.getUserPrincipal().getName()));
        }
        resp.getOutputStream().print("<br/>");
        resp.getOutputStream().print(String.format("Session id %s", req.getSession().getId()));
        resp.getOutputStream().print("<br/>");
        resp.getOutputStream().print("<a href='logout'>Logout</a>");
        resp.getOutputStream().print("</body></html>");

    }
}
