package leetcode.algorithms;

/**
 * Description: 1269. Number of Ways to Stay in the Same Place After Some Steps
 *
 * @author Baltan
 * @date 2019-11-28 10:11
 */
public class NumWays {
    public static void main(String[] args) {
        System.out.println(numWays(3, 2));
        System.out.println(numWays(2, 4));
        System.out.println(numWays(4, 2));
        System.out.println(numWays(500, 200));
        System.out.println(numWays(100, 1000000));
    }

    public static int numWays(int steps, int arrLen) {
        /**
         * 最远可以走到的位置
         */
        int farthest = Math.min(arrLen, steps);
        /**
         * dp[i][j]表示第i步停留在第j个位置的走法，得出dp[i][j]=dp[i-1][j-1]+dp[i-1][j]+dp[i-1][j+1]
         */
        int[][] dp = new int[steps + 1][farthest + 1];
        dp[0][0] = 1;
        int mod = 1000000007;

        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= farthest; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }

                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;

                if (j < farthest - 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        return dp[steps][0];
    }
}
