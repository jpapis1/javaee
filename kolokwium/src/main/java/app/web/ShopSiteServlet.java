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
import java.util.ArrayList;

@WebServlet("/shop")
public class ShopSiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("rodo")==null) {
            response.sendRedirect("errorRodo.jsp");
        } else {
            response.sendRedirect("shop.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        if(request.getParameter("rodo")==null) {
            response.sendRedirect("errorRodo.jsp");
        } else {
            request.getSession().setAttribute("rodo",true);
            response.sendRedirect("shop.jsp");
        }


    }

}
