package leetcode.algorithms;

/**
 * Description: Minimum Falling Path Sum
 *
 * @author Baltan
 * @date 2019-04-26 14:37
 */
public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] A1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minFallingPathSum(A1));
    }

    public static int minFallingPathSum(int[][] A) {
        int result = Integer.MAX_VALUE;
        int rows = A.length;
        int cols = A[0].length;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    A[i][j] = Math.min(A[i - 1][j], A[i - 1][j + 1]) + A[i][j];
                } else if (j == cols - 1) {
                    A[i][j] = Math.min(A[i - 1][j], A[i - 1][j - 1]) + A[i][j];
                } else {
                    A[i][j] = Math.min(A[i - 1][j], Math.min(A[i - 1][j - 1], A[i - 1][j + 1])) + A[i][j];
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            result = Math.min(result, A[rows - 1][i]);
        }
        return result;
    }
}
