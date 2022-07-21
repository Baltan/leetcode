package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1765. Map of Highest Peak
 *
 * @author Baltan
 * @date 2022/7/17 14:00
 * @see HighestPeak
 */
public class HighestPeak1 {
    public static void main(String[] args) {
        int[][] isWater1 = {{0, 1}, {0, 0}};
        OutputUtils.print2DIntegerArray(highestPeak(isWater1));

        System.out.println("------------------------------------------");

        int[][] isWater2 = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
        OutputUtils.print2DIntegerArray(highestPeak(isWater2));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/map-of-highest-peak/solution/mei-you-dong-tai-gui-hua-mei-you-dong-ta-sigq/"></a>
     *
     * @param isWater
     * @return
     */
    public static int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] result = new int[rows][cols];
        /**
         * 根据题意，至多有1000×1000个格子，所以格子的最大高度不会超过1000×1000
         */
        int heightUpperLimit = 1000 * 1000;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    /**
                     * 所有水域格子的高度为0
                     */
                    result[i][j] = 0;
                } else {
                    /**
                     * 将所有陆地格子的高度初始化为最大值，后面扫描的过程中缩小高度值
                     */
                    result[i][j] = heightUpperLimit;
                }
            }
        }
        /**
         * 从左上向右下扫描
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (result[i][j] != 0) {
                    /**
                     * 每个陆地格子的高度可以比上方相邻格子的高度大1
                     */
                    if (i > 0) {
                        result[i][j] = Math.min(result[i - 1][j] + 1, result[i][j]);
                    }
                    /**
                     * 每个陆地格子的高度可以比左方相邻格子的高度大1
                     */
                    if (j > 0) {
                        result[i][j] = Math.min(result[i][j - 1] + 1, result[i][j]);
                    }
                }
            }
        }
        /**
         * 从右下向左上扫描
         */
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (result[i][j] != 0) {
                    /**
                     * 每个陆地格子的高度可以比下方相邻格子的高度大1
                     */
                    if (i < rows - 1) {
                        result[i][j] = Math.min(result[i + 1][j] + 1, result[i][j]);
                    }
                    /**
                     * 每个陆地格子的高度可以比右方相邻格子的高度大1
                     */
                    if (j < cols - 1) {
                        result[i][j] = Math.min(result[i][j + 1] + 1, result[i][j]);
                    }
                }
            }
        }
        return result;
    }
}
