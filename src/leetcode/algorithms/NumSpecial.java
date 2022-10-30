package leetcode.algorithms;

/**
 * Description: 1582. Special Positions in a Binary Matrix
 *
 * @author Baltan
 * @date 2022/10/21 20:32
 */
public class NumSpecial {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(numSpecial(mat1));

        int[][] mat2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(numSpecial(mat2));

        int[][] mat3 = {{0, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(numSpecial(mat3));

        int[][] mat4 = {{0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(numSpecial(mat4));
    }

    public static int numSpecial(int[][] mat) {
        int result = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        /**
         * rowSums[i]表示矩阵mat的第i行的所有元素的和
         */
        int[] rowSums = new int[rows];
        /**
         * colSums[i]表示矩阵mat的第i列的所有元素的和
         */
        int[] colSums = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowSums[i] += mat[i][j];
                colSums[j] += mat[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && rowSums[i] == 1 && colSums[j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
