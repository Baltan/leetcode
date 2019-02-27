package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Transpose Matrix
 *
 * @author Baltan
 * @date 2018/7/30 15:15
 */
public class Transpose {
    public static void main(String[] args) {
        int[][] A1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        OutputUtils.print2DIntegerArray(transpose(A1));

        int[][] A2 = {{1, 2, 3}, {4, 5, 6}};
        OutputUtils.print2DIntegerArray(transpose(A2));
    }

    public static int[][] transpose(int[][] A) {
        if (A == null) {
            return null;
        }

        int[][] AA = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                AA[j][i] = A[i][j];
            }
        }
        return AA;
    }
}
