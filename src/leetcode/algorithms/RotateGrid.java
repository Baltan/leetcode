package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1914. Cyclically Rotating a Grid
 *
 * @author Baltan
 * @date 2022/3/3 22:14
 */
public class RotateGrid {
    public static void main(String[] args) {
        int[][] grid1 = {{40, 10}, {30, 20}};
        OutputUtils.print2DIntegerArray(rotateGrid(grid1, 1));

        System.out.println("------------------------------------------");

        int[][] grid2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        OutputUtils.print2DIntegerArray(rotateGrid(grid2, 2));

        System.out.println("------------------------------------------");

        int[][] grid3 = {{3970, 1906, 3608, 298, 3072, 3546, 1502, 773, 4388, 3115, 747, 3937},
                {2822, 304, 4179, 1780, 1709, 1058, 3645, 681, 2910, 2513, 4357, 1038},
                {4471, 2443, 218, 550, 2766, 4780, 1997, 1672, 4095, 161, 4645, 3838},
                {2035, 2350, 3653, 4127, 3208, 4717, 4347, 3452, 1601, 3725, 3060, 2270},
                {188, 2278, 81, 3454, 3204, 1897, 2862, 4381, 3704, 2587, 743, 3832},
                {996, 4499, 66, 2742, 1761, 1189, 608, 509, 2344, 3271, 3076, 108},
                {3274, 2042, 2157, 3226, 2938, 3766, 2610, 4510, 219, 1276, 3712, 4143},
                {744, 234, 2159, 4478, 4161, 4549, 4214, 4272, 701, 4376, 3110, 4896},
                {4431, 1011, 757, 2690, 83, 3546, 946, 1122, 2216, 3944, 2715, 2842},
                {898, 4087, 703, 4153, 3297, 2968, 3268, 4717, 1922, 2527, 3139, 1516},
                {1086, 1090, 302, 1273, 2292, 234, 3268, 2284, 4203, 3838, 2227, 3651},
                {2055, 4406, 2278, 3351, 3217, 2506, 4525, 233, 3829, 63, 4470, 3170},
                {3797, 3276, 1755, 1727, 1131, 4108, 3633, 1835, 1345, 1293, 2778, 2805},
                {1215, 84, 282, 2721, 2360, 2321, 1435, 2617, 1202, 2876, 3420, 3034}};
        OutputUtils.print2DIntegerArray(rotateGrid(grid3, 405548684));
    }

    public static int[][] rotateGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows][cols];
        /**
         * 从外向内的层数
         */
        for (int i = 0; ; i++) {
            /**
             * 该层垂直方向上的边长
             */
            int row = rows - 2 * i;
            /**
             * 该层水平方向上的边长
             */
            int col = cols - 2 * i;
            /**
             * 该层周长，四个角上的数字各被重复计算了一次，要减去
             */
            int perimeter = (row + col) * 2 - 4;
            /**
             * 该层实际移动的步数
             */
            int steps = k % perimeter;
            /**
             * 该层最大的行索引
             */
            int maxX = i + row - 1;
            /**
             * 该层最大的列索引
             */
            int maxY = i + col - 1;
            /**
             * 该层最小的行索引
             */
            int minX = i;
            /**
             * 该层最小的列索引
             */
            int minY = i;
            /**
             * 逆时针旋转
             */
            rotate(result, grid, steps, minX, minY, maxX, maxY);
            /**
             * 如果该层垂直方向上的边长或水平方向上的边上有任意一个为2，说明该层已是最内层
             */
            if (row == 2 || col == 2) {
                break;
            }
        }
        return result;
    }

    /**
     * 逆时针旋转
     *
     * @param result
     * @param grid
     * @param step
     * @param minX
     * @param minY
     * @param maxX
     * @param maxY
     */
    public static void rotate(int[][] result, int[][] grid, int step, int minX, int minY, int maxX,
                              int maxY) {
        /**
         * 该层左边数字（除最下面一个）开始向下方移动
         */
        for (int i = minX; i < maxX; i++) {
            move(result, grid, step, maxX, maxY, minX, minY, i, minY, 'D');
        }
        /**
         * 该层下边数字（除最右边一个）开始向右方移动
         */
        for (int i = minY; i < maxY; i++) {
            move(result, grid, step, maxX, maxY, minX, minY, maxX, i, 'R');
        }
        /**
         * 该层右边数字（除最上面一个）开始向下上移动
         */
        for (int i = maxX; i > minX; i--) {
            move(result, grid, step, maxX, maxY, minX, minY, i, maxY, 'U');
        }
        /**
         * 该层上边数字（除最左边一个）开始向左方移动
         */
        for (int i = maxY; i > minY; i--) {
            move(result, grid, step, maxX, maxY, minX, minY, minX, i, 'L');
        }
    }

    /**
     * 逐步移动
     *
     * @param result
     * @param grid
     * @param step
     * @param maxX
     * @param maxY
     * @param minX
     * @param minY
     * @param currentX
     * @param currentY
     * @param direction
     */
    public static void move(int[][] result, int[][] grid, int step, int maxX, int maxY, int minX, int minY,
                            int currentX, int currentY, char direction) {
        int value = grid[currentX][currentY];

        while (step > 0) {
            if (direction == 'D') {
                /**
                 * 可以向下移动的最大步数
                 */
                int moves = Math.min(step, maxX - currentX);
                currentX += moves;
                /**
                 * 接下去向右移动
                 */
                direction = 'R';
                step -= moves;
            } else if (direction == 'R') {
                /**
                 * 可以向右移动的最大步数
                 */
                int moves = Math.min(step, maxY - currentY);
                currentY += moves;
                /**
                 * 接下去向上移动
                 */
                direction = 'U';
                step -= moves;
            } else if (direction == 'U') {
                /**
                 * 可以向上移动的最大步数
                 */
                int moves = Math.min(step, currentX - minX);
                currentX -= moves;
                /**
                 * 接下去向左移动
                 */
                direction = 'L';
                step -= moves;
            } else if (direction == 'L') {
                /**
                 * 可以向左移动的最大步数
                 */
                int moves = Math.min(step, currentY - minY);
                currentY -= moves;
                /**
                 * 接下去向下移动
                 */
                direction = 'D';
                step -= moves;
            }
        }
        result[currentX][currentY] = value;
    }
}
