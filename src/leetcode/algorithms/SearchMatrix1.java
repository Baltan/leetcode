package leetcode.algorithms;

/**
 * Description: 240. Search a 2D Matrix II
 *
 * @author Baltan
 * @date 2019-06-09 13:39
 * @see SearchMatrix
 * @see leetcode.interview.Search
 */
public class SearchMatrix1 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix1, 5));
        System.out.println(searchMatrix(matrix1, 20));
        System.out.println(searchMatrix(matrix1, 17));
        System.out.println(searchMatrix(matrix1, 22));
        System.out.println(searchMatrix(matrix1, 25));
        System.out.println(searchMatrix(matrix1, 1));
        System.out.println(searchMatrix(matrix1, 15));
    }

    /**
     * 参考
     * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/"></a>
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = rows - 1;
        int col = 0;

        while (row >= 0 && col < cols) {
            /**
             * 初始指向矩阵左下角的数字
             */
            int current = matrix[row][col];

            if (current == target) {
                return true;
            } else if (current < target) {
                /**
                 * 如果当前指向的数字小于target，因为当前数字的左上方的数字都更小，所以target可能在当前
                 * 数字右方
                 */
                col++;
            } else {
                /**
                 * 如果当前指向的数字大于target，因为当前数字的右下方的数字都更大，所以target可能在当前
                 * 数字上方
                 */
                row--;
            }
        }
        return false;
    }
}
