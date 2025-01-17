package leetcode.algorithms;

/**
 * Description: 3418. Maximum Amount of Money Robot Can Earn
 *
 * @author Baltan
 * @date 2025/1/17 23:27
 */
public class MaximumAmount {
    public static void main(String[] args) {
        System.out.println(maximumAmount(new int[][]{{-4}}));
        System.out.println(maximumAmount(new int[][]{{0, 1, -1}, {1, -2, 3}, {2, -3, 4}}));
        System.out.println(maximumAmount(new int[][]{{10, 10, 10}, {10, 10, 10}}));
    }

    public static int maximumAmount(int[][] coins) {
        int rows = coins.length;
        int cols = coins[0].length;
        /**
         * dp[i][j][k]表示到达单元格coins[i][j]，并且感化人数为k时的最大金币数
         */
        int[][][] dp = new int[rows][cols][3];
        dp[0][0][0] = coins[0][0];
        /**
         * 对于任意一个单元格，如果感化了机器人，可以得到的金币数为max(0,coins[0][0])
         */
        dp[0][0][1] = getMax(0, coins[0][0]);
        dp[0][0][2] = getMax(0, coins[0][0]);
        /**
         * 计算第0行的每个单元格的最大金币数
         */
        for (int i = 1; i < cols; i++) {
            dp[0][i][0] = dp[0][i - 1][0] + coins[0][i];
            dp[0][i][1] = getMax(dp[0][i - 1][1] + coins[0][i], dp[0][i - 1][0] + getMax(0, coins[0][i]));
            dp[0][i][2] = getMax(dp[0][i - 1][2] + coins[0][i], dp[0][i - 1][1] + getMax(0, coins[0][i]));
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0][0] = dp[i - 1][0][0] + coins[i][0];
            dp[i][0][1] = getMax(dp[i - 1][0][1] + coins[i][0], dp[i - 1][0][0] + getMax(0, coins[i][0]));
            dp[i][0][2] = getMax(dp[i - 1][0][2] + coins[i][0], dp[i - 1][0][1] + getMax(0, coins[i][0]));

            for (int j = 1; j < cols; j++) {
                dp[i][j][0] = getMax(dp[i - 1][j][0] + coins[i][j], dp[i][j - 1][0] + coins[i][j]);
                dp[i][j][1] = getMax(dp[i - 1][j][1] + coins[i][j], dp[i][j - 1][1] + coins[i][j], dp[i - 1][j][0] + getMax(0, coins[i][j]), dp[i][j - 1][0] + getMax(0, coins[i][j]));
                dp[i][j][2] = getMax(dp[i - 1][j][2] + coins[i][j], dp[i][j - 1][2] + coins[i][j], dp[i - 1][j][1] + getMax(0, coins[i][j]), dp[i][j - 1][1] + getMax(0, coins[i][j]));
            }
        }
        /**
         * 感化的机器人越多，得到的金币数一定也越多，所以直接返回感化了2个机器人的情况
         */
        return dp[rows - 1][cols - 1][2];
    }

    /**
     * 计算数组nums中所有数字的最大值
     *
     * @param nums
     * @return
     */
    public static int getMax(int... nums) {
        int max = Integer.MIN_VALUE;

        for (int value : nums) {
            max = Math.max(max, value);
        }
        return max;
    }
}
