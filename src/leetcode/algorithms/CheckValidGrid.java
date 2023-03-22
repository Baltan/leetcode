package leetcode.algorithms;

/**
 * Description: 2596. Check Knight Tour Configuration
 *
 * @author Baltan
 * @date 2023/3/19 13:09
 */
public class CheckValidGrid {
    public static void main(String[] args) {
        System.out.println(checkValidGrid(new int[][]{{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}}));
        System.out.println(checkValidGrid(new int[][]{{0, 3, 6}, {5, 8, 1}, {2, 7, 4}}));
    }

    public static boolean checkValidGrid(int[][] grid) {
        /**
         * 骑士从左上角的格子出发，但是这个格子中的数字不为0
         */
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int total = n * n;
        /**
         * rowIndexes[i]表示数字i所在格子的行索引
         */
        int[] rowIndexes = new int[total];
        /**
         * colIndexes[i]表示数字i所在格子的列索引
         */
        int[] colIndexes = new int[total];
        /**
         * 记录矩阵grid中每个数字所在的行索引和列索引
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = grid[i][j];
                rowIndexes[value] = i;
                colIndexes[value] = j;
            }
        }
        /**
         * 判断每个格子能否从前一个格子通过一次有效移动到达
         */
        for (int i = 1; i < total; i++) {
            /**
             * 一次有效移动要不是行索引变化1且列索引变化2，要不是行索引变化2且列索引变化1，所以行索引和列索引变化值的乘积一定是±2
             */
            if (Math.abs((rowIndexes[i] - rowIndexes[i - 1]) * (colIndexes[i] - colIndexes[i - 1])) != 2) {
                return false;
            }
        }
        return true;
    }
}
