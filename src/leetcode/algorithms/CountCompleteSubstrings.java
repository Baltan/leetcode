package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2953. Count Complete Substrings
 *
 * @author Baltan
 * @date 2023/12/4 11:40
 */
public class CountCompleteSubstrings {
    public static void main(String[] args) {
        System.out.println(countCompleteSubstrings("bbbc", 3));
        System.out.println(countCompleteSubstrings("igigee", 2));
        System.out.println(countCompleteSubstrings("aaabbbccc", 3));
    }

    public static int countCompleteSubstrings(String word, int k) {
        int result = 0;
        int length = word.length();
        char[] charArray = word.toCharArray();
        /**
         * 一个完全字符串中，每个字符都是出现k次，所以完全字符串的长度一定为k的倍数，且最大不超过k*26
         */
        int maxWindow = Math.min(length, k * 26);
        /**
         * 遍历长度依次为k、2k、3k……的完全子串
         */
        for (int i = k; i <= maxWindow; i += k) {
            /**
             * 子串的第一个字符在字符串word中的索引
             */
            int lo = 0;
            /**
             * 子串的最后一个字符在字符串word中的索引
             */
            int hi = lo - 1;
            int[] counts = new int[26];

            while (hi - lo + 1 < i && hi + 1 < length) {
                hi++;
                counts[charArray[hi] - 'a']++;
                /**
                 * 当前子串存在相邻的两个字符之差大于2，不符合完全子串的定义，从后一个字符开始重新查找完全子串
                 */
                if (hi > lo && Math.abs(charArray[hi] - charArray[hi - 1]) > 2) {
                    lo = hi;
                    hi = lo - 1;
                    Arrays.fill(counts, 0);
                    continue;
                }

                if (hi - lo + 1 == i) {
                    /**
                     * 当前子串中所有字符都是出现k次，是一个完全子串
                     */
                    if (Arrays.stream(counts).allMatch(x -> x == 0 || x == k)) {
                        result++;
                    }
                    counts[charArray[lo] - 'a']--;
                    lo++;
                }
            }
        }
        return result;
    }
}
