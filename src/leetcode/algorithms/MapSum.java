package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Map Sum Pairs
 *
 * @author Baltan
 * @date 2018/8/21 10:42
 */
public class MapSum {

    private Map<String, Integer> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public MapSum() {

    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                sum += map.get(key);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum ms = new MapSum();
        ms.insert("apple", 3);
        ms.insert("app", 2);
        System.out.println(ms.sum("ap"));
    }
}
