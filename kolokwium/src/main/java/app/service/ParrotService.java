package app.service;

import app.domain.Parrot;

import java.util.HashMap;
import java.util.Map;

public class ParrotService {
    public int counter = 0;
    private Map<Integer, Parrot> map = new HashMap<>();
    public void addParrot(Parrot parrot) {
        parrot.setId(counter);
        map.put(counter, parrot);
        counter++;
    }
    public Parrot getParrot(int id) {return map.get(id); }
    public Parrot getParrot(String name) {
        int i = 0;
        while(i<map.size()) {
            i++;
            if(map.get(i).getName().equals(name)) {
                return map.get(i);
            }
        }
        return null;
    }
    public void removeParrot(int id) {
        map.remove(id);
    }

    public Map<Integer, Parrot> getMap() {
        return map;
    }
}
