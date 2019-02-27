package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: Sort Characters By Frequency
 *
 * @author Baltan
 * @date 2018/8/17 17:00
 */
public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {
        char[] sArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int maxNum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : sArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxNum = maxNum > map.get(c) ? maxNum : map.get(c);
        }
        List<Character>[] bucket = new List[maxNum + 1];
        for (char c : map.keySet()) {
            int num = map.get(c);
            if (bucket[num] == null) {
                List<Character> list = new ArrayList<>();
                list.add(c);
                bucket[num] = list;
            } else {
                bucket[num].add(c);
            }
        }
        for (int i = bucket.length - 1; i > 0; i--) {
            List<Character> list = bucket[i];
            if (list != null) {
                for (char c : list) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}