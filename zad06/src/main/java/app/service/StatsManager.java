package app.service;

import app.domain.Parrot;
import app.domain.ParrotStats;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StatsManager {
     @PersistenceContext
     EntityManager em;

    public ParrotStats getParrotStatsByParrot(Integer parrotId) {
        List<ParrotStats> ps = em.createNamedQuery("stats.getByParrot").setParameter("id",parrotId).getResultList();
        //return em.find(Parrot.class,id);
        if(ps.size()!=0)
        return ps.get(0);
        else
            return null;
    }

}
