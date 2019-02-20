package app.service;

import app.domain.Basket;
import app.domain.Country;
import app.domain.Owner;
import app.domain.Parrot;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Stateless
public class ParrotManager {
    @PersistenceContext
    EntityManager em;

    public int addParrot(Parrot parrot) {
       List<Owner> owners = em.createNamedQuery("Owner.getUnique")
                .setParameter("firstName",parrot.getOwner().getFirstName())
                .setParameter("lastName",parrot.getOwner().getLastName()).getResultList();
        if(owners.size()>0)
        parrot.setOwner(owners.get(0));

        em.persist(parrot);
        return parrot.getId();

    }

    public boolean deleteParrot(Integer id){

        Parrot foundParrot = em.find(Parrot.class,id);

        if(foundParrot!=null) {
            em.createNamedQuery("parrot.delete").setParameter("id",id).executeUpdate();
            //em.remove(foundParrot);
            return true;
        } else {
            return false;
        }
    }

    public Parrot getParrot(Integer id) {
       return em.find(Parrot.class,id);
    }
    public List<Parrot> getParrotsConsideringDates(Date from,  Date to) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Parrot> criteria = builder.createQuery(Parrot.class);
        Root<Parrot> root = criteria.from(Parrot.class);
        Predicate condition = builder.and(builder.greaterThanOrEqualTo(root.get("dateOfBirth"),from),
                builder.lessThanOrEqualTo(root.get("dateOfBirth"),to));
        criteria.where(condition);
        return em.createQuery(criteria).getResultList();
        //return em.createNamedQuery("parrot.betweenDateOfBirth").setParameter("fromDate",from).setParameter("toDate",to).getResultList();
    }
    public List<Parrot> getParrotsOfSpecificColorAndOwner(String color,String firstName, String lastName) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Parrot> criteria = builder.createQuery(Parrot.class);
        Root<Parrot> root = criteria.from(Parrot.class);
        Predicate condition = builder.and(builder.equal(root.get("stats").get("color"),color),
                builder.equal(root.get("owner").get("firstName"),firstName),
                builder.equal(root.get("owner").get("lastName"),lastName));
        criteria.where(condition);
        return em.createQuery(criteria).getResultList();

    }
    public double getAverageWeightByColor(String color) {
        return (double) em.createNamedQuery("parrot.getAvgWeightByParrotColor").setParameter("color",color).getSingleResult();
    }
        public boolean updateParrot(Integer id, Parrot parrot) {
        Parrot foundParrot = em.find(Parrot.class,id);
        if(foundParrot!=null) {
            List<Owner> owners = em.createNamedQuery("Owner.getUnique")
                    .setParameter("firstName",parrot.getOwner().getFirstName())
                    .setParameter("lastName",parrot.getOwner().getLastName()).getResultList();
            if(owners.size()>0)
                parrot.setOwner(owners.get(0));

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
