package app.service;

import app.domain.Basket;
import app.domain.Parrot;
import app.domain.ParrotStats;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BasketManager {
    @PersistenceContext
    EntityManager em;

    public int createBasket() {
        Basket basket = new Basket();
        em.persist(basket);
        return basket.getId();
    }
    public void addToBasket(int basketId, int parrtoId) {
        Basket basket = em.find(Basket.class,basketId);
        Parrot parrot = em.find(Parrot.class,parrtoId);
        basket.getParrots().add(parrot);
        parrot.getBaskets().add(basket);
        em.persist(basket);
    }
    public void removeFromBasket(int basketId, int parrtoId) {
        Basket basket = em.find(Basket.class,basketId);
        Parrot parrot = em.find(Parrot.class,parrtoId);
        basket.getParrots().remove(parrot);
        parrot.getBaskets().remove(basket);
        em.persist(basket);
    }
    public Basket getBasket(Integer id) {
        return em.find(Basket.class,id);
    }
}
