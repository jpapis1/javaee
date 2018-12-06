package app.service;

import app.domain.Parrot;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class ParrotManager {
    private List<Parrot> db = Collections.synchronizedList(new ArrayList<>());

    public void addParrot(Parrot parrot) {
        parrot.setId(db.size());
        db.add(parrot);

    }

    public void deleteParrot(Parrot parrot){
        db.remove(parrot);
    }

    public Parrot getParrot(Integer id) {
        if(id>=db.size()) {
            return null;
        } else {
            return db.get(id);
        }
    }
    public boolean updateParrot(Integer id, Parrot parrot) {

        Parrot parrotFromList = getParrot(id);
        if(parrotFromList!=null) {
            parrotFromList.setName(parrot.getName());
            parrotFromList.setDateOfBirth(parrot.getDateOfBirth());
            parrotFromList.setExotic(parrot.isExotic());
            parrotFromList.setWeight(parrot.getWeight());
            return true;
        } else {
            return false;
        }
    }

    public List<Parrot> getAllParrots(){
        return db;
    }

    public void deleteAllParrots(){
        db.clear();
    }
}
