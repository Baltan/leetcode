package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3537. Fill a Special Grid
 *
 * @author Baltan
 * @date 2025/5/18 14:26
 */
public class SpecialGrid {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(specialGrid(0));
        System.out.println("----------------------------");
        OutputUtils.print2DIntegerArray(specialGrid(1));
        System.out.println("----------------------------");
        OutputUtils.print2DIntegerArray(specialGrid(2));
    }

    public static int[][] specialGrid(int n) {
        return help(0, (1 << n) * (1 << n) - 1, 1 << n);
    }

    /**
     * 利用元素[min,max]构建一个边长为length的特殊网格
     *
     * @param min
     * @param max
     * @param length
     * @return
     */
    public static int[][] help(int min, int max, int length) {
        if (length == 1) {
            return new int[][]{{min}};
        }
        /**
         * 每个象限中单元格的数量
         */
        int count = (max - min + 1) / 4;
        int[][] grid = new int[length][length];
        /**
         * 右上象限的特殊网格
         */
        int[][] rightTop = help(min, min + count - 1, length / 2);
        /**
         * 右下象限的特殊网格
         */
        int[][] rightBottom = help(min + count, min + 2 * count - 1, length / 2);
        /**
         * 左下象限的特殊网格
         */
        int[][] leftBottom = help(min + 2 * count, min + 3 * count - 1, length / 2);
        /**
         * 左上象限的特殊网格
         */
        int[][] leftTop = help(min + 3 * count, min + 4 * count - 1, length / 2);

        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length / 2; j++) {
                grid[i][j + length / 2] = rightTop[i][j];
                grid[i + length / 2][j + length / 2] = rightBottom[i][j];
                grid[i + length / 2][j] = leftBottom[i][j];
                grid[i][j] = leftTop[i][j];
            }
        }
        return grid;
    }
}
