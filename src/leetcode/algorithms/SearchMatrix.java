package leetcode.algorithms;

/**
 * Description: 74. Search a 2D Matrix
 *
 * @author Baltan
 * @date 2018/9/25 17:07
 * @see SearchMatrix1
 * @see leetcode.interview.SearchMatrix
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix1, 3));
        System.out.println(searchMatrix(matrix1, 13));
        System.out.println(searchMatrix(matrix1, 10));
        System.out.println(searchMatrix(matrix1, 19));
        System.out.println(searchMatrix(matrix1, 44));

        int[][] matrix2 = {{1}};
        System.out.println(searchMatrix(matrix2, 0));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int length = matrix.length;
        int width = matrix[0].length;
        int start = 0;
        int end = length - 1;
        int position;
        /**
         * 二分查找target在哪一行中，最后的end即为target可能在的行数
         */
        while (start <= end) {
            position = (start + end) / 2;

            if (matrix[position][0] == target) {
                return true;
            } else if (matrix[position][0] > target) {
                end = position - 1;
            } else {
                start = position + 1;
            }
        }
        position = end;
        /**
         * 如果矩阵的第一个数都大于target，显然target不存在矩阵中
         */
        if (position < 0) {
            return false;
        }

        start = 0;
        end = width - 1;
        /**
         * 二分查找在索引为position的行中是否存在target这个数
         */
        while (start <= end) {
            int position1 = (start + end) / 2;

            if (matrix[position][position1] == target) {
                return true;
            } else if (matrix[position][position1] > target) {
                end = position1 - 1;
            } else {
                start = position1 + 1;
            }
        }
        return false;
    }
}
