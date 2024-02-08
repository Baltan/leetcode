package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3030. Find the Grid of Region Average
 *
 * @author Baltan
 * @date 2024/2/7 23:34
 */
public class ResultGrid {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(resultGrid(new int[][]{{5, 6, 7, 10}, {8, 9, 10, 10}, {11, 12, 13, 10}}, 3));
        System.out.println("-----------------------------------------------------");
        OutputUtils.print2DIntegerArray(resultGrid(new int[][]{{10, 20, 30}, {15, 25, 35}, {20, 30, 40}, {25, 35, 45}}, 12));
        System.out.println("-----------------------------------------------------");
        OutputUtils.print2DIntegerArray(resultGrid(new int[][]{{5, 6, 7}, {8, 9, 10}, {11, 12, 13}}, 1));
    }

    public static int[][] resultGrid(int[][] image, int threshold) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[rows][cols];
        /**
         * regionSums[i][j]表示以image[i][j]为左上角格子的3×3子网格中所有元素的和
         */
        int[][] regionSums = new int[rows][cols];
        /**
         * isRegion[i][j]表示以image[i][j]为左上角格子的3×3子网格是否是一个区域
         */
        boolean[][] isRegion = new boolean[rows][cols];

        for (int i = 0; i < rows - 2; i++) {
            loop:
            for (int j = 0; j < cols - 2; j++) {
                /**
                 * 以image[i][j]为左上角格子的3×3子网格的最底下一行的行索引
                 */
                int bottommost = i + 2;
                /**
                 * 以image[i][j]为左上角格子的3×3子网格的最右边一列的列索引
                 */
                int rightmost = j + 2;

                for (int k = i; k <= bottommost; k++) {
                    for (int l = j; l <= rightmost; l++) {
                        /**
                         * 上下相邻的两个格子中元素的绝对差大于threshold，说明以image[i][j]为左上角格子的3×3子网格不是一个区域
                         */
                        if (k + 1 <= bottommost && Math.abs(image[k][l] - image[k + 1][l]) > threshold) {
                            continue loop;
                        }
                        /**
                         * 左右相邻的两个格子中元素的绝对差大于threshold，说明以image[i][j]为左上角格子的3×3子网格不是一个区域
                         */
                        if (l + 1 <= rightmost && Math.abs(image[k][l] - image[k][l + 1]) > threshold) {
                            continue loop;
                        }
                        regionSums[i][j] += image[k][l];
                    }
                }
                /**
                 * 以image[i][j]为左上角格子的3×3子网格是一个区域
                 */
                isRegion[i][j] = true;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 包含格子image[i][j]的区域的个数
                 */
                int count = 0;
                /**
                 * 包含格子image[i][j]的所有区域的平均值之和
                 */
                int sum = 0;
                /**
                 * 格子image[i][j]可能出现在一个3×3子网格的任何位置，共9种情况，image[k][l]即为当前3×3子网格的左上角格子
                 */
                for (int k = i - 2; k <= i; k++) {
                    for (int l = j - 2; l <= j; l++) {
                        if (k >= 0 && l >= 0 && isRegion[k][l]) {
                            count++;
                            sum += regionSums[k][l] / 9;
                        }
                    }
                }
                result[i][j] = count == 0 ? image[i][j] : sum / count;
            }
        }
        return result;
    }
}
