package leetcode.algorithms;

/**
 * Description: 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 *
 * @author Baltan
 * @date 2020-03-10 12:53
 * @see CheckIfPrerequisite
 * @see CheckIfPrerequisite1
 */
public class FindTheCity {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        System.out.println(findTheCity(4, edges1, 4));

        int[][] edges2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(findTheCity(5, edges2, 2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/solution/yu-zhi-ju-chi-nei-lin-ju-zui-shao-de-cheng-shi-flo/"></a>
     *
     * @param n
     * @param edges
     * @param distanceThreshold
     * @return
     */
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int result = -1;
        /**
         * 和某一个城市距离在distanceThreshold范围内城市的最小数量
         */
        int minCount = n;
        /**
         * dp[i][j]表示从城市i到城市j的最小距离
         */
        int[][] dp = new int[n][n];
        /**
         * 将所有城市到其他城市的距离都初始化为10000，因为题意约束weight∈[1,10000]
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dp[i][j] = 10000;
                }
            }
        }
        /**
         * 更新直接相连的两个城市之间的距离
         */
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int distance = edge[2];
            dp[x][y] = distance;
            dp[y][x] = distance;
        }
        /**
         * <em>Floyd算法核心代码</em>：
         * 更新城市j到城市k之间的最小距离，逐一判断从城市j先到城市i，再到城市k的距离是否比城市j直接到城市k的距离
         * 小，如果是的话就更新距离
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            /**
             * 和城市i距离在distanceThreshold范围内的城市的个数
             */
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (dp[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            /**
             * 更新结果result
             */
            if (count <= minCount) {
                result = i;
                minCount = count;
            }
        }
        return result;
    }
}
