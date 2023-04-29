package leetcode.algorithms;

/**
 * Description: 2585. Number of Ways to Earn Points
 *
 * @author Baltan
 * @date 2023/4/21 09:46
 */
public class WaysToReachTarget {
    public static void main(String[] args) {
        System.out.println(waysToReachTarget(6, new int[][]{{6, 1}, {3, 2}, {2, 3}}));
        System.out.println(waysToReachTarget(5, new int[][]{{50, 1}, {50, 2}, {50, 5}}));
        System.out.println(waysToReachTarget(18, new int[][]{{6, 1}, {3, 2}, {2, 3}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/number-of-ways-to-earn-points/solutions/2148313/fen-zu-bei-bao-pythonjavacgo-by-endlessc-ludl/"></a>
     *
     * @param target
     * @param types
     * @return
     */
    public static int waysToReachTarget(int target, int[][] types) {
        int mod = 1000000007;
        int length = types.length;
        /**
         * dp[i][j]表示选择过第i种题目后，总得分为j分的方法数
         */
        long[][] dp = new long[length][target + 1];
        /**
         * 第0种题目，可以解答的数量为[0,types[0][0]]，对应的得分为i*types[0][1]
         */
        for (int i = 0; i <= types[0][0]; i++) {
            if (i * types[0][1] > target) {
                break;
            }
            dp[0][i * types[0][1]] = 1;
        }
        /**
         * 依次选择每种题目
         */
        for (int i = 1; i < length; i++) {
            /**
             * 第i种题目，可以解答的数量为[0,types[i][0]]
             */
            for (int j = 0; j <= types[i][0]; j++) {
                /**
                 * 解答j个题目的得分为j*types[i][1]
                 */
                int currentScore = types[i][1] * j;
                /**
                 * 如果当前类型题目得分为currentScore，则之前类型的题目至多得target-currentScore分
                 */
                for (int k = target - currentScore; k >= 0; k--) {
                    dp[i][k + currentScore] = (dp[i][k + currentScore] + dp[i - 1][k]) % mod;
                }
            }
        }
        return (int) dp[length - 1][target];
    }
}
