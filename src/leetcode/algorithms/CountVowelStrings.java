package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1641. Count Sorted Vowel Strings
 *
 * @author Baltan
 * @date 2022/9/18 14:33
 */
public class CountVowelStrings {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
        System.out.println(countVowelStrings(33));
        System.out.println(countVowelStrings(50));
    }

    public static int countVowelStrings(int n) {
        /**
         * dp[0]表示当第i个字符为'a'时，符合条件的子串的个数，
         * dp[1]表示当第i个字符为'e'时，符合条件的子串的个数，
         * dp[2]表示当第i个字符为'i'时，符合条件的子串的个数，
         * dp[3]表示当第i个字符为'o'时，符合条件的子串的个数，
         * dp[4]表示当第i个字符为'u'时，符合条件的子串的个数
         */
        int[] dp = new int[5];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            /**
             * 如果第i个字符为'u'，则第i-1个字符只能为'a'、'e'、'i'、'o'、'u'
             */
            dp[4] = dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
            /**
             * 如果第i个字符为'i'，则第i-1个字符只能为'a'、'e'、'i'、'o'
             */
            dp[3] = dp[0] + dp[1] + dp[2] + dp[3];
            /**
             * 如果第i个字符为'i'，则第i-1个字符只能为'a'、'e'、'i'
             */
            dp[2] = dp[0] + dp[1] + dp[2];
            /**
             * 如果第i个字符为'e'，则第i-1个字符只能为'a'、'e'
             */
            dp[1] = dp[0] + dp[1];
            /**
             * 如果第i个字符为'a'，则第i-1个字符只能为'a'
             */
            dp[0] = dp[0];
        }
        return dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
    }
}
