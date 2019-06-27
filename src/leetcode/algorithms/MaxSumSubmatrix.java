package leetcode.algorithms;

/**
 * Description: 363. Max Sum of Rectangle No Larger Than K
 *
 * @author Baltan
 * @date 2019-06-27 11:07
 */
public class MaxSumSubmatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 0, 1}, {0, -2, 3}};
        System.out.println(maxSumSubmatrix(matrix1, 2));
    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] help1 = new int[rows][cols];

        /**
         * help1保存第i行索引为[0,j]的列的所有数字的和
         */
        for (int i = 0; i < rows; i++) {
            help1[i][0] = matrix[i][0];

            for (int j = 1; j < cols; j++) {
                help1[i][j] = help1[i][j - 1] + matrix[i][j];
            }
        }

        int[][][] help2 = new int[rows][cols][cols];

        /**
         * help2保存第i行索引为[j,l]的列的所有数字的和
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int l = j; l < cols; l++) {
                    if (j == 0) {
                        help2[i][j][l] = help1[i][l];
                    } else {
                        if (j == l) {
                            help2[i][j][l] = matrix[i][j];
                        } else {
                            help2[i][j][l] = help1[i][l] - help1[i][j - 1];
                        }
                    }
                }
            }
        }

        int[][][] help3 = new int[rows][cols][cols];

        /**
         * help3保存索引为[0,i]的行，索引为[j,l]的列的所有数字的和
         */
        for (int j = 0; j < cols; j++) {
            for (int l = j; l < cols; l++) {
                help3[0][j][l] = help2[0][j][l];
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int l = j; l < cols; l++) {
                    help3[i][j][l] = help3[i - 1][j][l] + help2[i][j][l];
                }
            }
        }

        /**
         * 索引为[i,j]的行并且索引为[l,m]的列的所有数字的和
         */
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                for (int l = 0; l < cols; l++) {
                    for (int m = l; m < cols; m++) {
                        if (i == 0) {
                            if (help3[j][l][m] <= k) {
                                result = Math.max(result, help3[j][l][m]);
                            }
                        } else {
                            int sum = help3[j][l][m] - help3[i - 1][l][m];

                            if (sum <= k) {
                                result = Math.max(result, sum);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
