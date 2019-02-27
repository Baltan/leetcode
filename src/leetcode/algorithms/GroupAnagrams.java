package leetcode.algorithms;

import java.util.*;

/**
 * Description: Group Anagrams
 *
 * @author Baltan
 * @date 2018/9/14 11:20
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String newStr = new String(array);
            if (map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(newStr, list);
            }
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
