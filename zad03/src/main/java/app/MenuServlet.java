package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body><h1>Witaj w sklepie " + request.getSession().getAttribute("user") + "!</h1>" +
                "<p><a href=\"http://localhost:8080/zad02/shop\">Przejdź do sklepu</a></p>"+
                "<p><a href=\"http://localhost:8080/zad02/about\">O mnie</a></p>" +
                "</body></html>");
        if(request.getSession().isNew()) {

        }
    }
}
