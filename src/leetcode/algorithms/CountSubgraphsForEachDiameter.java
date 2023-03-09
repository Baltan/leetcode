package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1617. Count Subtrees With Max Distance Between Cities
 *
 * @author Baltan
 * @date 2023/3/7 09:31
 */
public class CountSubgraphsForEachDiameter {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(countSubgraphsForEachDiameter(5, new int[][]{{1, 5}, {2, 3}, {2, 4}, {2, 5}}));
        OutputUtils.print1DIntegerArray(countSubgraphsForEachDiameter(4, new int[][]{{1, 2}, {2, 3}, {2, 4}}));
        OutputUtils.print1DIntegerArray(countSubgraphsForEachDiameter(2, new int[][]{{1, 2}}));
        OutputUtils.print1DIntegerArray(countSubgraphsForEachDiameter(3, new int[][]{{1, 2}, {2, 3}}));
    }

    public static int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] result = new int[n - 1];
        /**
         * distances[i][j]表示城市i到城市j的距离
         */
        int[][] distances = new int[n + 1][n + 1];
        /**
         * isAdjacent[i][j]表示城市i到城市j是否相邻
         */
        boolean[][] isAdjacent = new boolean[n + 1][n + 1];
        /**
         * 从所有城市中选择若干个城市的状态，如果选择了城市1则二进制状态值的最低位为1，如果选择了城市2则二进制状态值的从低到高第二位为1，以此类
         * 推，则二进制状态值的最大值为0b11……11（共n个1），最小值为0b00……11（最低两位为1，因为至少选择两个城市）
         */
        int max = (1 << n) - 1;
        int min = 0b11;
        /**
         * 查找所有相邻的城市
         */
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            isAdjacent[x][y] = true;
            isAdjacent[y][x] = true;
        }
        /**
         * 初始化所有城市之间的距离为Integer.MAX_VALUE表示相互间不可达
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        /**
         * 计算城市之间的距离
         */
        for (int i = 1; i <= n; i++) {
            getDistances(n, distances, isAdjacent, i, -1, i, 0);
        }

        for (int i = max; i >= min; i--) {
            /**
             * 从所有城市中选择若干个城市的状态
             */
            int status = i;
            int bit = 1;
            /**
             * cities[i]表示是否选择了城市i
             */
            boolean[] cities = new boolean[n + 1];
            /**
             * 被选择的城市中的最大距离
             */
            int maxDistance = 0;

            while (status != 0) {
                if ((status & 1) == 1) {
                    cities[bit] = true;
                }
                bit++;
                status >>= 1;
            }
            /**
             * 被选择的城市不在同一个连通图中，跳过当前情况
             */
            if (!isConnected(n, isAdjacent, cities)) {
                continue;
            }
            /**
             * 计算被选择的城市中的最大距离
             */
            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    if (cities[x] && cities[y]) {
                        maxDistance = Math.max(maxDistance, distances[x][y]);
                    }
                }
            }

            if (maxDistance > 0) {
                result[maxDistance - 1]++;
            }
        }
        return result;
    }

    /**
     * 判断被选择的城市是否在同一个连通图中
     *
     * @param n
     * @param isAdjacent
     * @param cities
     * @return
     */
    public static boolean isConnected(int n, boolean[][] isAdjacent, boolean[] cities) {
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (!cities[x] || !cities[y]) {
                    continue;
                }

                if (!x2y(n, isAdjacent, cities, x, y, -1)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 只经过被选择的城市，城市x能否到达城市y
     *
     * @param n
     * @param isAdjacent
     * @param cities
     * @param x
     * @param y
     * @param prev
     * @return
     */
    public static boolean x2y(int n, boolean[][] isAdjacent, boolean[] cities, int x, int y, int prev) {
        if (x == y) {
            return true;
        }
        boolean[] isConnectedWithCurr = isAdjacent[x];
        boolean connected = false;

        for (int next = 1; next <= n; next++) {
            if (cities[next] && isConnectedWithCurr[next] && next != prev) {
                connected = connected || x2y(n, isAdjacent, cities, next, y, x);
            }
        }
        return connected;
    }

    /**
     * 计算从城市start到城市curr的距离
     *
     * @param n
     * @param distances
     * @param isAdjacent
     * @param start
     * @param prev
     * @param curr
     * @param distance
     */
    public static void getDistances(int n, int[][] distances, boolean[][] isAdjacent, int start, int prev, int curr, int distance) {
        distances[start][curr] = Math.min(distances[start][curr], distance);
        /**
         * 和城市curr相邻的城市数组
         */
        boolean[] isConnectedWithCurr = isAdjacent[curr];

        for (int next = 1; next <= n; next++) {
            /**
             * next!=prev保证不会经过重复的路线
             */
            if (isConnectedWithCurr[next] && next != prev) {
                getDistances(n, distances, isAdjacent, start, curr, next, distance + 1);
            }
        }
    }
}
