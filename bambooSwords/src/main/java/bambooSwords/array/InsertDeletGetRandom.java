package bambooSwords.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class InsertDeletGetRandom {
    ArrayList<Integer> pos;
    HashMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public InsertDeletGetRandom() {
        pos = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = !map.containsKey(val);
        if (res){
            map.put(val, pos.size());
            pos.add(val);
        }
        return res;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)){
           int p = map.get(val);
           map.remove(val);
           int temp = pos.get(pos.size() - 1);
           if (temp != val){
               pos.set(p, temp);
               map.put(temp, p);
           }
           pos.remove(pos.size() - 1);
           return true;
        }

        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int seed = (int)(Math.random() * (pos.size()));
        return pos.get(seed);
    }
}
