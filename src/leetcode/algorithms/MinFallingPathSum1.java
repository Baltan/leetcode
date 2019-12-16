package leetcode.algorithms;

/**
 * Description: 1289. Minimum Falling Path Sum II
 *
 * @author Baltan
 * @date 2019-12-16 09:42
 */
public class MinFallingPathSum1 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minFallingPathSum(arr1));

        int[][] arr2 = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, {4, 5, 6, 4, 5, 6, 4, 5, 6}, {7, 8, 9, 4, 6, 8, 4, 2, 5},
                {4, 8, 3, 1, 4, 6, 8, 3, 2}, {8, 5, 2, 1, 4, 7, 9, 4, 2}, {9, 6, 1, 2, 9, 4, 2, 4, 7}, {3, 7,
                4, 2, 4, 6, 8, 5, 2}, {5, 8, 9, 0, 2, 1, 5, 7, 9}, {1, 4, 7, 9, 1, 3, 6, 9, 8}};
        System.out.println(minFallingPathSum(arr2));

        int[][] arr3 = {{1, 2}, {4, 8}};
        System.out.println(minFallingPathSum(arr3));

        int[][] arr4 = {{50}};
        System.out.println(minFallingPathSum(arr4));
    }

    public static int minFallingPathSum(int[][] arr) {
        if (arr.length == 1) {
            return arr[0][0];
        }
        /**
         * 非零偏移下降路径数字和的最小值
         */
        int result = Integer.MAX_VALUE;
        int rows = arr.length;
        int cols = arr[0].length;
        /**
         * dp[i][j]表示从arr[i][j]开始的非零偏移下降路径数字最小和
         */
        int[][] dp = new int[rows][cols];
        /**
         * 某一行的所有非零偏移下降路径数字最小和中的最小值
         */
        int min1 = Integer.MAX_VALUE;
        /**
         * 某一行的所有非零偏移下降路径数字最小和中的次小值
         */
        int min2 = Integer.MAX_VALUE;
        /**
         * 某一行的所有非零偏移下降路径数字最小和中的最小值所在的索引位置
         */
        int min1Index = -1;
        /**
         * 某一行的所有非零偏移下降路径数字最小和中的次小值所在的索引位置
         */
        int min2Index = -1;
        /**
         * 初始化最后一行
         */
        for (int i = 0; i < cols; i++) {
            /**
             * 最后一行的每个位置非零偏移下降路径数字最小和就是该位置的数字的值
             */
            dp[rows - 1][i] = arr[rows - 1][i];
            /**
             * 更新最后一行的所有非零偏移下降路径数字最小和中的最小值和次小值的索引位置
             */
            if (dp[rows - 1][i] < min1) {
                min2 = min1;
                min1 = dp[rows - 1][i];
                min2Index = min1Index;
                min1Index = i;
            } else if (dp[rows - 1][i] < min2) {
                min2 = dp[rows - 1][i];
                min2Index = i;
            }
        }
        /**
         * 动态规划依次处理倒数第二行到第二行的每个位置的非零偏移下降路径
         */
        for (int i = rows - 2; i > 0; i--) {
            /**
             * 当前行的所有非零偏移下降路径数字最小和中的最小值所在的索引位置
             */
            int currRowMin1Index = 0;
            /**
             * 当前行的所有非零偏移下降路径数字最小和中的最小值所在的索引位置
             */
            int currRowMin2Index = 0;
            /**
             * 当前行的所有非零偏移下降路径数字最小和中的最小值
             */
            min1 = Integer.MAX_VALUE;
            /**
             * 当前行的所有非零偏移下降路径数字最小和中的次小值
             */
            min2 = Integer.MAX_VALUE;

            for (int j = 0; j < cols; j++) {
                /**
                 * 如果当前列索引和下一行的非零偏移下降路径数字最小和中的最小值所在的索引位置相同，则这
                 * 个位置的非零偏移下降路径数字最小和为"该位置的数字的值"加"下一行的所有非零偏移下降路
                 * 径数字最小和中的次小值"，否则这个位置的非零偏移下降路径数字最小和为"该位置的数字的值"
                 * 加"下一行的所有非零偏移下降路径数字最小和中的最小值"
                 */
                if (j == min1Index) {
                    dp[i][j] = arr[i][j] + dp[i + 1][min2Index];
                } else {
                    dp[i][j] = arr[i][j] + dp[i + 1][min1Index];
                }
                /**
                 * 更新当前行的所有非零偏移下降路径数字最小和中的最小值和次小值的索引位置
                 */
                if (dp[i][j] < min1) {
                    min2 = min1;
                    min1 = dp[i][j];
                    currRowMin2Index = currRowMin1Index;
                    currRowMin1Index = j;
                } else if (dp[i][j] < min2) {
                    min2 = dp[i][j];
                    currRowMin2Index = j;
                }
            }
            /**
             * 当前行的所有非零偏移下降路径数字最小和中的最小值和次小值的索引位置，用于下一轮循环上一行
             * 的计算
             */
            min1Index = currRowMin1Index;
            min2Index = currRowMin2Index;
        }
        /**
         * 处理第一行的每个位置的非零偏移下降路径
         */
        for (int i = 0; i < cols; i++) {
            /**
             * 如果当前列索引和第二行的非零偏移下降路径数字最小和中的最小值所在的索引位置相同，则这
             * 个位置的非零偏移下降路径数字最小和为"该位置的数字的值"加"第二行的所有非零偏移下降路
             * 径数字最小和中的次小值"，否则这个位置的非零偏移下降路径数字最小和为"该位置的数字的值"
             * 加"第二行的所有非零偏移下降路径数字最小和中的最小值"
             */
            if (i == min1Index) {
                dp[0][i] = arr[0][i] + dp[1][min2Index];
            } else {
                dp[0][i] = arr[0][i] + dp[1][min1Index];
            }
            /**
             * 更新非零偏移下降路径数字和的最小值
             */
            result = Math.min(result, dp[0][i]);
        }
        return result;
    }
}
