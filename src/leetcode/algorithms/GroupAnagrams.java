package leetcode.algorithms;

import java.util.*;

/**
 * Description: 49. Group Anagrams
 *
 * @author Baltan
 * @date 2018/9/14 11:20
 * @see leetcode.interview.GroupAnagrams
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            /**
             * 将字符串的所有字符升序排列后得到的新字符串
             */
            String sorted = new String(charArray);
            map.putIfAbsent(sorted, new LinkedList<>());
            map.get(sorted).add(str);
        }

        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }
}
