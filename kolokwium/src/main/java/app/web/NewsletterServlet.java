package app.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/newsletter")
public class NewsletterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print("<html><body>" +
                "<form action=\"saved.jsp\" method=\"post\">\n" +
                "  Date from:<br>\n" +
                "  <input type=\"date\" name=\"from\"><br>\n" +
                "  Date to:<br>\n" +
                "  <input type=\"text\" name=\"to\">\n" +
                "    <p>Every Day<input type=\"radio\" id=\"day\" name=\"freq\" value=\"day\"\n" +
                "         ></p>" +
                "    <p>Every Month<input type=\"radio\" id=\"month\" name=\"freq\" value=\"month\"\n" +
                "         ></p>" +
                "    <p>Every Year<input type=\"radio\" id=\"year\" name=\"freq\" value=\"year\"\n" +
                "         ></p>" +
                "Parrots from:" +
                "Australia: <input type=\"checkbox\" id=\"aus\" name=\"aus\"\n" +
                "         checked>" +
                "Europe: <input type=\"checkbox\" id=\"scales\" name=\"scales\"\n" +
                "         checked>" +
                "India: <input type=\"checkbox\" id=\"scales\" name=\"scales\"\n" +
                "         checked>" +
                "India: <input type=\"submit\" value=\"Ustaw\">" +
                "</form>" +
                "</body></html");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();


    }
}