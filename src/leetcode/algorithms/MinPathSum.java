package leetcode.algorithms;

/**
 * Description: 64. Minimum Path Sum
 *
 * @author Baltan
 * @date 2018/9/21 12:13
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid1));

        int[][] grid2 = {{}};
        System.out.println(minPathSum(grid2));

        int[][] grid3 = {};
        System.out.println(minPathSum(grid3));

        int[][] grid4 = {{3}};
        System.out.println(minPathSum(grid4));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j]表示走到grid[i][j]路径上数字总和的最小值
         */
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                /**
                 * dp[j][i]可以通过左侧的单元格或者上方的单元格到达
                 */
                dp[j][i] = Math.min(dp[j][i - 1], dp[j - 1][i]) + grid[j][i];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
