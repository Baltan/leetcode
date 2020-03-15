package leetcode.interview;

/**
 * Description: 面试题 08.01. 三步问题
 *
 * @author Baltan
 * @date 2020-03-15 17:08
 */
public class WaysToStep {
    public static void main(String[] args) {
        System.out.println(waysToStep(3));
        System.out.println(waysToStep(5));
        System.out.println(waysToStep(1));
    }

    public static int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            /**
             * 第i阶可以由第i-1阶上1阶到达
             */
            dp[i] = dp[i - 1];
            /**
             * 第i阶可以由第i-2阶上2阶到达
             */
            dp[i] = (dp[i] + dp[i - 2]) % mod;
            /**
             * 第i阶可以由第i-3阶上3阶到达
             */
            dp[i] = (dp[i] + dp[i - 3]) % mod;
        }
        return dp[n];
    }
}
