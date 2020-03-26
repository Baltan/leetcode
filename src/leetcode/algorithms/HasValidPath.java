package leetcode.algorithms;

/**
 * Description: 1391. Check if There is a Valid Path in a Grid
 *
 * @author Baltan
 * @date 2020-03-26 00:13
 */
public class HasValidPath {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 4, 3}, {6, 5, 2}};
        System.out.println(hasValidPath(grid1));

        int[][] grid2 = {{1, 2, 1}, {1, 2, 1}};
        System.out.println(hasValidPath(grid2));

        int[][] grid3 = {{1, 1, 2}};
        System.out.println(hasValidPath(grid3));

        int[][] grid4 = {{1, 1, 1, 1, 1, 1, 3}};
        System.out.println(hasValidPath(grid4));

        int[][] grid5 = {{2}, {2}, {2}, {2}, {2}, {2}, {6}};
        System.out.println(hasValidPath(grid5));

        int[][] grid6 = {{4, 1}, {6, 1}};
        System.out.println(hasValidPath(grid6));
    }

    public static boolean hasValidPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * isVisited[i][j]表示grid[i][j]是否路过过
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 当前所在位置
         */
        int[] currentPosition = {0, 0};

        while (true) {
            int x = currentPosition[0];
            int y = currentPosition[1];
            /**
             * 如果当前所在位置为grid右下角，返回true
             */
            if (x == rows - 1 && y == cols - 1) {
                return true;
            }
            /**
             * 标记grid[x][y]已经访问过了，后面不会再到这个位置
             */
            isVisited[x][y] = true;
            int value = grid[x][y];

            if (value == 1) {
                /**
                 * 向左走
                 */
                int x1 = x;
                int y1 = y - 1;
                /**
                 * 向右走
                 */
                int x2 = x;
                int y2 = y + 1;
                /**
                 * 向左走只有街道1、4、6可以相接
                 */
                if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && !isVisited[x1][y1] &&
                        (grid[x1][y1] == 1 || grid[x1][y1] == 4 || grid[x1][y1] == 6)) {
                    currentPosition = new int[]{x1, y1};
                }
                /**
                 * 向右走只有街道1、3、5可以相接
                 */
                if (x2 >= 0 && x2 < rows && y2 >= 0 && y2 < cols && !isVisited[x2][y2] &&
                        (grid[x2][y2] == 1 || grid[x2][y2] == 3 || grid[x2][y2] == 4)) {
                    currentPosition = new int[]{x2, y2};
                }
            } else if (value == 2) {
                /**
                 * 向上走
                 */
                int x1 = x - 1;
                int y1 = y;
                /**
                 * 向下走
                 */
                int x2 = x + 1;
                int y2 = y;
                /**
                 * 向上走只有街道2、3、4可以相接
                 */
                if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && !isVisited[x1][y1] &&
                        (grid[x1][y1] == 2 || grid[x1][y1] == 3 || grid[x1][y1] == 4)) {
                    currentPosition = new int[]{x1, y1};
                }
                /**
                 * 向下走只有街道2、5、6可以相接
                 */
                if (x2 >= 0 && x2 < rows && y2 >= 0 && y2 < cols && !isVisited[x2][y2] &&
                        (grid[x2][y2] == 2 || grid[x2][y2] == 5 || grid[x2][y2] == 6)) {
                    currentPosition = new int[]{x2, y2};
                }
            } else if (value == 3) {
                /**
                 * 向左走
                 */
                int x1 = x;
                int y1 = y - 1;
                /**
                 * 向下走
                 */
                int x2 = x + 1;
                int y2 = y;
                /**
                 * 向左走只有街道1、4、6可以相接
                 */
                if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && !isVisited[x1][y1] &&
                        (grid[x1][y1] == 1 || grid[x1][y1] == 4 || grid[x1][y1] == 6)) {
                    currentPosition = new int[]{x1, y1};
                }
                /**
                 * 向下走只有街道2、5、6可以相接
                 */
                if (x2 >= 0 && x2 < rows && y2 >= 0 && y2 < cols && !isVisited[x2][y2] &&
                        (grid[x2][y2] == 2 || grid[x2][y2] == 5 || grid[x2][y2] == 6)) {
                    currentPosition = new int[]{x2, y2};
                }
            } else if (value == 4) {
                /**
                 * 向右走
                 */
                int x1 = x;
                int y1 = y + 1;
                /**
                 * 向下走
                 */
                int x2 = x + 1;
                int y2 = y;
                /**
                 * 向右走只有街道1、3、5可以相接
                 */
                if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && !isVisited[x1][y1] &&
                        (grid[x1][y1] == 1 || grid[x1][y1] == 3 || grid[x1][y1] == 5)) {
                    currentPosition = new int[]{x1, y1};
                }
                /**
                 * 向下走只有街道2、5、6可以相接
                 */
                if (x2 >= 0 && x2 < rows && y2 >= 0 && y2 < cols && !isVisited[x2][y2] &&
                        (grid[x2][y2] == 2 || grid[x2][y2] == 5 || grid[x2][y2] == 6)) {
                    currentPosition = new int[]{x2, y2};
                }
            } else if (value == 5) {
                /**
                 * 向左走
                 */
                int x1 = x;
                int y1 = y - 1;
                /**
                 * 向上走
                 */
                int x2 = x - 1;
                int y2 = y;
                /**
                 * 向左走只有街道1、4、6可以相接
                 */
                if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && !isVisited[x1][y1] &&
                        (grid[x1][y1] == 1 || grid[x1][y1] == 4 || grid[x1][y1] == 6)) {
                    currentPosition = new int[]{x1, y1};
                }
                /**
                 * 向上走只有街道2、3、4可以相接
                 */
                if (x2 >= 0 && x2 < rows && y2 >= 0 && y2 < cols && !isVisited[x2][y2] &&
                        (grid[x2][y2] == 2 || grid[x2][y2] == 3 || grid[x2][y2] == 4)) {
                    currentPosition = new int[]{x2, y2};
                }
            } else if (value == 6) {
                /**
                 * 向右走
                 */
                int x1 = x;
                int y1 = y + 1;
                /**
                 * 向上走
                 */
                int x2 = x - 1;
                int y2 = y;
                /**
                 * 向右走只有街道1、3、5可以相接
                 */
                if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && !isVisited[x1][y1] &&
                        (grid[x1][y1] == 1 || grid[x1][y1] == 3 || grid[x1][y1] == 5)) {
                    currentPosition = new int[]{x1, y1};
                }
                /**
                 * 向上走只有街道2、3、4可以相接
                 */
                if (x2 >= 0 && x2 < rows && y2 >= 0 && y2 < cols && !isVisited[x2][y2] &&
                        (grid[x2][y2] == 2 || grid[x2][y2] == 3 || grid[x2][y2] == 4)) {
                    currentPosition = new int[]{x2, y2};
                }
            }
        }
    }
}
