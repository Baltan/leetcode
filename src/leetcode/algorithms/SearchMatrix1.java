package leetcode.algorithms;

/**
 * Description: 240. Search a 2D Matrix II
 *
 * @author Baltan
 * @date 2019-06-09 13:39
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

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = rows - 1;
        int col = 0;

        while (row >= 0 && col < cols) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            } else if (current < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}
