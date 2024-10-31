package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3335. Total Characters in String After Transformations I
 *
 * @author Baltan
 * @date 2024/10/27 19:54
 */
public class LengthAfterTransformations {
    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations("abcyy", 2));
        System.out.println(lengthAfterTransformations("azbk", 1));
    }

    public static int lengthAfterTransformations(String s, int t) {
        long result = 0L;
        int mod = 1000000007;
        long[][] dp = new long[2][26];
        int curr = 0;

        for (char c : s.toCharArray()) {
            dp[curr][c - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int next = 1 - curr;
            Arrays.fill(dp[next], 0L);

            for (int j = 0; j < dp[curr].length; j++) {
                dp[next][j] = dp[curr][j == 0 ? 25 : j - 1];
            }
            dp[next][1] = (dp[next][1] + dp[curr][25]) % mod;
            curr = next;
        }

        for (long value : dp[curr]) {
            result = (result + value) % mod;
        }
        return (int) result;
    }
}
