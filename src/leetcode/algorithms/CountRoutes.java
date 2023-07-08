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

    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        long result = 0L;
        int mod = 1000000007;
        int length = locations.length;
        int[][] costs = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int cost = Math.abs(locations[i] - locations[j]);
                costs[i][j] = cost;
                costs[j][i] = cost;
            }
        }
        /**
         * dp[i][j][k]表示从城市start出发移动i次到达城市j且耗油量为k的路径数量
         */
        long[][][] dp = new long[fuel + 1][length][fuel + 1];
        dp[0][start][0] = 1;

        for (int i = 1; i <= fuel; i++) {
            boolean end = true;

            for (int j = 0; j < length; j++) {
                for (int k = 1; k <= fuel; k++) {
                    for (int l = 0; l < length; l++) {
                        if (j == l) {
                            continue;
                        }

                        if (k - costs[l][j] >= 0 && dp[i - 1][l][k - costs[l][j]] > 0) {
                            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][l][k - costs[l][j]]) % mod;
                            end = false;
                        }
                    }
                }
            }

            if (end) {
                break;
            }
        }

        for (int i = 0; i <= fuel; i++) {
            for (int j = 0; j <= fuel; j++) {
                result = (result + dp[i][finish][j]) % mod;
            }
        }
        return (int) result;
    }
}
