package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2022. Convert 1D Array Into 2D Array
 *
 * @author Baltan
 * @date 2021/10/7 18:42
 */
public class Construct2DArray {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2, 3, 4}, 2, 2)));
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2, 3}, 1, 3)));
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 2}, 1, 1)));
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{3}, 1, 2)));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }

        int[][] result = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[row][col] = original[row * n + col];
            }
        }
        return result;
    }
}
