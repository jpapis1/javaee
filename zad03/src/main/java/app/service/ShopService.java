package app.service;

import app.domain.Parrot;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ShopService {
    static public void addToBasket(Parrot parrot, HttpServletRequest request) {
        ArrayList<Parrot> list = (ArrayList<Parrot>) request.getSession().getAttribute("basket");
        list.add(parrot);
        request.getSession().setAttribute("basket",list);
        ParrotService.removeParrot(parrot.getId());
    }
    static public void addToBasket(int id, HttpServletRequest request) {

        ArrayList<Parrot> list = (ArrayList<Parrot>) request.getSession().getAttribute("basket");
        list.add(ParrotService.getParrot(id));
        request.getSession().setAttribute("basket",list);
        ParrotService.removeParrot(id);
    }
    static public void removeFromBasket(int id, HttpServletRequest request) {
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
