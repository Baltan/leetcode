package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3090. Maximum Length Substring With Two Occurrences
 *
 * @author Baltan
 * @date 2024/3/26 23:35
 */
public class MaximumLengthSubstring {
    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("acedc"));
        System.out.println(maximumLengthSubstring("bcbbbcba"));
        System.out.println(maximumLengthSubstring("aaaa"));
    }

    public static int maximumLengthSubstring(String s) {
        int result = 0;
        /**
         * counts[0]-counts[25]依次表示字符串s的子串中字母a-z的个数
         */
        int[] counts = new int[26];
        /**
         * 如果子串最后一个字符的索引i不大于result-1，则后续的字串的最大长度也不可能大于result，不需要继续计算
         */
        for (int i = s.length() - 1; i >= 0 && i + 1 > result; i--) {
            Arrays.fill(counts, 0);
            /**
             * 遍历子串第一个字符可能的索引值，判断子串s.substring(j,i+1)是否符合要求
             */
            for (int j = i; j >= 0; j--) {
                /**
                 * 当前字符s[j]在子串中第三次出现，不需要继续计算
                 */
                if (counts[s.charAt(j) - 'a'] == 2) {
                    break;
                }
                result = Math.max(result, i - j + 1);
                counts[s.charAt(j) - 'a']++;
            }
        }
        return result;
    }
}
