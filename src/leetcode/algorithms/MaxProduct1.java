package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 318. Maximum Product of Word Lengths
 *
 * @author Baltan
 * @date 2019-06-20 11:39
 */
public class MaxProduct1 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
        System.out.println(maxProduct(
                new String[]{"eae", "ea", "aaf", "bda", "fcf", "dc", "ac", "ce", "cefde", "dabae"}));
    }

    public static int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }

        int result = 0;
        int length = words.length;
        Set<Character>[] sets = new HashSet[length];

        for (int i = 0; i < length; i++) {
            Set<Character> set = new HashSet<>();
            String word = words[i];
            int wordLength = word.length();

            for (int j = 0; j < wordLength; j++) {
                set.add(word.charAt(j));
            }

            sets[i] = set;

            foo:
            for (int j = i - 1; j >= 0; j--) {
                Set<Character> otherSet = sets[j];

                for (char c : set) {
                    if (otherSet.contains(c)) {
                        continue foo;
                    }
                }
                result = Math.max(result, wordLength * words[j].length());
            }
        }
        return result;
    }
}
