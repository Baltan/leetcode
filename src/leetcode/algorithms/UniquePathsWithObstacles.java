package leetcode.algorithms;

/**
 * Description: 63. Unique Paths II
 *
 * @author Baltan
 * @date 2018/9/20 12:30
 * @see UniquePaths
 * @see leetcode.interview.PathWithObstacles
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));

        int[][] obstacleGrid2 = {{1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));

        int[][] obstacleGrid3 = {{0}, {1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid3));

        int[][] obstacleGrid4 = {{1, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid4));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        /**
         * dp[i][j]表示走到obstacleGrid[i][j]有几条不同路径
         */
        int[][] dp = new int[height][width];
        /**
         * 如果起点obstacleGrid[0][0]或终点obstacleGrid[height-1][width-1]处有障碍物，则没有可行路径
         */
        if (obstacleGrid[0][0] == 1 || obstacleGrid[height - 1][width - 1] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                /**
                 * 如果当前网格处有障碍物，则没有可行路径
                 */
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    /**
                     * 判断当前网格是否可以从上方网格到达
                     */
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    /**
                     * 判断当前网格是否可以从左方网格到达
                     */
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return dp[height - 1][width - 1];
    }
}
