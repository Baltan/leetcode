package leetcode.algorithms;

/**
 * Description: 2133. Check if Every Row and Column Contains All Numbers
 *
 * @author Baltan
 * @date 2022/1/10 21:53
 */
public class CheckValid {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
        System.out.println(checkValid(matrix1));

        int[][] matrix2 = {{1, 1, 1}, {1, 2, 3}, {1, 2, 3}};
        System.out.println(checkValid(matrix2));
    }

    public static boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            /**
             * rowFlags[x]标记第i行中数字x+1已出现过
             */
            boolean[] rowFlags = new boolean[n];
            /**
             * colFlags[x]标记第i列中数字x+1已出现过
             */
            boolean[] colFlags = new boolean[n];

            for (int j = 0; j < n; j++) {
                int rowNum = matrix[i][j];
                int colNum = matrix[j][i];
                /**
                 * 如果该行出现[1,n]范围之外的数或者该行之前已出现过的数，则不是一个有效的矩阵
                 */
                if (rowNum < 1 || rowNum > n || rowFlags[rowNum - 1]) {
                    return false;
                }
                /**
                 * 如果该列出现[1,n]范围之外的数或者该列之前已出现过的数，则不是一个有效的矩阵
                 */
                if (colNum < 1 || colNum > n || colFlags[colNum - 1]) {
                    return false;
                }
                /**
                 * 标记该行中数字rowNum已出现过
                 */
                rowFlags[rowNum - 1] = true;
                /**
                 * 标记该列中数字colNum已出现过
                 */
                colFlags[colNum - 1] = true;
            }
        }
        return true;
    }
}
