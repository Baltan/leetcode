package leetcode.algorithms;

/**
 * Description: 3693. Climbing Stairs II
 *
 * @author baltan
 * @date 2025/11/12 16:56
 */
public class ClimbStairs1 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4, new int[]{1, 2, 3, 4}));
        System.out.println(climbStairs(4, new int[]{5, 1, 6, 2}));
        System.out.println(climbStairs(3, new int[]{9, 8, 3}));
    }

    public static int climbStairs(int n, int[] costs) {
        /**
         * dp[i]表示跳到第i级台阶的最小成本
         */
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            /**
             * 依次计算从第i-1、i-2、i-3级台阶跳到第i级台阶的最小成本
             */
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + costs[i - 1] + j * j);
                }
            }
        }
        return dp[n];
    }
}
