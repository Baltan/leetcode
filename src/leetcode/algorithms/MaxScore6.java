package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 3148. Maximum Difference Score in a Grid
 *
 * @author Baltan
 * @date 2024/5/17 21:46
 */
public class MaxScore6 {
    public static void main(String[] args) {
        List<List<Integer>> grid1 = Arrays.asList(
                Arrays.asList(9, 5, 7, 3),
                Arrays.asList(8, 9, 6, 1),
                Arrays.asList(6, 7, 14, 3),
                Arrays.asList(2, 5, 3, 1)
        );
        System.out.println(maxScore(grid1));

        List<List<Integer>> grid2 = Arrays.asList(
                Arrays.asList(4, 3, 2),
                Arrays.asList(3, 2, 1)
        );
        System.out.println(maxScore(grid2));
    }

    public static int maxScore(List<List<Integer>> grid) {
        /**
         * 被选中的所有单元格经过计算后，结果就是选中的最右下方的单元格中的值减去最左上方的单元格中的值，所以为了使结果最大，只需要找到每个单
         * 元格的右方、下方、右下方所有单元格中的最大值即可
         */
        int result = Integer.MIN_VALUE;
        int rows = grid.size();
        int cols = grid.get(0).size();
        /**
         * dp[i][j]表示grid[i][j]右方、下方、右下方所有单元格中的最大值
         */
        int[][] dp = new int[rows][cols];
        /**
         * grid中的所有单元格一一映射到dp中的单元格
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = grid.get(i).get(j);
            }
        }
        /**
         * 计算最后一行的每个单元格其右方所有单元格中的最大值
         */
        for (int i = cols - 2; i >= 0; i--) {
            result = Math.max(result, dp[rows - 1][i + 1] - dp[rows - 1][i]);

            if (dp[rows - 1][i] <= dp[rows - 1][i + 1]) {
                dp[rows - 1][i] = dp[rows - 1][i + 1];
            }
        }
        /**
         * 计算最后一列的每个单元格其下方所有单元格中的最大值
         */
        for (int i = rows - 2; i >= 0; i--) {
            result = Math.max(result, dp[i + 1][cols - 1] - dp[i][cols - 1]);

            if (dp[i][cols - 1] <= dp[i + 1][cols - 1]) {
                dp[i][cols - 1] = dp[i + 1][cols - 1];
            }
        }
        /**
         * 计算其余行和列的每个单元格右方、下方、右下方所有单元格中的最大值
         */
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int max = Math.max(dp[i + 1][j], dp[i][j + 1]);
                result = Math.max(result, max - dp[i][j]);

                if (dp[i][j] <= max) {
                    dp[i][j] = max;
                }
            }
        }
        return result;
    }
}
