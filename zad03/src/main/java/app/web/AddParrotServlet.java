package app.web;

import app.domain.Parrot;
import app.service.ParrotService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/add")
public class AddParrotServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body><h1>Dodaj papugę do pamięci aplikacji</h1>" +
                "<form action=\"add\" method=\"post\">" +
                "Nazwa: <input type=\"text\" name=\"name\" value=\"\">" + "<p></p>" +
                        "Data urodzenia: <input type=\"date\" name=\"dateOfBirth\" value=\"\">" + "<p></p>" +
                "Waga: <input type=\"text\" name=\"weight\" value=\"\">" + "<p></p>" +
                "Egzotyczna: <input type=\"checkbox\" name=\"exotic\" value=\"\">"
                + "<input type=\"submit\" value=\"Dodaj do sklepu\"></form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext servletContext = getServletContext();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        boolean exotic = request.getParameter("exotic")!=null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(request.getParameter("dateOfBirth"), formatter);
        Date myDate = java.sql.Date.valueOf(date);
        ParrotService.addParrot(new Parrot(request.getParameter("name"),
                myDate,
                Double.valueOf(request.getParameter("weight")),
                exotic));
        out.println("<html><body>Zapisano: "+ ParrotService.getParrot(ParrotService.counter-1)  +
                "<p><a href=\"http://localhost:8080/zad03/shop\">Wróć do sklepu</a></p>" +
                "<p><a href=\"http://localhost:8080/zad03/add\">Dodaj kolejną papugę</a></p>" +
                "</body></html>");

    }
}
