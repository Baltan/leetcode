package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3713. Longest Balanced Substring I
 *
 * @author baltan
 * @date 2025/11/18 11:27
 */
public class LongestBalanced {
    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac"));
        System.out.println(longestBalanced("zzabccy"));
        System.out.println(longestBalanced("aba"));
    }

    public static int longestBalanced(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            /**
             * counts[0]-counts[25]依次表示子串s[i……j]中字符"a"-"z"出现的次数
             */
            int[] counts = new int[26];
            /**
             * countMap[x]表示子串s[i……j]中出现次数为x的不同字符的个数
             */
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                /**
                 * 子串s[i……j-1]中字符c出现的次数
                 */
                int count1 = counts[c - 'a'];
                /**
                 * 子串s[i……j-1]中出现count1次的不同字符的个数
                 */
                int count2 = countMap.getOrDefault(count1, 0);

                if (count2 > 1) {
                    countMap.put(count1, count2 - 1);
                } else {
                    /**
                     * 子串中加入字符s[j]后不存在出现count1次的字符
                     */
                    countMap.remove(count1);
                }
                counts[c - 'a'] = count1 + 1;
                countMap.merge(count1 + 1, 1, Integer::sum);
                /**
                 * 子串s[i……j]中所有不同字符出现的次数都相等
                 */
                if (countMap.size() == 1) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }
}
