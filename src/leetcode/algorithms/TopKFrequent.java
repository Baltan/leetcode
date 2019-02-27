package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: Top K Frequent Elements
 *
 * @author Baltan
 * @date 2018/8/21 11:42
 */
public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 3));
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 3}, 1));
        System.out.println(topKFrequent(new int[]{1}, 1));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }
        for (int i = bucket.length - 1; i > 0; i--) {
            if (k > 0 && bucket[i] != null) {
                List<Integer> list = bucket[i];
                for (int j = 0; j < list.size(); j++) {
                    res.add(list.get(j));
                    k--;
                    if (k == 0) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
