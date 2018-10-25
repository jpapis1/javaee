package app.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Rejestracja</h2>" +
                "<form action=\"register\" method=\"post\">\n" +
                "Username: <input type='text' name='user' /> <br />" +
                "Password: <input type='password' password='password' /> <br />" +
                "<input type='submit' value=' OK ' />" +
                "</form>" +
                "</body></html>");
        out.close();

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("password",password);
        printWriter.println("<html><body><h1>Rejestracja zakończona! Witaj "+ session.getAttribute("user") + "</h1>" +
                "<p><a href=\"http://localhost:8080/zad03/shop\">Przejdź do sklepu</a></p>" +
                "</body></html>");

    }

}
