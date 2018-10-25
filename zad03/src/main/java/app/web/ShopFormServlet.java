package app.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/shop")
public class ShopFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null) {
            out.println("<html><body><h1>Witaj w sklepie " + request.getSession().getAttribute("user") + "!</h1>" +
                    "<p><a href=\"http://localhost:8080/zad03/logout\">Wyloguj</a></p>" +
                    "</body></html>");
        } else {

            out.println("<html><body><h1>Witaj w sklepie niezalogowany"+ "!</h1>" +
                    "</body></html>");
        }
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
        printWriter.println("<html><body><h1>Hello "+ session.getAttribute("user") + " " + session.getAttribute("password") + "</h1></body></html>");

    }
}
