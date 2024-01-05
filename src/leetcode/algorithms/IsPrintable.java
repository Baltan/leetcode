package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1591. Strange Printer II
 *
 * @author Baltan
 * @date 2024/1/5 23:15
 */
public class IsPrintable {
    public static void main(String[] args) {
        System.out.println(isPrintable(new int[][]{{1, 1, 1, 1}, {1, 2, 2, 1}, {1, 2, 2, 1}, {1, 1, 1, 1}}));
        System.out.println(isPrintable(new int[][]{{1, 1, 1, 1}, {1, 1, 3, 3}, {1, 1, 3, 4}, {5, 5, 1, 4}}));
        System.out.println(isPrintable(new int[][]{{1, 2, 1}, {2, 1, 2}, {1, 2, 1}}));
    }

    public static boolean isPrintable(int[][] targetGrid) {
        /**
         * 根据题意，颜色的种类∈[1,60]
         */
        int max = 61;
        int rows = targetGrid.length;
        int cols = targetGrid[0].length;
        /**
         * counts[i]表示最终网格图中颜色为i的方格的个数
         */
        int[] counts = new int[max];
        /**
         * edges[i][0]-edges[i][3]依次表示网格图中颜色为i的方格最上、最右、最下、最左出现的位置
         */
        int[][] edges = new int[max][4];
        /**
         * 保存网格图中还没有被还原的颜色
         */
        Queue<Integer> colors = new LinkedList<>();

        for (int[] edge : edges) {
            edge[0] = max;
            edge[1] = -1;
            edge[2] = -1;
            edge[3] = max;
        }
        /**
         * 计算网格图中每种颜色的方格的数量，以及最上、最右、最下、最左出现的位置
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int color = targetGrid[i][j];
                counts[color]++;
                edges[color][0] = Math.min(edges[color][0], i);
                edges[color][1] = Math.max(edges[color][1], j);
                edges[color][2] = Math.max(edges[color][2], i);
                edges[color][3] = Math.min(edges[color][3], j);
            }
        }

        for (int i = 1; i < max; i++) {
            if (counts[i] == 0) {
                continue;
            }
            /**
             * 说明颜色为i的方格正好构成了一个矩形
             */
            if (counts[i] == (edges[i][2] - edges[i][0] + 1) * (edges[i][1] - edges[i][3] + 1)) {
                for (int j = edges[i][0]; j <= edges[i][2]; j++) {
                    for (int k = edges[i][3]; k <= edges[i][1]; k++) {
                        /**
                         * 用颜色0表示一个方格是在更后面被染色的，对于前面染色的方格来说，它可以视作是任何颜色
                         */
                        targetGrid[j][k] = 0;
                    }
                }
                continue;
            }
            colors.offer(i);
        }
        /**
         * 说明最终网格图恰好是由若干个不同颜色的矩形拼成的
         */
        if (colors.isEmpty()) {
            return true;
        }

        while (!colors.isEmpty()) {
            /**
             * 此轮循环中是否能够还原某种颜色的矩形
             */
            boolean changed = false;
            outer:
            for (int i = 0; i < colors.size(); i++) {
                int color = colors.poll();

                for (int j = edges[color][0]; j <= edges[color][2]; j++) {
                    for (int k = edges[color][3]; k <= edges[color][1]; k++) {
                        /**
                         * 如果可以还原为颜色为color的矩形，则当前范围内的所有方格颜色必须为color或0
                         */
                        if (targetGrid[j][k] != 0 && targetGrid[j][k] != color) {
                            colors.offer(color);
                            continue outer;
                        }
                    }
                }
                /**
                 * 颜色为color的矩形被还原后，将其覆盖的所有方格染色成0
                 */
                for (int j = edges[color][0]; j <= edges[color][2]; j++) {
                    for (int k = edges[color][3]; k <= edges[color][1]; k++) {
                        targetGrid[j][k] = 0;
                    }
                }
                changed = true;
            }
            /**
             * 当前循环所有颜色都不能还原为矩形，则不可能再有颜色被还原
             */
            if (!changed) {
                return false;
            }
        }
        return true;
    }
}
