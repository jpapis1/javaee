package app.service;

import app.domain.Parrot;

import java.util.ArrayList;

public class ShopService {
    private static ArrayList<Parrot> basket = new ArrayList<>();
    static public void addToBasket(Parrot parrot) {
        basket.add(parrot);
        ParrotService.removeParrot(parrot.getId());
    }
    static public void addToBasket(int id) {
        basket.add(ParrotService.getParrot(id));
        ParrotService.removeParrot(id);
    }
    static public void removeFromBasket(int id) {
        for(Parrot parrot: basket) {
            if(parrot.getId()==id) {
                basket.remove(id);
                break;
            }
        }
    }
    static public ArrayList<Parrot> getBasket() {
        return basket;
    }

}
