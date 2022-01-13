package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2131. Longest Palindrome by Concatenating Two Letter Words
 *
 * @author Baltan
 * @date 2022/1/13 09:25
 */
public class LongestPalindrome2 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"lc", "cl", "gg"}));
        System.out.println(longestPalindrome(new String[]{"lc", "cl", "gg", "gg"}));
        System.out.println(longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));
        System.out.println(longestPalindrome(new String[]{"cc", "ll", "xx"}));
        System.out.println(longestPalindrome(new String[]{"cc", "ll", "xx", "xx"}));
    }

    public static int longestPalindrome(String[] words) {
        int result = 0;
        /**
         * 单词word -> 单词word在数组words中出现的次数
         */
        Map<String, Integer> countMap = new HashMap<>();
        /**
         * 单词word -> 单词word是否是回文字符串
         */
        Map<String, Boolean> palindromeMap = new HashMap<>();
        /**
         * 标记是否已经使用一个回文字符串放在结果字符串的最中间
         */
        boolean flag = false;

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            /**
             * 检查word是否是回文字符串
             */
            checkPalindrome(word, palindromeMap);
        }

        for (String word : words) {
            int wordCount = countMap.getOrDefault(word, 0);

            if (wordCount > 0) {
                /**
                 * 如果word本身是个回文字符串，并且数组words中还剩余至少两个word，则可以构成"...word....word..."这样的回
                 * 文字符串，如果数组中只剩余一个word，则可以构成"...word..."这样的回文字符串，即将在结果字符串的正中间放一
                 * 个回文字符串，但只能有一次这样的操作
                 *
                 * 如果word本身不是个回文字符串，则如果words中还剩余至少一个word颠倒后的字符串reversedWord时，可以构成
                 * "...word....reversedWordCount..."这样的回文字符串
                 */
                if (palindromeMap.get(word)) {
                    if (wordCount > 1) {
                        result += word.length() * 2;
                        countMap.put(word, wordCount - 2);
                    } else if (!flag) {
                        result += word.length();
                        countMap.put(word, wordCount - 1);
                        flag = true;
                    }
                } else {
                    String reversedWord = new StringBuilder(word).reverse().toString();
                    int reversedWordCount = countMap.getOrDefault(reversedWord, 0);

                    if (reversedWordCount > 0) {
                        result += word.length() * 2;
                        countMap.put(word, wordCount - 1);
                        countMap.put(reversedWord, reversedWordCount - 1);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 检查word是否是回文字符串
     *
     * @param word
     * @param palindromeMap
     */
    public static void checkPalindrome(String word, Map<String, Boolean> palindromeMap) {
        if (palindromeMap.containsKey(word)) {
            return;
        }

        int lo = 0;
        int hi = word.length() - 1;

        while (lo < hi) {
            if (word.charAt(lo) != word.charAt(hi)) {
                palindromeMap.put(word, false);
                return;
            }
            lo++;
            hi--;
        }
        palindromeMap.put(word, true);
    }
}
