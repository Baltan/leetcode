package leetcode.algorithms;

/**
 * Description: 1155. Number of Dice Rolls With Target Sum
 *
 * @author Baltan
 * @date 2019-08-12 09:17
 */
public class NumRollsToTarget {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1, 6, 3));
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(numRollsToTarget(2, 5, 10));
        System.out.println(numRollsToTarget(1, 2, 3));
        System.out.println(numRollsToTarget(30, 30, 500));
        System.out.println(numRollsToTarget(30, 30, 700));
        System.out.println(numRollsToTarget(30, 30, 800));
    }

    public static int numRollsToTarget(int d, int f, int target) {
        /**
         * 投掷d次的总和至少为d，至多为d*f，如果target不在这个范围内，则不存在任何可能，直接返回0
         */
        if (d > target || d * f < target) {
            return 0;
        }
        /**
         * 投掷x次可以获得总和为y的情况总数为dp[x][y]
         */
        long[][] dp = new long[d + 1][target + 1];
        /**
         * 投掷1次，可以获得的最小值为1，最大值为f，但是只需要计算到Math.min(target, f)即可
         */
        for (int i = 1, max = Math.min(target, f); i <= max; i++) {
            dp[1][i] = 1;
        }
        /**
         * 计算投掷i次，获得总和sum时的情况总数
         */
        for (int i = 2; i <= d; i++) {
            /**
             * 投掷i次，可以获得的最小值为i，最大值为f*i，但是只需要计算到Math.min(target, i * f)即可，
             * 假设投掷i次获得的总和为j
             */
            for (int j = i, max = Math.min(target, i * f); j <= max; j++) {
                /**
                 * 若第i次投掷的结果为k，则前i-1次投掷的总和为j-k，前i-1次投掷的总和至少为i-1，只需考虑j-k不小于i-1的情况
                 */
                for (int k = 1; k <= f; k++) {
                    if (j - k >= i - 1) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
                /**
                 * 将投掷i次获得总和为j的情况总数模1000000007，否则后面数字会溢出long类型的上限
                 */
                dp[i][j] = dp[i][j] % 1000000007;
            }
        }
        return (int) dp[d][target];
    }
}
