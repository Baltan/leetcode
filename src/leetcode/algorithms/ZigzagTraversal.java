package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3417. Zigzag Grid Traversal With Skip
 *
 * @author Baltan
 * @date 2025/1/18 23:46
 */
public class ZigzagTraversal {
    public static void main(String[] args) {
        System.out.println(zigzagTraversal(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(zigzagTraversal(new int[][]{{2, 1}, {2, 1}, {2, 1}}));
        System.out.println(zigzagTraversal(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public static List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int x = 0;
        int y = 0;
        /**
         * 当前在水平方向上移动的方向，向右为1，向左为-1
         */
        int direction = 1;
        /**
         * 是否保留当前单元格中的数字
         */
        boolean keep = true;

        while (x < rows) {
            if (y < 0) {
                /**
                 * 向左移动出网格时，改为移动到下一行的最左侧单元格
                 */
                y = 0;
                x++;
                direction = 1;
                continue;
            } else if (y == cols) {
                /**
                 * 向右移动出网格时，改为移动到下一行的最右侧单元格
                 */
                y = cols - 1;
                x++;
                direction = -1;
                continue;
            }

            if (keep) {
                result.add(grid[x][y]);
            }
            /**
             * 反转下一步所到单元格中数字的保留状态
             */
            keep = !keep;
            /**
             * 水平方向上向前移动一步
             */
            y += direction;
        }
        return result;
    }
}
