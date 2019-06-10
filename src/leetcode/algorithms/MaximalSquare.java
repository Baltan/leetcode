package leetcode.algorithms;

/**
 * Description: 221. Maximal Square
 *
 * @author Baltan
 * @date 2019-06-10 12:35
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix1 = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix1));

        char[][] matrix2 = {{'0', '1'}, {'1', '1'}};
        System.out.println(maximalSquare(matrix2));
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int maxLength = Math.min(rows - i, cols - j);

                    for (int k = 1; k <= maxLength; k++) {
                        if (isSqure(matrix, i, j, k)) {
                            max = Math.max(max, k);
                        }
                    }
                }
            }
        }
        return max * max;
    }

    public static boolean isSqure(char[][] matrix, int x, int y, int length) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (matrix[i][j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
