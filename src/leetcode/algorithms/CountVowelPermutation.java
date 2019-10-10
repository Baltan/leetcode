package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1220. Count Vowels Permutation
 *
 * @author Baltan
 * @date 2019-10-10 08:51
 */
public class CountVowelPermutation {
    public static void main(String[] args) {
        System.out.println(countVowelPermutation(1));
        System.out.println(countVowelPermutation(2));
        System.out.println(countVowelPermutation(10000));
        System.out.println(countVowelPermutation(20000));
    }

    public static int countVowelPermutation(int n) {
        /**
         * 0-a,1-e,2-i,3-o,4-u
         */
        long[][] dp = new long[n + 1][5];
        Arrays.fill(dp[1], 1L);
        int mod = 1000000007;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
        }
        return (int) ((dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4]) % mod);
    }
}
