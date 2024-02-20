package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 3035. Maximum Palindromes After Operations
 *
 * @author Baltan
 * @date 2024/2/20 21:12
 */
public class MaxPalindromesAfterOperations {
    public static void main(String[] args) {
        System.out.println(maxPalindromesAfterOperations(new String[]{"abbb", "ba", "aa"}));
        System.out.println(maxPalindromesAfterOperations(new String[]{"abc", "ab"}));
        System.out.println(maxPalindromesAfterOperations(new String[]{"cd", "ef", "a"}));
    }

    public static int maxPalindromesAfterOperations(String[] words) {
        int result = 0;
        /**
         * counts[0]-counts[25]依次表示数组words中字母a-z的个数
         */
        int[] counts = new int[26];
        /**
         * 数组words中成对字母的对数
         */
        int pairs = 0;
        /**
         * 将数组words中的字符串按照长度升序排列，因为最终要求数组中的回文字符串尽可能地多，尽可能使得长度小的字符串被调整为回文字符串
         */
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }
        }

        for (int count : counts) {
            pairs += count / 2;
        }

        for (String word : words) {
            /**
             * 长度为word.length的字符串如果被调整为回文字符串，需要word.length/2个字母对。如果该字符串长度为奇数，则最后从剩余的字母中
             * 随意选择一个作为正中间的字母即可
             */
            if (pairs < word.length() / 2) {
                break;
            }
            result++;
            pairs -= word.length() / 2;
        }
        return result;
    }
}
