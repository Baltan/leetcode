package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3122. Minimum Number of Operations to Satisfy Conditions
 *
 * @author baltan
 * @date 2024/4/23 10:50
 */
public class MinimumOperations5 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[][]{{1, 0, 2}, {1, 0, 2}}));
        System.out.println(minimumOperations(new int[][]{{1, 1, 1}, {0, 0, 0}}));
        System.out.println(minimumOperations(new int[][]{{1}, {2}, {3}}));
    }

    public static int minimumOperations(int[][] grid) {
        int result = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * counts[i]表示矩阵grid当前列中值为i的单元格的个数
         */
        int[] counts = new int[10];
        /**
         * dp[i][j]表示矩阵grid的最左边i列构成的子矩阵中，如果第i-1列单元格的值都为j时，需要的最小操作次数
         */
        int[][] dp = new int[cols + 1][10];

        for (int i = 1; i <= cols; i++) {
            Arrays.fill(counts, 0);
            /**
             * 计算矩阵grid当前第i-1列中不同值的单元格的个数
             */
            for (int j = 0; j < rows; j++) {
                counts[grid[j][i - 1]]++;
            }
            /**
             * 假设令当前第i-1列最终所有单元格中的值都变为j
             */
            for (int j = 0; j <= 9; j++) {
                /**
                 * 矩阵grid的最左边i-1列构成的子矩阵中，如果第i-2列单元格的值不为j时，需要的最小操作次数
                 */
                int min = Integer.MAX_VALUE;
                /**
                 * 如果第i-1列的单元格中的值都为j，则第i-2列单元格中的值不能为j（[0,9]除j以外的任意值）
                 */
                for (int k = 0; k <= 9; k++) {
                    if (k == j) {
                        continue;
                    }
                    min = Math.min(min, dp[i - 1][k]);
                }
                /**
                 * 如果令当前第i-1列最终所有单元格中的值都变为j，则当前列需要操作rows-counts[j]次
                 */
                dp[i][j] = min + rows - counts[j];
            }
        }
        /**
         * 遍历最终列为[0,9]时的所有情况，选择操作次数最少的情况即可
         */
        for (int i = 0; i <= 9; i++) {
            result = Math.min(result, dp[cols][i]);
        }
        return result;
    }
}
