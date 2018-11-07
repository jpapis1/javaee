package app.service;

import app.domain.Parrot;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ShopService {
    static public void addToBasket(Parrot parrot, HttpServletRequest request, ServletContext context) {
        ArrayList<Parrot> list = (ArrayList<Parrot>) request.getSession().getAttribute("basket");
        list.add(parrot);
        request.getSession().setAttribute("basket",list);
        ParrotService parrotService = (ParrotService) context.getAttribute("parrot_service");
        parrotService.removeParrot(parrot.getId());
        context.setAttribute("parrot_service",parrotService);
    }
    static public void addToBasket(int id, HttpServletRequest request,ServletContext context) {

        ArrayList<Parrot> list = (ArrayList<Parrot>) request.getSession().getAttribute("basket");
        ParrotService parrotService = (ParrotService) context.getAttribute("parrot_service");
        list.add(parrotService.getParrot(id));
        request.getSession().setAttribute("basket",list);
        parrotService.removeParrot(id);
        context.setAttribute("parrot_service",parrotService);
    }
    static public void removeFromBasket(int id, HttpServletRequest request, ServletContext context) {
        ArrayList<Parrot> list = (ArrayList<Parrot>) request.getSession().getAttribute("basket");
        for(Parrot parrot: list) {
            if(parrot.getId()==id) {
                list.remove(id);
                break;
            }
        }
        request.getSession().setAttribute("basket",list);
    }
    static public ArrayList<Parrot> getBasket(HttpServletRequest request) {
        return (ArrayList<Parrot>) request.getSession().getAttribute("basket");
    }

}
