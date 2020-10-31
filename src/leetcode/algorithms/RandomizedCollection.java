package leetcode.algorithms;

import java.util.*;

/**
 * Description: 381. Insert Delete GetRandom O(1) - Duplicates allowed
 *
 * @author Baltan
 * @date 2019-06-30 12:57
 */
public class RandomizedCollection {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the
     * specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
        return map.get(val) == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            if (map.get(val) == 1) {
                map.remove(new Integer(val));
            } else {
                map.put(val, map.get(val) - 1);
            }
            list.remove(new Integer(val));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int size = list.size();
        return list.get(rand.nextInt(size));
    }

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(1));
        System.out.println(collection.insert(1));
        System.out.println(collection.insert(2));
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.remove(1));
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
    }
}
