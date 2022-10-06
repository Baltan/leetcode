package leetcode.algorithms;

/**
 * Description: 1615. Maximal Network Rank
 *
 * @author Baltan
 * @date 2022/10/4 11:26
 */
public class MaximalNetworkRank {
    public static void main(String[] args) {
        int[][] roads1 = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(maximalNetworkRank(4, roads1));

        int[][] roads2 = {{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}};
        System.out.println(maximalNetworkRank(5, roads2));

        int[][] roads3 = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};
        System.out.println(maximalNetworkRank(8, roads3));

    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        int result = 0;
        /**
         * isConnected[i][j]表示城市i和城市j是否有直接相连的道路
         */
        boolean[][] isConnected = new boolean[n][n];
        /**
         * connectedCounts[i]表示和城市i直接相连的道路的数量
         */
        int[] connectedCounts = new int[n];

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            isConnected[a][b] = true;
            isConnected[b][a] = true;
            connectedCounts[a]++;
            connectedCounts[b]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                /**
                 * 如果城市i和城市j直接相连，这条道路被重复计算过1次，需要减去
                 */
                int networkRank = connectedCounts[i] + connectedCounts[j] - (isConnected[i][j] ? 1 : 0);
                result = Math.max(result, networkRank);
            }
        }
        return result;
    }
}
