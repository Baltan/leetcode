package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2506. Count Pairs Of Similar Strings
 *
 * @author Baltan
 * @date 2023/2/4 21:10
 */
public class SimilarPairs {
    public static void main(String[] args) {
        System.out.println(similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc"}));
        System.out.println(similarPairs(new String[]{"aabb", "ab", "ba"}));
        System.out.println(similarPairs(new String[]{"nba", "cba", "dba"}));
    }

    public static int similarPairs(String[] words) {
        int result = 0;
        /**
         * value -> 字符串数量
         */
        Map<Integer, Integer> countMap = new HashMap<>();

        for (String word : words) {
            /**
             * value的二进制值从低位到高位为1依次表示字符串word中存在字符a-z
             */
            int value = 0;

            for (char c : word.toCharArray()) {
                /**
                 * value二进制值的从低到高第c-'a'位应当为1
                 */
                value |= (1 << (c - 'a'));
            }
            int count = countMap.getOrDefault(value, 0);
            /**
             * 当前字符串word和之前所有value值相等的字符串都相似
             */
            result += count;
            countMap.put(value, count + 1);
        }
        return result;
    }
}
