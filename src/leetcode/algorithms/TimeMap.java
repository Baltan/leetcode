package leetcode.algorithms;

import java.util.*;

/**
 * Description: 981. Time Based Key-Value Store
 *
 * @author Baltan
 * @date 2019-05-01 22:34
 */
public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tm = map.get(key);
        if (tm == null) {
            tm = new TreeMap<>();
            tm.put(timestamp, value);
            map.put(key, tm);
        } else {
            tm.put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tm = map.get(key);
        if (tm == null) {
            return "";
        } else {
            SortedSet<Integer> keys = tm.descendingKeySet();
            for (int k : keys) {
                if (k <= timestamp) {
                    return tm.get(k);
                }
            }
            return "";
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap1 = new TimeMap();
        timeMap1.set("foo", "bar", 1);
        System.out.println(timeMap1.get("foo", 1));
        System.out.println(timeMap1.get("foo", 3));
        timeMap1.set("foo", "bar2", 4);
        System.out.println(timeMap1.get("foo", 4));
        System.out.println(timeMap1.get("foo", 5));

        System.out.println("--------------------");

        TimeMap timeMap2 = new TimeMap();
        timeMap2.set("love", "high", 10);
        timeMap2.set("love", "low", 20);
        System.out.println(timeMap2.get("love", 5));
        System.out.println(timeMap2.get("love", 10));
        System.out.println(timeMap2.get("love", 15));
        System.out.println(timeMap2.get("love", 20));
        System.out.println(timeMap2.get("love", 25));
    }
}
