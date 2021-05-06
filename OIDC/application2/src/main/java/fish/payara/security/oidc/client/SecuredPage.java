package fish.payara.security.oidc.client;

import fish.payara.security.annotations.GoogleAuthenticationDefinition;
import fish.payara.security.annotations.LogoutDefinition;
import fish.payara.security.annotations.OpenIdAuthenticationDefinition;
import fish.payara.security.openid.api.OpenIdContext;

import java.io.IOException;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
@WebServlet("/Secured")
@GoogleAuthenticationDefinition()
@DeclareRoles("all")
@ServletSecurity(@HttpConstraint(rolesAllowed = "all"))
public class SecuredPage extends HttpServlet {

    @Inject
    private OpenIdContext context;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().println("<html><body>");
        response.getWriter().println("This is a secured page of Application 2");
        response.getWriter().println("<br/>");

        response.getWriter().println("Access Token " + context.getAccessToken());
        response.getWriter().println("<br/>");
        response.getWriter().println("Subject " + context.getSubject());
        response.getWriter().println("<br/>");
        response.getWriter().println("Caller Name " + context.getCallerName());
        response.getWriter().println("<br/>");

        response.getWriter().println("Identity "+context.getIdentityToken().getClaim("email"));
        response.getWriter().println("<br/>");

        response.getWriter().println("</body></html>");
    }
}
