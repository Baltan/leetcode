package leetcode.algorithms;

/**
 * Description: 63. Unique Paths II
 *
 * @author Baltan
 * @date 2018/9/20 12:30
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
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] grid = new int[n][m + n - 1];
        grid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i <= m + n - 2; i++) {
            for (int j = 0; j <= i && j < n; j++) {
                int leftPathNum = 0;
                int topPathNum = 0;
                if (i - j - 1 >= 0) {
                    leftPathNum = grid[j][i - j - 1];
                }
                if (j - 1 >= 0) {
                    topPathNum = grid[j - 1][i - j];
                }
                if (j < n && i - j < m) {
                    grid[j][i - j] = obstacleGrid[j][i - j] == 1 ? 0 : leftPathNum + topPathNum;
                } else {
                    grid[j][i - j] = leftPathNum + topPathNum;
                }
            }
        }
        return grid[n - 1][m - 1];
    }
}
