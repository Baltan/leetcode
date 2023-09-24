package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1092. Shortest Common Supersequence
 *
 * @author Baltan
 * @date 2023/9/24 14:23
 */
public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
        System.out.println(shortestCommonSupersequence("bcaaacbbbcbdcaddadcacbdddcdcccdadadcbabaccbccdcdcbcaccacbbdcbabb", "dddbbdcbccaccbababaacbcbacdddcdabadcacddbacadabdabcdbaaabaccbdaa"));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        if (Objects.equals(str1, str2)) {
            return str1;
        }

        if (str1.isEmpty()) {
            return str2;
        }

        if (str2.isEmpty()) {
            return str1;
        }
        char suffix1 = str1.charAt(str1.length() - 1);
        char suffix2 = str2.charAt(str2.length() - 1);
        String prefix1 = str1.substring(0, str1.length() - 1);
        String prefix2 = str2.substring(0, str2.length() - 1);

        if (suffix1 == suffix2) {
            return shortestCommonSupersequence(prefix1, prefix2) + suffix1;
        } else {
            String supersequence1 = shortestCommonSupersequence(str1, prefix2) + suffix2;
            String supersequence2 = shortestCommonSupersequence(str2, prefix1) + suffix1;
            return supersequence1.length() < supersequence2.length() ? supersequence1 : supersequence2;
        }
    }
}
