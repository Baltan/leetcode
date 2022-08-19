package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1706. Where Will the Ball Fall
 *
 * @author Baltan
 * @date 2022/8/18 09:06
 */
public class FindBall {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}};
        OutputUtils.print1DIntegerArray(findBall(grid1));

        int[][] grid2 = {{-1}};
        OutputUtils.print1DIntegerArray(findBall(grid2));

        int[][] grid3 =
                {{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};
        OutputUtils.print1DIntegerArray(findBall(grid3));

        int[][] grid4 =
                {{1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1,
                        1, -1, -1, -1, -1, 1, -1, 1, 1, -1, -1, -1, -1, -1, 1},
                        {-1, 1, 1, 1, -1, -1, -1, -1, 1, 1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, 1, 1, -1, 1,
                                -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, 1, -1, 1, 1},
                        {1, -1, -1, -1, -1, 1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1, -1,
                                1, -1, 1, -1, -1, 1, -1, 1, -1, 1, 1, -1, -1, 1, 1, -1, 1, -1}};
        OutputUtils.print1DIntegerArray(findBall(grid4));
    }

    public static int[] findBall(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] result = new int[cols];

        outer:
        for (int i = 0; i < cols; i++) {
            /**
             * 小球当前所在的列
             */
            int currCol = i;

            for (int j = 0; j < rows; j++) {
                /**
                 * 有以下四种情况小球会被卡住，依次为：
                 * 1、小球在最左边列，单元格挡板跨过右上角和左下角
                 * 2、小球在最右边列，单元格挡板跨过左上角和右下角
                 * 3、小球在非最右边列，单元格挡板跨过左上角和右下角，并且右边单元格挡板跨过右上角和左下角
                 * 4、小球在非最左边列，单元格挡板跨过右上角和左下角，并且左边单元格挡板跨过左上角和右下角
                 */
                boolean getStuck = (currCol == 0 && grid[j][currCol] == -1) ||
                        (currCol == cols - 1 && grid[j][currCol] == 1) ||
                        (currCol < cols - 1 && grid[j][currCol] == 1 && grid[j][currCol + 1] == -1) ||
                        (currCol > 0 && grid[j][currCol] == -1 && grid[j][currCol - 1] == 1);

                if (getStuck) {
                    result[i] = -1;
                    continue outer;
                } else {
                    /**
                     * 如果当前单元格挡板跨过右上角和左下角，将小球导向左边列，否则将小球导向右边列
                     */
                    currCol = grid[j][currCol] == 1 ? currCol + 1 : currCol - 1;
                }
            }
            result[i] = currCol;
        }
        return result;
    }
}
