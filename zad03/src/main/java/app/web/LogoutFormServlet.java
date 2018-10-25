package app.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("password");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Wylogowano</h2>" +
                "</body></html>");
        out.close();

    }
}
