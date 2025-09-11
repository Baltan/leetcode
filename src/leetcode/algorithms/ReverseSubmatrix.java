package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3643. Flip Square Submatrix Vertically
 *
 * @author baltan
 * @date 2025/9/8 16:27
 */
public class ReverseSubmatrix {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(reverseSubmatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 1, 0, 3));
        System.out.println("---------------------------");
        OutputUtils.print2DIntegerArray(reverseSubmatrix(new int[][]{{3, 4, 2, 3}, {2, 3, 4, 2}}, 0, 2, 2));
    }

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        /**
         * 垂直翻转子矩阵时，上下对称两行的行索引值之和
         */
        int rowSum = x + (x + k - 1);

        for (int i = x; i < x + k / 2; i++) {
            for (int j = y; j < y + k; j++) {
                /**
                 * 将grid[i][j]和grid[rowSum-i][j]交换
                 */
                int temp = grid[i][j];
                grid[i][j] = grid[rowSum - i][j];
                grid[rowSum - i][j] = temp;
            }
        }
        return grid;
    }
}
