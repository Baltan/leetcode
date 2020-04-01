package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 面试题 16.19. 水域大小
 *
 * @author Baltan
 * @date 2020-04-01 12:09
 */
public class PondSizes {
    /**
     * 记录当前水域的面积
     */
    public static int area;

    public static void main(String[] args) {
        int[][] land1 = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        OutputUtils.print1DIntegerArray(pondSizes(land1));
    }


    public static int[] pondSizes(int[][] land) {
        Queue<Integer> queue = new PriorityQueue<>();
        int rows = land.length;
        int cols = land[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 0) {
                    area = 0;
                    /**
                     * 计算当前水域面积
                     */
                    dfs(land, i, j, rows, cols);
                    queue.offer(area);
                }
            }
        }

        int[] result = new int[queue.size()];
        int index = 0;

        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }
        return result;
    }

    public static void dfs(int[][] land, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || land[i][j] != 0) {
            return;
        }

        land[i][j] = -1;
        area++;
        /**
         * 向上、下、左、右、左上、右上、左下、右下延伸查找水域
         */
        dfs(land, i - 1, j - 1, rows, cols);
        dfs(land, i - 1, j, rows, cols);
        dfs(land, i - 1, j + 1, rows, cols);
        dfs(land, i, j - 1, rows, cols);
        dfs(land, i, j + 1, rows, cols);
        dfs(land, i + 1, j - 1, rows, cols);
        dfs(land, i + 1, j, rows, cols);
        dfs(land, i + 1, j + 1, rows, cols);
    }
}
