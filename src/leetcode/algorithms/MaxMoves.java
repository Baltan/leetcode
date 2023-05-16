package leetcode.algorithms;

/**
 * Description: 2684. Maximum Number of Moves in a Grid
 *
 * @author Baltan
 * @date 2023/5/14 22:30
 */
public class MaxMoves {
    public static void main(String[] args) {
        System.out.println(maxMoves(new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}));
        System.out.println(maxMoves(new int[][]{{3, 2, 4}, {2, 1, 9}, {1, 1, 7}}));
    }

    public static int maxMoves(int[][] grid) {
        /**
         * 最远可以到达的列的索引
         */
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j]表示是否可以到达格子grid[i][j]
         */
        boolean[][] dp = new boolean[rows][cols];
        /**
         * 从第一列任意一个格子出发，所以第一列所有格子都能到达
         */
        for (int row = 0; row < rows; row++) {
            dp[row][0] = true;
        }

        for (int col = 1; col < cols; col++) {
            /**
             * 当前列是否有某个格子可以到达
             */
            boolean reachable = false;

            for (int row = 0; row < rows; row++) {
                /**
                 * 判断是否可能从grid[row-1][col-1]、grid[row][col-1]、grid[row+1][col-1]中的任意一个格子到达grid[row][col]
                 */
                dp[row][col] = (row - 1 >= 0 && dp[row - 1][col - 1] && grid[row - 1][col - 1] < grid[row][col]) ||
                        (dp[row][col - 1] && grid[row][col - 1] < grid[row][col]) ||
                        (row + 1 < rows && dp[row + 1][col - 1] && grid[row + 1][col - 1] < grid[row][col]);
                reachable |= dp[row][col];
            }

            if (reachable) {
                result = col;
            }
        }
        return result;
    }
}
