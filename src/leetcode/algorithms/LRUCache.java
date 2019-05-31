package leetcode.algorithms;

import java.util.LinkedHashMap;

/**
 * Description: 146. LRU Cache
 *
 * @author Baltan
 * @date 2019-05-31 17:05
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>((int) (capacity / 0.75), 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }

        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (map.size() < capacity) {
            map.put(key, value);
        } else {
            if (!map.containsKey(key)) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        System.out.println(cache1.get(1));
        cache1.put(3, 3);
        System.out.println(cache1.get(2));
        cache1.put(4, 4);
        System.out.println(cache1.get(1));
        System.out.println(cache1.get(3));
        System.out.println(cache1.get(4));

        System.out.println("-------------");

        LRUCache cache2 = new LRUCache(2);
        System.out.println(cache2.get(2));
        cache2.put(2, 6);
        System.out.println(cache2.get(1));
        cache2.put(1, 5);
        cache2.put(1, 2);
        System.out.println(cache2.get(1));
        System.out.println(cache2.get(2));
    }
}
