package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 2008. Maximum Earnings From Taxi
 *
 * @author Baltan
 * @date 2021/12/5 15:53
 */
public class MaxTaxiEarnings {
    public static void main(String[] args) {
        int n1 = 5;
        int[][] rides1 = {{2, 5, 4}, {1, 5, 1}};
        System.out.println(maxTaxiEarnings(n1, rides1));

        int n2 = 20;
        int[][] rides2 = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};
        System.out.println(maxTaxiEarnings(n2, rides2));
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        Arrays.sort(rides, Comparator.comparingInt(x -> x[0]));

        for (int[] ride : rides) {
            int start = ride[0];
            int end = ride[1];
            int tip = ride[2];

            dp[end] = Math.max(dp[end], dp[start] + (end - start + tip));

            for (int i = end + 1; i <= n; i++) {
                dp[i] = Math.max(dp[i], dp[end]);
            }
        }
        return dp[n];
    }
}
