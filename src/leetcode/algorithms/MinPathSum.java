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

        int n = grid.length;
        int m = grid[0].length;
        int[][] mark = new int[n][m];
        mark[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            mark[0][i] = mark[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            mark[i][0] = mark[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mark[j][i] = Math.min(mark[j][i - 1] + grid[j][i], mark[j - 1][i] + grid[j][i]);
            }
        }
        return mark[n - 1][m - 1];
    }
}
