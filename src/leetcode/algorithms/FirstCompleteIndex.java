package leetcode.algorithms;

/**
 * Description: 2661. First Completely Painted Row or Column
 *
 * @author Baltan
 * @date 2023/5/1 12:06
 */
public class FirstCompleteIndex {
    public static void main(String[] args) {
        System.out.println(firstCompleteIndex(new int[]{1, 3, 4, 2}, new int[][]{{1, 4}, {2, 3}}));
        System.out.println(firstCompleteIndex(new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9}, new int[][]{{3, 2, 5}, {1, 4, 6}, {8, 7, 9}}));
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        /**
         * coordinates[i]表示数字i+1在矩阵mat中的坐标
         */
        int[][] coordinates = new int[arr.length][2];
        /**
         * rowPainted[i]表示矩阵mat的第i行已被涂色的方格数
         */
        int[] rowPainted = new int[rows];
        /**
         * colPainted[i]表示矩阵mat的第i列已被涂色的方格数
         */
        int[] colPainted = new int[cols];
        /**
         * 记录矩阵mat中每个数字的坐标
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                coordinates[mat[i][j] - 1] = new int[]{i, j};
            }
        }

        for (int i = 0; i < arr.length; i++) {
            /**
             * 数字arr[i]在矩阵mat中的左边
             */
            int[] coordinate = coordinates[arr[i] - 1];
            rowPainted[coordinate[0]]++;
            colPainted[coordinate[1]]++;
            /**
             * 矩阵第coordinate[0]行或第coordinate[1]列已被完全涂色
             */
            if (rowPainted[coordinate[0]] == cols || colPainted[coordinate[1]] == rows) {
                return i;
            }
        }
        return -1;
    }
}
