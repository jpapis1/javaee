package app.service;

import app.domain.Parrot;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class ParrotManager {
    @PersistenceContext
    EntityManager em;

    public void addParrot(Parrot parrot) {
        em.persist(parrot);

    }

    public boolean deleteParrot(Integer id){
        Parrot foundParrot = em.find(Parrot.class,id);
        if(foundParrot!=null) {
            em.remove(foundParrot);
            return true;
        } else {
            return false;
        }
    }

    public Parrot getParrot(Integer id) {
       return em.find(Parrot.class,id);
    }
    public boolean updateParrot(Integer id, Parrot parrot) {
        Parrot foundParrot = em.find(Parrot.class,id);
        if(foundParrot!=null) {
            parrot.setId(foundParrot.getId());
            em.merge(parrot);
            return true;
        }
        return false;
    }

    public List<Parrot> getAllParrots(){
        return em.createNamedQuery("parrot.getAll").getResultList();
    }

    public void deleteAllParrots(){
        em.createNamedQuery("parrot.deleteAll").executeUpdate();
    }
}
