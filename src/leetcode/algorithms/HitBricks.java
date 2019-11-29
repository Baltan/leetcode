package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 803. Bricks Falling When Hit
 *
 * @author Baltan
 * @date 2019-11-29 09:19
 */
public class HitBricks {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 0, 0, 0}, {1, 1, 1, 0}};
        int[][] hits1 = {{1, 0}};
        OutputUtils.print1DIntegerArray(hitBricks(grid1, hits1));

        int[][] grid2 = {{1, 0, 0, 0}, {1, 1, 0, 0}};
        int[][] hits2 = {{1, 1}, {1, 0}};
        OutputUtils.print1DIntegerArray(hitBricks(grid2, hits2));

        int[][] grid3 = {{1, 0, 1}, {1, 1, 1}};
        int[][] hits3 = {{0, 0}, {0, 2}, {1, 1}};
        OutputUtils.print1DIntegerArray(hitBricks(grid3, hits3));
    }

    /**
     * 参考:
     * <a href="https://leetcode-cn.com/problems/bricks-falling-when-hit/solution/ni-xiang-si-wei-fa-by-he-style/"></a>
     *
     * @param grid
     * @param hits
     * @return
     */
    public static int[] hitBricks(int[][] grid, int[][] hits) {
        int length = hits.length;
        int[] result = new int[length];
        int cols = grid[0].length;
        /**
         * 所有当前没有掉落的砖块
         */
        Set<Point> notDroppedBricks = new HashSet<>();
        /**
         * 标记所有被敲击的砖块，每敲击一次就将砖块的值减1
         */
        excludeHitBricks(grid, hits);
        /**
         * 所有敲击完成之后，查找所有剩余的没有掉落的砖块，这些砖块直接或间接地和顶部相连
         */
        for (int i = 0; i < cols; i++) {
            getNotDroppedBricks(grid, 0, i, notDroppedBricks);
        }
        /**
         * 逆序恢复被敲击的砖块
         */
        for (int i = length - 1; i >= 0; i--) {
            int[] hitPosition = hits[i];
            int x = hitPosition[0];
            int y = hitPosition[1];
            /**
             * 因为之前每次敲击都对砖块的值进行了减1操作，现在恢复过程中，每次敲击对砖块的值进行加1操作
             */
            grid[x][y]++;
            /**
             * 如果砖块的值为1，说明在这次敲击后，这块砖块的消除了，有可能造成其他砖块的掉落
             */
            if (grid[x][y] == 1) {
                /**
                 * 这次敲击之后剩余的没有掉落的砖块数
                 */
                int notDroppedBricksCount = notDroppedBricks.size();
                /**
                 * 如果这块砖和顶部或和没有掉落的砖块相连，则可能有一些砖因为这块砖的消除而掉落，
                 * 补上这块砖后查找所有不会掉落的砖块添加到集合notDroppedBricks中
                 */
                if (x == 0 || notDroppedBricks.contains(new Point(x - 1, y)) ||
                        notDroppedBricks.contains(new Point(x + 1, y)) ||
                        notDroppedBricks.contains(new Point(x, y - 1)) ||
                        notDroppedBricks.contains(new Point(x, y + 1))) {
                    /**
                     * 查找所有不会掉落的砖块添加到集合notDroppedBricks中
                     */
                    getNotDroppedBricks(grid, x, y, notDroppedBricks);
                    /**
                     * 补上这块砖后不会掉落的砖块数和敲击之后剩余的没有掉落的砖块数之差，再排除
                     * 这块被敲击的砖，就是这次敲击导致掉落的砖块数
                     */
                    result[i] = notDroppedBricks.size() - notDroppedBricksCount - 1;
                }
            }
        }
        return result;
    }

    /**
     * 标记所有被敲击的砖块，每敲击一次就将砖块的值减1
     *
     * @param grid
     * @param hits
     */
    public static void excludeHitBricks(int[][] grid, int[][] hits) {
        int length = hits.length;

        for (int i = 0; i < length; i++) {
            int[] hitPosition = hits[i];
            int x = hitPosition[0];
            int y = hitPosition[1];
            grid[x][y]--;
        }
    }

    /**
     * 查找所有没有掉落的砖块，这些砖块直接或间接地和顶部相连
     *
     * @param grid
     * @param startX
     * @param startY
     * @param notDroppedBricks
     */
    public static void getNotDroppedBricks(int[][] grid, int startX, int startY,
                                           Set<Point> notDroppedBricks) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (startX < 0 || startX >= rows || startY < 0 || startY >= cols || grid[startX][startY] != 1 ||
                notDroppedBricks.contains(new Point(startX, startY))) {
            return;
        }
        /**
         * 将没有掉落的砖块添加到集合notDroppedBricks中
         */
        notDroppedBricks.add(new Point(startX, startY));
        /**
         * 递归判断当前砖块上下左右的砖块
         */
        getNotDroppedBricks(grid, startX - 1, startY, notDroppedBricks);
        getNotDroppedBricks(grid, startX + 1, startY, notDroppedBricks);
        getNotDroppedBricks(grid, startX, startY - 1, notDroppedBricks);
        getNotDroppedBricks(grid, startX, startY + 1, notDroppedBricks);
    }
}
