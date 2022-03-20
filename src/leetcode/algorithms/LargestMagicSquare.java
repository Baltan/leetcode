package leetcode.algorithms;

/**
 * Description: 1895. Largest Magic Square
 *
 * @author Baltan
 * @date 2022/3/19 21:25
 */
public class LargestMagicSquare {
    public static void main(String[] args) {
        int[][] grid1 = {{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}};
        System.out.println(largestMagicSquare(grid1));

        int[][] grid2 = {{5, 1, 3, 1}, {9, 3, 3, 1}, {1, 3, 3, 8}};
        System.out.println(largestMagicSquare(grid2));

        int[][] grid3 = {{1}};
        System.out.println(largestMagicSquare(grid3));
    }

    public static int largestMagicSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * rowPrefixSums的第i行表示二维数组grid第i行的前缀和
         */
        int[][] rowPrefixSums = new int[rows][cols + 1];
        /**
         * colPrefixSums的第i列表示二维数组grid第i列的前缀和
         */
        int[][] colPrefixSums = new int[rows + 1][cols];
        /**
         * 初始化二维数组grid每一行和每一列的前缀和
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowPrefixSums[i][j + 1] = rowPrefixSums[i][j] + grid[i][j];
                colPrefixSums[i + 1][j] = colPrefixSums[i][j] + grid[i][j];
            }
        }
        /**
         * 从大到小依次判断二维数组grid中是否存在边长为edge的幻方
         */
        outer:
        for (int edge = Math.min(rows, cols); edge > 0; edge--) {
            /**
             * 从grid[0][0]开始，逐行，再逐列地判断以grid[i][j]作为方阵的左上角坐标，是否可以构成边长为edge的幻方
             */
            for (int i = 0; i < rows; i++) {
                /**
                 * 二维数组grid的行数不足，需要缩小edge
                 */
                if (i + edge > rows) {
                    continue outer;
                }

                for (int j = 0; j < cols; j++) {
                    /**
                     * 二维数组grid的列数不足，从下一行的第0列开始继续判断
                     */
                    if (j + edge > cols) {
                        break;
                    }
                    /**
                     * 以当前方阵的第0行的所有元素之和作为基准，判断方阵中每一行、每一列、两条对角线上所有元素的和是否都相等
                     */
                    int base = rowPrefixSums[i][j + edge] - rowPrefixSums[i][j];

                    if (isMagicSquare(grid, rowPrefixSums, colPrefixSums, edge, i, j, base)) {
                        return edge;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 判断二维数组grid中左上角坐标为(i,j)，边长为edge的方阵是否为幻方
     *
     * @param grid
     * @param rowPrefixSums
     * @param colPrefixSums
     * @param edge
     * @param i
     * @param j
     * @param base
     * @return
     */
    public static boolean isMagicSquare(int[][] grid, int[][] rowPrefixSums, int[][] colPrefixSums, int edge,
                                        int i, int j, int base) {
        /**
         * 判断每一行所有元素的和是否为base
         */
        for (int k = i; k < i + edge; k++) {
            if (rowPrefixSums[k][j + edge] - rowPrefixSums[k][j] != base) {
                return false;
            }
        }
        /**
         * 判断每一列所有元素的和是否为base
         */
        for (int k = j; k < j + edge; k++) {
            if (colPrefixSums[i + edge][k] - colPrefixSums[i][k] != base) {
                return false;
            }
        }
        /**
         * 主对角线所有元素的和
         */
        int sum1 = 0;
        /**
         * 副对角线所有元素的和
         */
        int sum2 = 0;

        for (int k = 0; k < edge; k++) {
            sum1 += grid[i + k][j + k];
            sum2 += grid[i + k][j + edge - k - 1];
        }
        /**
         * 判断每条对角线上所有元素的和是否为base
         */
        if (sum1 != base || sum2 != base) {
            return false;
        }
        return true;
    }
}
