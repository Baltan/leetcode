package leetcode.algorithms;

/**
 * Description: 764. Largest Plus Sign
 *
 * @author Baltan
 * @date 2022/11/15 11:30
 */
public class OrderOfLargestPlusSign {
    public static void main(String[] args) {
        int[][] mines1 = {{4, 2}};
        System.out.println(orderOfLargestPlusSign(5, mines1));

        int[][] mines2 = {{0, 0}};
        System.out.println(orderOfLargestPlusSign(1, mines2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/largest-plus-sign/solutions/1958456/by-ac_oier-q932/"></a>
     *
     * @param n
     * @param mines
     * @return
     */
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int result = 0;
        int[][] grid = new int[n][n];
        /**
         * dpL2R[i][j]表示从左到右方向上以grid[i][j]结尾的连续的1的个数
         */
        int[][] dpL2R = new int[n][n];
        /**
         * dpR2L[i][j]表示从右到左方向上以grid[i][j]结尾的连续的1的个数
         */
        int[][] dpR2L = new int[n][n];
        /**
         * dpU2D[i][j]表示从上到下方向上以grid[i][j]结尾的连续的1的个数
         */
        int[][] dpU2D = new int[n][n];
        /**
         * dpD2U[i][j]表示从下到上方向上以grid[i][j]结尾的连续的1的个数
         */
        int[][] dpD2U = new int[n][n];
        /**
         * 初始化矩阵的所有网格值为1
         */
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                grid[row][col] = 1;
            }
        }
        /**
         * 标记值为0的网格
         */
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        /**
         * 计算从左到右和从右到左方向上连续的1的个数
         */
        for (int row = 0; row < n; row++) {
            dpL2R[row][0] = grid[row][0] == 1 ? 1 : 0;
            dpR2L[row][n - 1] = grid[row][n - 1] == 1 ? 1 : 0;

            for (int col = 1; col < n; col++) {
                dpL2R[row][col] = grid[row][col] == 1 ? dpL2R[row][col - 1] + 1 : 0;
            }

            for (int col = n - 2; col >= 0; col--) {
                dpR2L[row][col] = grid[row][col] == 1 ? dpR2L[row][col + 1] + 1 : 0;
            }
        }
        /**
         * 计算从上到下和从下到上方向上连续的1的个数
         */
        for (int col = 0; col < n; col++) {
            dpU2D[0][col] = grid[0][col] == 1 ? 1 : 0;
            dpD2U[n - 1][col] = grid[n - 1][col] == 1 ? 1 : 0;

            for (int row = 1; row < n; row++) {
                dpU2D[row][col] = grid[row][col] == 1 ? dpU2D[row - 1][col] + 1 : 0;
            }

            for (int row = n - 2; row >= 0; row--) {
                dpD2U[row][col] = grid[row][col] == 1 ? dpD2U[row + 1][col] + 1 : 0;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int order = Integer.MAX_VALUE;
                /**
                 * 以grid[row][col]为中心网格的十字的阶就是，以该网格为结尾的四个方向上连续的1的个数的最小值
                 */
                order = Math.min(order, dpL2R[row][col]);
                order = Math.min(order, dpR2L[row][col]);
                order = Math.min(order, dpU2D[row][col]);
                order = Math.min(order, dpD2U[row][col]);
                result = Math.max(result, order);
            }
        }
        return result;
    }
}
