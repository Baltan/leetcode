package leetcode.algorithms;

/**
 * Description: 1240. Tiling a Rectangle with the Fewest Squares
 *
 * @author baltan
 * @date 2024/8/7 11:36
 */
public class TilingRectangle {
    public static void main(String[] args) {
        System.out.println(tilingRectangle(2, 3));
        System.out.println(tilingRectangle(5, 8));
        System.out.println(tilingRectangle(11, 13));
    }

    private static int result;

    public static int tilingRectangle(int n, int m) {
        result = Integer.MAX_VALUE;
        /**
         * isVisited[i][j]表示网格(i,j)是否已被瓷砖覆盖
         */
        boolean[][] isVisited = new boolean[n][m];
        backtrack(n, m, isVisited, 0);
        return result;
    }

    /**
     * 回溯遍历所有可能的瓷砖铺设方案
     *
     * @param n
     * @param m
     * @param isVisited
     * @param count
     */
    public static void backtrack(int n, int m, boolean[][] isVisited, int count) {
        /**
         * 当前铺设方案已不是最优，直接结束
         */
        if (count >= result) {
            return;
        }
        /**
         * 下一块瓷砖左上角的坐标
         */
        int[] topLeft = getTopLeft(n, m, isVisited);
        /**
         * 所有网格都已被瓷砖覆盖，当前铺设方案可行
         */
        if (topLeft[0] == -1 && topLeft[1] == -1) {
            result = Math.min(result, count);
            return;
        }
        /**
         * 以坐标topLeft作为下一块瓷砖左上角的坐标时，可铺设瓷砖的最大边长
         */
        int max = getMax(n, m, isVisited, topLeft);
        /**
         * 从大到小尝试铺设瓷砖，减少尝试次数
         */
        for (int i = max; i > 0; i--) {
            /**
             * 标记当前瓷砖覆盖的网格
             */
            for (int j = topLeft[0]; j < topLeft[0] + i; j++) {
                for (int k = topLeft[1]; k < topLeft[1] + i; k++) {
                    isVisited[j][k] = true;
                }
            }
            count++;
            /**
             * 继续铺设下一块瓷砖
             */
            backtrack(n, m, isVisited, count);
            count--;
            /**
             * 撤销标记当前瓷砖覆盖的网格
             */
            for (int j = topLeft[0]; j < topLeft[0] + i; j++) {
                for (int k = topLeft[1]; k < topLeft[1] + i; k++) {
                    isVisited[j][k] = false;
                }
            }
        }
    }

    /**
     * 计算下一块瓷砖左上角的坐标，如果不能铺设瓷砖，返回[-1,-1]
     *
     * @param n
     * @param m
     * @param isVisited
     * @return
     */
    public static int[] getTopLeft(int n, int m, boolean[][] isVisited) {
        /**
         * 从左上向右下查找第一个未被瓷砖覆盖的网格，作为下一块瓷砖左上角的坐标
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 计算以坐标topLeft作为下一块瓷砖左上角的坐标时，可铺设瓷砖的最大边长
     *
     * @param n
     * @param m
     * @param isVisited
     * @param topLeft
     * @return
     */
    public static int getMax(int n, int m, boolean[][] isVisited, int[] topLeft) {
        int max = 1;
        outer:
        for (int i = 1; topLeft[0] + i <= n && topLeft[1] + i <= m; i++) {
            for (int j = topLeft[0]; j < topLeft[0] + i; j++) {
                for (int k = topLeft[1]; k < topLeft[1] + i; k++) {
                    /**
                     * 以坐标topLeft作为左上角坐标，i*i的范围内已有网格被瓷砖覆盖
                     */
                    if (isVisited[j][k]) {
                        break outer;
                    }
                }
            }
            max = i;
        }
        return max;
    }
}
