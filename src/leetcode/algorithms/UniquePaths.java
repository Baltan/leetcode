package leetcode.algorithms;

/**
 * Description: 62. Unique Paths
 *
 * @author Baltan
 * @date 2018/9/20 11:13
 * @see UniquePathsWithObstacles
 * @see leetcode.interview.PathWithObstacles
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[n][m + n];
        grid[0][0] = 1;
        for (int i = 1; i < m + n; i++) {
            for (int j = 0; j <= i && j < n; j++) {
                int leftPathNum = 0;
                int topPathNum = 0;
                if (i - j - 1 >= 0) {
                    leftPathNum = grid[j][i - j - 1];
                }
                if (j - 1 >= 0) {
                    topPathNum = grid[j - 1][i - j];
                }
                grid[j][i - j] = leftPathNum + topPathNum;
            }
        }
        return grid[n - 1][m - 1];
    }
}
