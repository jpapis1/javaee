package app.service;

import app.domain.Owner;
import app.domain.Parrot;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OwnerManager {
    @PersistenceContext
    EntityManager em;

    public void addOwner(Owner owner) {
        em.persist(owner);
    }

    public List<Parrot> getAllOwnersParrots(Integer id) {
        return em.createNamedQuery("parrot.getOwnersParrots").setParameter("id",id).getResultList();
    }
}
