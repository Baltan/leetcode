package leetcode.algorithms;

/**
 * Description: 1575. Count All Possible Routes
 *
 * @author Baltan
 * @date 2023/7/6 22:11
 */
public class CountRoutes {
    public static void main(String[] args) {
        System.out.println(countRoutes(new int[]{99659, 99904, 99736, 99641, 99865, 99549, 99646, 99797, 99984, 99756, 99662, 99773, 99888, 99819, 99800, 99701, 99531, 99686, 99627, 99981, 99717, 99796, 99967, 99748, 99886, 99766, 99813, 99863, 99947, 99825, 99976, 99651, 99704, 99997, 99711, 99653, 99903, 99882, 99799, 99771, 99998, 99884, 99628, 99722, 99811, 99805, 99937, 99735, 99781, 99715, 99852, 99507, 99682, 99664, 99509, 99899, 99543, 99555, 99739, 99745, 99594, 99765, 99918, 99894, 99830, 99864, 99672, 99562, 99634, 99648, 99513, 99861, 99721, 99557, 99744, 99649, 99581, 99897, 99953, 99647, 99684, 99950, 99692, 99966, 99655, 99564, 99654, 99518, 99939}, 30, 10, 98));
        System.out.println(countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5));
        System.out.println(countRoutes(new int[]{4, 3, 1}, 1, 0, 6));
        System.out.println(countRoutes(new int[]{5, 2, 1}, 0, 2, 3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/count-all-possible-routes/solutions/665208/dong-tai-gui-hua-lu-jing-wen-ti-ru-he-hu-hg5d/"></a>
     *
     * @param locations
     * @param start
     * @param finish
     * @param fuel
     * @return
     */
    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        int mod = 1000000007;
        int length = locations.length;
        /**
         * costs[i][j]表示从城市i到城市j的耗油量
         */
        int[][] costs = new int[length][length];
        /**
         * dp[i][j]表示从城市i出发，剩余油量为j时，到达目的地城市finish的路径数
         */
        long[][] dp = new long[length][fuel + 1];

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int cost = Math.abs(locations[i] - locations[j]);
                costs[i][j] = cost;
                costs[j][i] = cost;
            }
        }
        /**
         * 从城市finish出发，不管剩余油量有多少都有一种路径
         */
        for (int i = 0; i <= fuel; i++) {
            dp[finish][i] = 1L;
        }

        for (int i = 0; i <= fuel; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    if (j != k && i >= costs[j][k]) {
                        /**
                         * 先从城市j到达城市k，再从城市k到达目的地城市finish。因为从城市j出发时的剩余油量为i，从城市j到达城市k需要耗油
                         * costs[j][k]，所以只要是从城市k出发，到达目的地城市finish耗油量不大于i-costs[j][k]的路径都是可行的
                         */
                        dp[j][i] = (dp[j][i] + dp[k][i - costs[j][k]]) % mod;
                    }
                }
            }
        }
        return (int) dp[start][fuel];
    }
}
