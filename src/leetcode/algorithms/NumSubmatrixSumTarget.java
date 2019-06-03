package leetcode.algorithms;

/**
 * Description: 1074. Number of Submatrices That Sum to Target
 *
 * @author Baltan
 * @date 2019-06-03 10:36
 */
public class NumSubmatrixSumTarget {
    public static void main(String[] args) {
        int[][] matrix1 = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(numSubmatrixSumTarget(matrix1, 0));

        int[][] matrix2 = {{1, -1}, {-1, 1}};
        System.out.println(numSubmatrixSumTarget(matrix2, 0));

        int[][] matrix3 = {{1, -1, -1}, {1, 1, -1}, {1, 1, 1}};
        System.out.println(numSubmatrixSumTarget(matrix3, 3));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sumsRows = rows - i;
                int sumsCols = cols - j;
                int[][] sums = new int[sumsRows][sumsCols];

                for (int k = 0; k < sumsRows; k++) {
                    for (int l = 0; l < sumsCols; l++) {
                        int m = l - 1 >= 0 ? sums[k][l - 1] : 0;
                        int n = k - 1 >= 0 ? sums[k - 1][l] : 0;
                        int p = k - 1 >= 0 && l - 1 >= 0 ? sums[k - 1][l - 1] : 0;
                        sums[k][l] = m + n + matrix[i + k][j + l] - p;

                        if (sums[k][l] == target) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
