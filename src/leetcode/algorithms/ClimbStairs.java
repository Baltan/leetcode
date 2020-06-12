package leetcode.algorithms;

/**
 * Description: 70. Climbing Stairs
 *
 * @author Baltan
 * @date 2018/1/5 11:23
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

    public static int climbStairs(int n) {
        /**
         * dp[i]表示爬到第i个台阶方法的种数
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
