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

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/maximum-earnings-from-taxi/solution/java-dong-tai-gui-hua-by-rational-irrati-86xz/"></a>
     *
     * @param n
     * @param rides
     * @return
     */
    public static long maxTaxiEarnings(int n, int[][] rides) {
        /**
         * dp[i]表示到达i地点为止的最大盈利
         */
        long[] dp = new long[n + 1];
        /**
         * 将所有乘客信息按照终点升序排列
         */
        Arrays.sort(rides, Comparator.comparingInt(x -> x[1]));
        int index = 0;

        for (int i = 1; i <= n; i++) {
            /**
             * 如果没有乘客到达地点i，则到达地点i的盈利和地点i-1相同
             */
            dp[i] = dp[i - 1];
            /**
             * 判断所有到达地点i的乘客信息能否使到达i地点为止的盈利更大
             */
            while (index < rides.length && rides[index][1] == i) {
                int start = rides[index][0];
                int end = rides[index][1];
                int tip = rides[index][2];
                dp[i] = Math.max(dp[i], dp[start] + (end - start + tip));
                index++;
            }
        }
        return dp[n];
    }
}
