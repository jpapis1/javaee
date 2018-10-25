package app.service;

import app.domain.Parrot;

import java.util.HashMap;
import java.util.Map;

public class ShopService {
    static private Map<Integer, Parrot> map = new HashMap<>();
    static public void add(Parrot parrot) {
        int i = 0;
        while(map.containsKey(i)) {
            i++;
        }
        map.put(i, parrot);
    }
    static public void remove(int id) {
        map.remove(id);
    }

    static public Map<Integer, Parrot> getMap() {
        return map;
    }
}
