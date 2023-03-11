package leetcode.algorithms;

/**
 * Description: 2088. Count Fertile Pyramids in a Land
 *
 * @author Baltan
 * @date 2023/3/10 15:13
 */
public class CountPyramids {
    public static void main(String[] args) {
        System.out.println(countPyramids(new int[][]{{0, 1, 1, 0}, {1, 1, 1, 1}}));
        System.out.println(countPyramids(new int[][]{{1, 1, 1}, {1, 1, 1}}));
        System.out.println(countPyramids(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}));
        System.out.println(countPyramids(new int[][]{{1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {0, 1, 0, 0, 1}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/count-fertile-pyramids-in-a-land/solutions/1127126/tong-ji-nong-chang-zhong-fei-wo-jin-zi-t-paok/"></a>
     *
     * @param grid
     * @return
     */
    public static int countPyramids(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j]表示以grid[i][j]作为金字塔顶端格子时，可以构成的金字塔的最大层高
         */
        int[][] dp = new int[rows][cols];
        /**
         * 计算所有正金字塔的个数
         */
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i == rows - 1 || j == 0 || j == cols - 1) {
                        /**
                         * 假设单独的一个肥沃的格子也算作是一个层高为一层的金字塔
                         */
                        dp[i][j] = 1;
                    } else {
                        /**
                         * 如果可以以grid[i][j]作为金字塔顶端格子构成层高为x的金字塔，则等价于可以以grid[i+1][j-1]、grid[i+1][j]、
                         * grid[i+1][j+1]构成层高为x-1的金字塔，三种情况取最小值
                         */
                        dp[i][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + 1;
                        /**
                         * 需要将层高为一层的金字塔排除
                         */
                        result += dp[i][j] - 1;
                    }
                }
            }
        }
        /**
         * 计算所有倒金字塔的个数
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0 || j == cols - 1) {
                        /**
                         * 假设单独的一个肥沃的格子也算作是一个层高为一层的金字塔
                         */
                        dp[i][j] = 1;
                    } else {
                        /**
                         * 如果可以以grid[i][j]作为金字塔顶端格子构成层高为x的金字塔，则等价于可以以grid[i-1][j-1]、grid[i-1][j]、
                         * grid[i-1][j+1]构成层高为x-1的金字塔，三种情况取最小值
                         */
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + 1;
                        /**
                         * 需要将层高为一层的金字塔排除
                         */
                        result += dp[i][j] - 1;
                    }
                }
            }
        }
        return result;
    }
}
