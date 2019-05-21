package leetcode.algorithms;

/**
 * Description: 861. Score After Flipping Matrix
 *
 * @author Baltan
 * @date 2018/8/11 14:06
 */
public class MatrixScore {
    public static void main(String[] args) {
        int[][] A1 = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrixScore(A1));

        int[][] A3 = {{1}};
        System.out.println(matrixScore(A3));
    }

    public static int matrixScore(int[][] A) {
        if (A == null) {
            return 0;
        }

        int rows = A.length;
        int cols = A[0].length;
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            if (A[i][0] != 1) {
                for (int j = 0; j < cols; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        sum += rows * Math.pow(2, cols - 1);

        for (int i = 1; i < cols; i++) {
            int colSum = 0;
            for (int j = 0; j < rows; j++) {
                colSum += A[j][i];
            }
            if (colSum < rows - colSum) {
                sum += (rows - colSum) * Math.pow(2, cols - 1 - i);
            } else {
                sum += colSum * Math.pow(2, cols - 1 - i);
            }
        }
        return sum;
    }
}
