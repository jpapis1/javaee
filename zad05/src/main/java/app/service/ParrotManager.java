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
        db.add(parrot);
    }

    public void deleteParrot(Parrot parrot){
        db.remove(parrot);
    }

    public Parrot getParrot(Integer id) {
        return db.get(id);
    }

    public List<Parrot> getAllParrots(){
        return db;
    }

    public void deleteAllParrots(){
        db.clear();
    }
}
