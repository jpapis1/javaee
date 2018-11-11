package app.service;

import app.domain.Parrot;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private List<Parrot> basket = new ArrayList<>();
    public void addToBasket(Parrot parrot) {
        basket.add(parrot);
    }
    public void removeFromBasket(Parrot parrot) {
        basket.remove(parrot);
    }
    public List<Parrot> getBasket() {
        return basket;
    }

}
