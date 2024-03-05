package leetcode.algorithms;

/**
 * Description: 3070. Count Submatrices with Top-Left Element and Sum Less Than k
 *
 * @author Baltan
 * @date 2024/3/5 21:20
 */
public class CountSubmatrices {
    public static void main(String[] args) {
        System.out.println(countSubmatrices(new int[][]{{7, 6, 3}, {6, 6, 1}}, 18));
        System.out.println(countSubmatrices(new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}}, 20));
    }

    public static int countSubmatrices(int[][] grid, int k) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * prefixSums[i][j]表示从左上角单元格开始的i行j+1列的矩阵中所有单元格中数字的和
         */
        int[][] prefixSums = new int[rows + 1][cols];

        for (int i = 0; i < rows; i++) {
            /**
             * prefixSum为第i行中最左侧j+1个单元格中数字的和
             */
            int prefixSum = 0;

            for (int j = 0; j < cols; j++) {
                prefixSum += grid[i][j];
                prefixSums[i + 1][j] = prefixSums[i][j] + prefixSum;

                if (prefixSums[i + 1][j] <= k) {
                    result++;
                }
            }
        }
        return result;
    }
}
