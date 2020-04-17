package leetcode.algorithms;

/**
 * Description: 1411. Number of Ways to Paint N × 3 Grid
 *
 * @author Baltan
 * @date 2020-04-17 22:55
 */
public class NumOfWays {
    public static void main(String[] args) {
        System.out.println(numOfWays(1));
        System.out.println(numOfWays(2));
        System.out.println(numOfWays(3));
        System.out.println(numOfWays(7));
        System.out.println(numOfWays(5000));
    }

    public static int numOfWays(int n) {
        /**
         * 第一行可以有6种ABA的方案和6种ABC的方案。对于每一行的ABA方案，下一行可以有BAB、BCB、CAC
         * 3种对称方案和BAC、CAB2种非对称方案；对于每一行的ABC方案，下一行可以有BAB、BCB2种对称方
         * 案和BCA、CAB2种非对称方案。
         * dp[i][0]表示第i行对称方案的个数，dp[i][1]表示第i行非对称方案的个数
         */
        long[][] dp = new long[n + 1][2];
        dp[1][0] = 6;
        dp[1][1] = 6;
        int mod = 1000000007;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] * 3 + dp[i - 1][1] * 2) % mod;
            dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1] * 2) % mod;
        }
        return (int) ((dp[n][0] + dp[n][1]) % mod);
    }
}
