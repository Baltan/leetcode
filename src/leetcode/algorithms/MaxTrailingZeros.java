package leetcode.algorithms;

/**
 * Description: 2245. Maximum Trailing Zeros in a Cornered Path
 *
 * @author Baltan
 * @date 2022/4/21 09:14
 */
public class MaxTrailingZeros {
    public static void main(String[] args) {
        int[][] grid1 = {{23, 17, 15, 3, 20}, {8, 1, 20, 27, 11}, {9, 4, 6, 2, 21}, {40, 9, 1, 10, 6},
                {22, 7, 4, 5, 3}};
        System.out.println(maxTrailingZeros(grid1));

        int[][] grid2 = {{4, 3, 2}, {7, 6, 1}, {8, 8, 8}};
        System.out.println(maxTrailingZeros(grid2));
    }

    public static int maxTrailingZeros(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * rowFactorPrefix[i][j+1][0]表示grid[i][0]到grid[i][j]这部分元素中因数2的个数之和，
         * rowFactorPrefix[i][j+1][1]表示grid[i][0]到grid[i][j]这部分元素中因数5的个数之和
         */
        int[][][] rowFactorPrefix = new int[rows][cols + 1][2];
        /**
         * colFactorPrefix[i+1][j][0]表示grid[0][j]到grid[i][j]这部分元素中因数2的个数之和，
         * colFactorPrefix[i+1][j][1]表示grid[0][j]到grid[i][j]这部分元素中因数5的个数之和
         */
        int[][][] colFactorPrefix = new int[rows + 1][cols][2];
        /**
         * numFactor[i][j][0]表示grid[i][j]自身因数2的个数，numFactor[i][j][1]表示grid[i][j]自身因数5的个数
         */
        int[][][] numFactor = new int[rows][cols][2];

        for (int i = 0; i < rows; i++) {
            /**
             * 计算第i行中，grid[i][0]到grid[i][j]这部分元素中因数2的个数之和与因数5的个数之和，同时计算grid[i][j]自身因数
             * 2的个数与因数5的个数
             */
            for (int j = 0; j < cols; j++) {
                int num = grid[i][j];
                rowFactorPrefix[i][j + 1][0] = rowFactorPrefix[i][j][0];
                rowFactorPrefix[i][j + 1][1] = rowFactorPrefix[i][j][1];

                while (num % 2 == 0) {
                    rowFactorPrefix[i][j + 1][0]++;
                    numFactor[i][j][0]++;
                    num /= 2;
                }

                while (num % 5 == 0) {
                    rowFactorPrefix[i][j + 1][1]++;
                    numFactor[i][j][1]++;
                    num /= 5;
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            /**
             * 计算第i列中，grid[0][i]到grid[j][i]这部分元素中因数2的个数之和与因数5的个数之和
             */
            for (int j = 0; j < rows; j++) {
                int num = grid[j][i];
                colFactorPrefix[j + 1][i][0] = colFactorPrefix[j][i][0];
                colFactorPrefix[j + 1][i][1] = colFactorPrefix[j][i][1];

                while (num % 2 == 0) {
                    colFactorPrefix[j + 1][i][0]++;
                    num /= 2;
                }

                while (num % 5 == 0) {
                    colFactorPrefix[j + 1][i][1]++;
                    num /= 5;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = Math.max(result,
                        /**
                         * 以grid[i][j]为拐点，向左向上的情况
                         */
                        Math.min(
                                /**
                                 * grid[i][0]到grid[i][j-1]这部分元素中因数2的个数之和
                                 */
                                rowFactorPrefix[i][j][0] +
                                        /**
                                         * grid[0][j]到grid[i-1][j]这部分元素中因数2的个数之和
                                         */
                                        colFactorPrefix[i][j][0] +
                                        numFactor[i][j][0],
                                /**
                                 * grid[i][0]到grid[i][j-1]这部分元素中因数5的个数之和
                                 */
                                rowFactorPrefix[i][j][1] +
                                        /**
                                         * grid[0][j]到grid[i-1][j]这部分元素中因数5的个数之和
                                         */
                                        colFactorPrefix[i][j][1] +
                                        numFactor[i][j][1]));
                /**
                 * 以grid[i][j]为拐点，向左向下的情况
                 */
                result = Math.max(result,
                        Math.min(
                                /**
                                 * grid[i][0]到grid[i][j-1]这部分元素中因数2的个数之和
                                 */
                                rowFactorPrefix[i][j][0] +
                                        /**
                                         * grid[i+1][j]到grid[rows][j]这部分元素中因数2的个数之和
                                         */
                                        (colFactorPrefix[rows][j][0] - colFactorPrefix[i + 1][j][0]) +
                                        numFactor[i][j][0],
                                /**
                                 * grid[i][0]到grid[i][j-1]这部分元素中因数5的个数之和
                                 */
                                rowFactorPrefix[i][j][1] +
                                        /**
                                         * grid[i+1][j]到grid[rows][j]这部分元素中因数5的个数之和
                                         */
                                        (colFactorPrefix[rows][j][1] - colFactorPrefix[i + 1][j][1])
                                        + numFactor[i][j][1]));
                /**
                 * 以grid[i][j]为拐点，向右向上的情况
                 */
                result = Math.max(result,
                        Math.min(
                                /**
                                 * grid[i][j+1]到grid[i][cols]这部分元素中因数2的个数之和
                                 */
                                (rowFactorPrefix[i][cols][0] - rowFactorPrefix[i][j + 1][0]) +
                                        /**
                                         * grid[0][j]到grid[i-1][j]这部分元素中因数2的个数之和
                                         */
                                        colFactorPrefix[i][j][0] +
                                        numFactor[i][j][0],
                                /**
                                 * grid[i][j+1]到grid[i][cols]这部分元素中因数5的个数之和
                                 */
                                (rowFactorPrefix[i][cols][1] - rowFactorPrefix[i][j + 1][1]) +
                                        /**
                                         * grid[0][j]到grid[i-1][j]这部分元素中因数5的个数之和
                                         */
                                        colFactorPrefix[i][j][1] +
                                        numFactor[i][j][1]));
                /**
                 * 以grid[i][j]为拐点，向右向下的情况
                 */
                result = Math.max(result,
                        Math.min(
                                /**
                                 * grid[i][j+1]到grid[i][cols]这部分元素中因数2的个数之和
                                 */
                                (rowFactorPrefix[i][cols][0] - rowFactorPrefix[i][j + 1][0]) +
                                        /**
                                         * grid[i+1][j]到grid[rows][j]这部分元素中因数2的个数之和
                                         */
                                        (colFactorPrefix[rows][j][0] - colFactorPrefix[i + 1][j][0]) +
                                        numFactor[i][j][0],
                                /**
                                 * grid[i][j+1]到grid[i][cols]这部分元素中因数5的个数之和
                                 */
                                (rowFactorPrefix[i][cols][1] - rowFactorPrefix[i][j + 1][1]) +
                                        /**
                                         * grid[i+1][j]到grid[rows][j]这部分元素中因数5的个数之和
                                         */
                                        (colFactorPrefix[rows][j][1] - colFactorPrefix[i + 1][j][1]) +
                                        numFactor[i][j][1]));
            }
        }
        return result;
    }
}
