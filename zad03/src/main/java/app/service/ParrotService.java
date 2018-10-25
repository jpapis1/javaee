package app.service;

import app.domain.Parrot;

import java.util.HashMap;
import java.util.Map;

public class ParrotService {
    static public int counter = 0;
    static private Map<Integer, Parrot> map = new HashMap<>();
    static public void addParrot(Parrot parrot) {
        parrot.setId(counter);
        map.put(counter, parrot);
        counter++;
    }
    static public Parrot getParrot(int id) {return map.get(id); }
    static public Parrot getParrot(String name) {
        int i = 0;
        while(i<map.size()) {
            i++;
            if(map.get(i).getName().equals(name)) {
                return map.get(i);
            }
        }
        return null;
    }
    static public void removeParrot(int id) {
        map.remove(id);
    }

    static public Map<Integer, Parrot> getMap() {
        return map;
    }
}
