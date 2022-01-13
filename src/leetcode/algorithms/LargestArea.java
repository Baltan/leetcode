package leetcode.algorithms;

/**
 * Description: LCS 03. 主题空间
 *
 * @author Baltan
 * @date 2022/1/13 13:55
 */
public class LargestArea {
    public static void main(String[] args) {
        System.out.println(largestArea(
                new String[]{"034242512", "324055343", "222153500", "422420552", "322435544", "325215455",
                        "243352525", "343113415"}));
        System.out.println(largestArea(
                new String[]{"113415514", "124112542", "313225220", "253354005", "352014331", "304514425",
                        "553313413", "532352143", "220340311", "245210141"}));
        System.out.println(largestArea(
                new String[]{"2545552502", "5154301454", "1331554113", "3211125150", "5311515515",
                        "2324502045", "2551325553", "2434242405"}));
        System.out.println(largestArea(new String[]{"110", "231", "221"}));
        System.out.println(
                largestArea(new String[]{"11111100000", "21243101111", "21224101221", "11111101111"}));
    }

    private static int result = 0;
    /**
     * 当前主题空间的面积大小
     */
    private static int currArea = 0;
    /**
     * 标记当前主题空间是否连接走廊
     */
    private static boolean flag = false;

    public static int largestArea(String[] grid) {
        /**
         * 因为是静态变量，对于不同的测试用例先初始化结果值
         */
        result = 0;
        int rows = grid.length;
        int cols = grid[0].length();
        /**
         * isVisited[x][y]标记grid[x][y]是否已经被判断计算过
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 上下左右四个移动方向
         */
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 初始化当前要计算的主题空间的面积
                 */
                currArea = 0;
                /**
                 * 初始化当前主题空间不与走廊连接
                 */
                flag = false;
                mark(grid, isVisited, directions, grid[i].charAt(j), i, j, rows, cols);

                if (!flag) {
                    result = Math.max(result, currArea);
                }
            }
        }
        return result;
    }

    /**
     * 标记相邻的同样主题的空间
     *
     * @param grid
     * @param isVisited
     * @param directions
     * @param topic
     * @param x
     * @param y
     * @param rows
     * @param cols
     */
    public static void mark(String[] grid, boolean[][] isVisited, int[][] directions, char topic, int x,
                            int y, int rows, int cols) {
        /**
         * 标记当前主题空间与走廊连接
         */
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x].charAt(y) == '0') {
            flag = true;
            return;
        }
        /**
         * 如果当前空间与正在计算的主题空间不同主题，结束递归
         */
        if (isVisited[x][y] || grid[x].charAt(y) != topic) {
            return;
        }

        isVisited[x][y] = true;
        /**
         * 累计当前主题空间的面积
         */
        currArea++;
        /**
         * 在四个方向上递归计算当前主题空间的面积
         */
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            mark(grid, isVisited, directions, topic, newX, newY, rows, cols);
        }
    }
}
