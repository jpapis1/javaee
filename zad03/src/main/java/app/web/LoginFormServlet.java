package app.web;

import app.service.ShopService;
import app.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Logowanie</h2>" +
                "<form action=\"login\" method=\"post\">\n" +
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

        if(UserService.userExists(user)) {


            if (UserService.getUser("user").getPassword().equals(password)) {
                printWriter.println("<html><body><h1>Zalogowany !+ </h1>" +
                        "<p><a href=\"http://localhost:8080/zad03/shop\">Przejdź do sklepu</a></p>" +
                        "</body></html>");
            } else {
                printWriter.println("<html><body><h1>Nieprawidłowe hasło</h1>" +
                        "<p><a href=\"http://localhost:8080/zad03/shop\">Przejdź do sklepu</a></p>" +
                        "</body></html>");
            }
        } else {
            printWriter.println("<html><body><h1>Użytkownik nie istnieje!+ </h1>" +
                    "<p><a href=\"http://localhost:8080/zad03/shop\">Przejdź do sklepu</a></p>" +
                    "</body></html>");
        }
    }
}
