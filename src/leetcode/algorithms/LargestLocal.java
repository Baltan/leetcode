package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2373. Largest Local Values in a Matrix
 *
 * @author Baltan
 * @date 2023/2/13 20:54
 */
public class LargestLocal {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}}));
        System.out.println("-------------------------------------");
        OutputUtils.print2DIntegerArray(largestLocal(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}));
    }

    public static int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int[][] result = new int[length - 2][length - 2];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = Integer.MIN_VALUE;
                /**
                 * result[i][j]所在的3×3矩阵的左上角格子为grid[i][j]，右下角格子为grid[i+2][j+2]
                 */
                for (int k = i; k <= i + 2; k++) {
                    for (int l = j; l <= j + 2; l++) {
                        result[i][j] = Math.max(result[i][j], grid[k][l]);
                    }
                }
            }
        }
        return result;
    }
}
