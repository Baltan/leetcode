package leetcode.algorithms;

/**
 * Description: 1473. Paint House III
 *
 * @author Baltan
 * @date 2023/3/21 14:11
 */
public class MinCost3 {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
        System.out.println(minCost(new int[]{0, 2, 1, 2, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
        System.out.println(minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}}, 5, 2, 5));
        System.out.println(minCost(new int[]{3, 1, 2, 3}, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 4, 3, 3));
    }

    public static int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int result = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE / 2;
        /**
         * dp[i][j][k]表示从左至右到第i个房子为止，且第i个房子的颜色为j时，刚好构成了k个街区的最小总花费
         */
        int[][][] dp = new int[m][n + 1][target + 1];
        /**
         * 初始化所有情况为一个较大值，表示每种情况都没有可用的涂色方案
         */
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= target; k++) {
                    dp[i][j][k] = max;
                }
            }
        }
        /**
         * 对于第一个房子而言，如果它本身就有颜色x，则只可能达成一种情况，即dp[0][x][1]，且不用任何花费；如果它没被涂色，则可以被涂上任意一种
         * 颜色y，实现dp[0][y][1]这种情况，需要的花费为cost[0][y-1]
         */
        for (int i = 1; i <= n; i++) {
            if (houses[0] == 0) {
                dp[0][i][1] = cost[0][i - 1];
            } else if (houses[0] == i) {
                dp[0][i][1] = 0;
            }
        }
        /**
         * 从第二个房子开始依次计算每种情况的最小总花费
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    /**
                     * 如果第i个房子本身就有颜色，则只有本身的颜色为j时，才有可能达成dp[i][j][k]这种情况
                     */
                    if (houses[i] != 0 && houses[i] == j) {
                        /**
                         * 枚举第i-1个房子的颜色，如果第i-1个房子也是颜色j，则到第i个房子为止街区的数量和到第i-1个房子为止街区的数量相等；
                         * 如果第i-1个房子不是颜色j，则到第i个房子为止街区的数量比到第i-1个房子为止街区的数量多一个
                         */
                        for (int l = 1; l <= n; l++) {
                            if (l == j) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k]);
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k - 1]);
                            }
                        }
                        /**
                         * 如果第i个房子没被涂色，则将其涂上颜色j，需要的花费为cost[i][j-1]
                         */
                    } else if (houses[i] == 0) {
                        /**
                         * 枚举第i-1个房子的颜色，如果第i-1个房子也是颜色j，则到第i个房子为止街区的数量和到第i-1个房子为止街区的数量相等；
                         * 如果第i-1个房子不是颜色j，则到第i个房子为止街区的数量比到第i-1个房子为止街区的数量多一个
                         */
                        for (int l = 1; l <= n; l++) {
                            if (l == j) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k] + cost[i][j - 1]);
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k - 1] + cost[i][j - 1]);
                            }
                        }
                    }
                }
            }
        }
        /**
         * 到最后一个房子为止正好形成target个街区，且最后一个房子的颜色可能为[1,n]其中的某种情况，在这n种情况中取花费的最小值
         */
        for (int i = 1; i <= n; i++) {
            result = Math.min(result, dp[m - 1][i][target]);
        }
        /**
         * 如果花费的最小值为max，说明没有可用的涂色方案
         */
        return result == max ? -1 : result;
    }
}
