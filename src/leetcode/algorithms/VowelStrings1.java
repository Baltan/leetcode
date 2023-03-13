package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2586. Count the Number of Vowel Strings in Range
 *
 * @author Baltan
 * @date 2023/3/12 13:52
 */
public class VowelStrings1 {
    public static void main(String[] args) {
        System.out.println(vowelStrings(new String[]{"are", "amy", "u"}, 0, 2));
        System.out.println(vowelStrings(new String[]{"hey", "aeo", "mu", "ooo", "artro"}, 1, 4));
    }

    public static int vowelStrings(String[] words, int left, int right) {
        int result = 0;
        /**
         * 元音字符
         */
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = left; i <= right; i++) {
            String word = words[i];
            /**
             * 判断字符串word的首尾字符是否是元音字符
             */
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                result++;
            }
        }
        return result;
    }
}
