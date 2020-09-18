package leetcode.algorithms;

/**
 * Description: 1572. Matrix Diagonal Sum
 *
 * @author Baltan
 * @date 2020-09-18 17:25
 */
public class DiagonalSum {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(diagonalSum(mat1));

        int[][] mat2 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        System.out.println(diagonalSum(mat2));

        int[][] mat3 = {{5}};
        System.out.println(diagonalSum(mat3));
    }

    public static int diagonalSum(int[][] mat) {
        int result = 0;
        int length = mat.length;

        for (int i = 0; i < length; i++) {
            /**
             * 主对角线上的值
             */
            result += mat[i][i];
            /**
             * 副对角线上的值
             */
            result += mat[i][length - 1 - i];
        }
        /**
         * 如果矩阵是奇数阶的，则正中间的值既在主对角线上，又在副对角线上，被重复多算了一次，需要减去
         */
        if (length % 2 == 1) {
            result -= mat[length / 2][length / 2];
        }
        return result;
    }
}
