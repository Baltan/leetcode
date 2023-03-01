package leetcode.algorithms;

/**
 * Description: 1463. Cherry Pickup II
 *
 * @author Baltan
 * @date 2023/2/28 09:32
 */
public class CherryPickup {
    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}));
        System.out.println(cherryPickup(new int[][]{{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}));
        System.out.println(cherryPickup(new int[][]{{1, 0, 0, 3}, {0, 0, 0, 3}, {0, 0, 3, 3}, {9, 0, 3, 3}}));
        System.out.println(cherryPickup(new int[][]{{1, 1}, {1, 1}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/cherry-pickup-ii/solutions/1516036/jsdong-tai-gui-hua-dai-zhu-shi-by-lingli-2x1k/"></a>
     *
     * @param grid
     * @return
     */
    public static int cherryPickup(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j][k]表示到达第i行时，第一个机器人在grid[i][j]格子，第二个机器人在grid[i][k]格子，能得到的樱桃总数
         */
        int[][][] dp = new int[rows][cols][cols];
        /**
         * 将所有dp[i][j][k]初始化为Integer.MIN_VALUE，表示假设每个格子都无法到达
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        /**
         * 初始状态，两个机器人在第0行的情况
         */
        dp[0][0][cols - 1] = grid[0][0] + grid[0][cols - 1];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    /**
                     * 对于dp[i][j][k]来说，两个机器人至多可以从以下9种情况到达：
                     * dp[i-1][j-1][k-1]、dp[i-1][j-1][k]、dp[i-1][j-1][k+1]
                     * dp[i-1][j][k-1]、dp[i-1][j][k]、dp[i-1][j][k+1]
                     * dp[i-1][j+1][k-1]、dp[i-1][j+1][k]、dp[i-1][j+1][k+1]
                     */
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (l < 0 || l == cols) {
                            continue;
                        }

                        for (int m = k - 1; m <= k + 1; m++) {
                            if (m < 0 || m == cols) {
                                continue;
                            }

                            if (j == k) {
                                /**
                                 * 如果两个机器人到达的grid[i][j]和grid[i][k]是同一个格子，则这个格子的樱桃只能被计数一次
                                 */
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][l][m] + grid[i][j]);
                            } else {
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][l][m] + grid[i][j] + grid[i][k]);
                            }
                        }
                    }
                }
            }
        }
        /**
         * 在两个机器人到达最后一行的所有情况中查找樱桃数量的最大值
         */
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
                result = Math.max(result, dp[rows - 1][i][j]);
            }
        }
        return result;
    }
}
