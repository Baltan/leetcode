package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 87. Scramble String
 *
 * @author Baltan
 * @date 2024/6/23 14:22
 */
public class IsScramble {
    public static void main(String[] args) {
        System.out.println(isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));
        System.out.println(isScramble("abb", "bba"));
        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScramble("abcde", "caebd"));
        System.out.println(isScramble("a", "a"));
        System.out.println(isScramble("a", "b"));
        System.out.println(isScramble("ab", "ba"));
    }

    public static boolean isScramble(String s1, String s2) {
        if (Objects.equals(s1, s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }
        int length = s1.length();

        for (int i = 1; i < length; i++) {
            String prefix1 = s1.substring(0, i);
            String suffix1 = s1.substring(i);
            String prefix2 = s2.substring(0, i);
            String suffix2 = s2.substring(i);

            if (isAnagram(prefix1, prefix2) && isAnagram(suffix1, suffix2) && isScramble(prefix1, prefix2) && isScramble(suffix1, suffix2)) {
                return true;
            }
            prefix2 = s2.substring(0, length - i);
            suffix2 = s2.substring(length - i);

            if (isAnagram(prefix1, suffix2) && isAnagram(suffix1, prefix2) && isScramble(prefix1, suffix2) && isScramble(suffix1, prefix2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnagram(String s1, String s2) {
        int[] counts = new int[26];

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
