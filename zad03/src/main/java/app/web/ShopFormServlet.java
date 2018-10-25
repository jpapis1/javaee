package app.web;

import app.domain.Parrot;
import app.service.ParrotService;
import app.service.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/shop")
public class ShopFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(ParrotService.getMap().size()>0) {
            out.println("<h2>Dostępne papugi</h2>");
            for(Parrot parrot : ParrotService.getMap().values()) {
                out.println("<p>" + parrot.getName() + " urodzona "
                        + parrot.getDateOfBirth() +  " waży "+ parrot.getWeight());
                if(parrot.isExotic()) {
                    out.print(" jest egzotyczna");
                } else {
                    out.print(" nie jest egzotyczna");
                }
                out.print("\"<form action=\"shop\" method=\"post\">"
                +"<input type=\"hidden\" name=\"id\" value=\""+ parrot.getId() +"\">" +
                "<input type=\"submit\" value=\"Dodaj do koszyka\"></form></p>");
            }
        } else {
            out.println("<h2>W pamięci aplikacji nie ma papug!</h2>");
            out.println("<p><a href=\"http://localhost:8080/zad03/add\">Dodaj papugę</a></p>");
        }
        if(ShopService.getBasket().size()>0) {
            out.println("<h2>Twój koszyk</h2>");
            for(Parrot parrot : ShopService.getBasket()) {
                out.println("<p>" + parrot.getName() + " urodzona "
                        + parrot.getDateOfBirth() +  " waży "+ parrot.getWeight());
                if(parrot.isExotic()) {
                    out.print(" jest egzotyczna");
                } else {
                    out.print(" nie jest egzotyczna");
                }
                out.print("</p>");
            }
        } else {
            out.println("<h2>Nic nie masz w koszyku!</h2>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopService.addToBasket(Integer.parseInt(request.getParameter("id")));
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Dodano papugę do koszyka!");
        out.println("<p><a href=\"http://localhost:8080/zad03/shop\">Wróć na stronę sklepu</a></p>");
        out.println("</body></html>");
    }
}
