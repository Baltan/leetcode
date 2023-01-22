package leetcode.algorithms;

/**
 * Description: 2304. Minimum Path Cost in a Grid
 *
 * @author Baltan
 * @date 2023/1/20 15:51
 */
public class MinPathCost {
    public static void main(String[] args) {
        int[][] grid1 = {{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost1 = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        System.out.println(minPathCost(grid1, moveCost1));

        int[][] grid2 = {{5, 1, 2}, {4, 0, 3}};
        int[][] moveCost2 = {{12, 10, 15}, {20, 23, 8}, {21, 7, 1}, {8, 1, 13}, {9, 10, 25}, {5, 3, 2}};
        System.out.println(minPathCost(grid2, moveCost2));
    }

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int result = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j][k]表示从grid[0][j]到grid[i][k]的最小路径代价，其中i∈[0,rows)，依次从小到大计算
         */
        int[][][] dp = new int[rows][cols][cols];
        /**
         * 计算从grid[0][j]到达grid[0][k]的最小路径代价，当j≠k时，说明不存在这样的路径，将路径代价初始化成一个较大值，表示不可能（但是不能初
         * 始化为Integer.MAX_VALUE，否则后面计算可能发生整型溢出）
         */
        for (int j = 0; j < cols; j++) {
            for (int k = 0; k < cols; k++) {
                if (j == k) {
                    dp[0][j][k] = grid[0][j];
                } else {
                    dp[0][j][k] = Integer.MAX_VALUE / 2;
                }
            }
        }
        /**
         * 计算从grid[0][j]到达grid[i][k]的最小路径代价
         */
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                    /**
                     * 从grid[0][j]到达grid[i][k]可以经过grid[i-1][0]、grid[i-1][1]、……、grid[i-1][l]到达
                     */
                    for (int l = 0; l < cols; l++) {
                        /**
                         * grid[i-1][l]网格的值
                         */
                        int from = grid[i - 1][l];
                        int cost = dp[i - 1][j][l] + moveCost[from][k] + grid[i][k];
                        dp[i][j][k] = Math.min(dp[i][j][k], cost);
                    }
                }
            }
        }
        /**
         * 获得从grid[0][j]到grid[rows-1][k]的最小路径代价
         */
        for (int j = 0; j < cols; j++) {
            for (int k = 0; k < cols; k++) {
                result = Math.min(result, dp[rows - 1][j][k]);
            }
        }
        return result;
    }
}
