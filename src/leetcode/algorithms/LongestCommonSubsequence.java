package leetcode.algorithms;

/**
 * Description: 1143. Longest Common Subsequence
 *
 * @author Baltan
 * @date 2020-01-27 15:03
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        /**
         * dp[i][j]表示text1的前i个字符组成的子串和text2的前j个字符组成的子串的最长公共子序列，所有
         * 的dp[0][k]和dp[k][0]的值都为0，text1和text2的最长公共子序列就是dp[length1][length2]
         */
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
