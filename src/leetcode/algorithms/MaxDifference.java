package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3442. Maximum Difference Between Even and Odd Frequency I
 *
 * @author baltan
 * @date 2025/2/13 13:55
 */
public class MaxDifference {
    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
        System.out.println(maxDifference("abcabcab"));
    }

    public static int maxDifference(String s) {
        /**
         * counts[i]表示字符串s中字符i出现的次数
         */
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        /**
         * 字符串s中出现奇数次的字符的最大频次
         */
        int maxOdd = Arrays.stream(counts).filter(x -> x % 2 == 1).max().getAsInt();
        /**
         * 字符串s中出现偶数次的字符的最小频次
         */
        int minEven = Arrays.stream(counts).filter(x -> x != 0 && x % 2 == 0).min().getAsInt();
        return maxOdd - minEven;
    }
}
