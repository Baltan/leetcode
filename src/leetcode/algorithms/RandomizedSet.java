package leetcode.algorithms;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Description: 380. Insert Delete GetRandom O(1)
 *
 * @author Baltan
 * @date 2019-06-30 11:54
 */
public class RandomizedSet {
    private Set<Integer> set;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new HashSet<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(new Integer(val));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int size = set.size();
        Integer[] arr = set.toArray(new Integer[size]);
        return arr[rand.nextInt(size)];
    }

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
    }
}
