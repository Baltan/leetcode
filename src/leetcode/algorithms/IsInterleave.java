package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 97. Interleaving String
 *
 * @author Baltan
 * @date 2020-07-18 00:10
 */
public class IsInterleave {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("a", "b", "a"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        /**
         * 如果s1和s2的字符总数和s3的字符总数不相等，则肯定不能完成交错组成，直接返回false
         */
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        /**
         * 如果s1是空字符串，则只能用s2拼接出s3
         */
        if (s1.length() == 0) {
            return Objects.equals(s2, s3);
        }
        /**
         * 如果s2是空字符串，则只能用s1拼接出s3
         */
        if (s2.length() == 0) {
            return Objects.equals(s1, s3);
        }

        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        /**
         * dp[i][j]表示s1的前i个字符构成的子串和s2的前j个字符构成的子串能否交错拼接成s3的前i+j个字符构成的子串
         */
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;
        /**
         * 判断s2的前i个字符构成的子串能否拼接成s3的前i个字符构成的子串
         */
        for (int i = 1; i <= length2; i++) {
            dp[0][i] = i <= length3 && Objects.equals(s2.substring(0, i), s3.substring(0, i));
        }
        /**
         * 判断s1的前i个字符构成的子串能否拼接成s3的前i个字符构成的子串
         */
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = i <= length3 && Objects.equals(s1.substring(0, i), s3.substring(0, i));
        }
        /**
         * 如果s1的前i个字符构成的子串和s2的前j个字符构成的子串能交错拼接成s3的前i+j个字符构成的子串，则有两种情况：
         * 1、s1的前i-1个字符构成的子串和s2的前j个字符构成的子串能交错拼接成s3的前i-1+j个字符构成的子串，并且s1的
         * 第i个字符和s3的第i+j个字符相同
         * 2、s1的前i个字符构成的子串和s2的前j-1个字符构成的子串能交错拼接成s3的前i-1+j个字符构成的子串，并且s2的
         * 第j个字符和s3的第i+j个字符相同
         */
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                dp[i][j] =
                        (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) ||
                                (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[length1][length2];
    }
}
