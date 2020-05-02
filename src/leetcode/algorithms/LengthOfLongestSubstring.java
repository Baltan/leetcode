package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3. Longest Substring Without Repeating Characters
 *
 * @author Baltan
 * @date 2017/11/7 11:29
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("lxhgmywmlalijiypvmrpqpptipcntdygafppgldr"));
        System.out.println(lengthOfLongestSubstring("c"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        /**
         * 字母c -> s中字母c上一次出现的索引位置，如果没有出现过就记做-1
         */
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        /**
         * 从start位置开始到当前位置的s的子串可以保证没有重复字母
         */
        int start = -1;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                int prevIndex = map.get(c);
                /**
                 * 因为s.charAt(prevIndex)和s.charAt(i)都为字母c，所以包含s.charAt(i)的子串必定不
                 * 含有s.charAt(prevIndex)，所以这个子串至少要从prevIndex之后开始。另一方面，子串还
                 * 必须从start之后开始，所以子串的起始位置取prevIndex和start的较大值的后一位
                 */
                start = Math.max(start, prevIndex);
                result = Math.max(result, i - start);
                map.put(c, i);
            } else {
                /**
                 * 如果索引位置i之前还没有出现过字母c，则包含s.charAt(i)的子串只要从start之后开始即可
                 */
                result = Math.max(result, i - start);
                map.put(c, i);
            }
        }
        return result;
    }
}