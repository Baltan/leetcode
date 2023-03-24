package leetcode.algorithms;

/**
 * Description: 1420. Build Array Where You Can Find The Maximum Exactly K Comparisons
 *
 * @author Baltan
 * @date 2023/3/15 11:45
 */
public class NumOfArrays {
    public static void main(String[] args) {
        System.out.println(numOfArrays(2, 3, 1));
        System.out.println(numOfArrays(5, 2, 3));
        System.out.println(numOfArrays(9, 1, 1));
        System.out.println(numOfArrays(50, 100, 25));
        System.out.println(numOfArrays(37, 17, 7));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/solutions/514326/sheng-cheng-shu-zu-by-leetcode-solution-yswf/"></a>
     *
     * @param n
     * @param m
     * @param k
     * @return
     */
    public static int numOfArrays(int n, int m, int k) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * dp[x][y][z]表示当数组长度为x，最终search_cost值为y，数组中最大值为z时的情况，所求即为dp[n][k][1]+dp[n][k][2]+dp[n][k][3]
         * +……+dp[n][k][m]
         */
        long[][][] dp = new long[n + 1][k + 1][m + 1];
        /**
         * 初始状态：当数组长度为1时，search_cost只可能为1，这个唯一的元素可以为[1,m]
         */
        for (int z = 1; z <= m; z++) {
            dp[1][1][z] = 1;
        }

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= k && y <= x; y++) {
                /**
                 * 数组dp[x-1][y-1]的前缀和，即prefixSums[i]=dp[x-1][y-1][1]+dp[x-1][y-1][2]+……+dp[x-1][y-1][i]
                 */
                long[] prefixSums = new long[m + 1];
                /**
                 * 计算数组dp[x-1][y-1]的前缀和
                 */
                for (int i = 1; i <= m; i++) {
                    prefixSums[i] = (prefixSums[i - 1] + dp[x - 1][y - 1][i]) % mod;
                }

                for (int z = 1; z <= m; z++) {
                    /**
                     * 如果新加入的元素arr[x-1]不会使search_cost发生变化，则数组长度为x-1时，search_cost值为y，数组的最大值为z，元素
                     * arr[x-1]的值可以为[1,z]，即dp[x][y][z]=dp[x-1][y][z]*z
                     */
                    dp[x][y][z] += (dp[x - 1][y][z] * z) % mod;
                    /**
                     * 如果新加入的元素arr[x-1]使得search_cost加1，则数组长度为x-1时，search_cost值为y-1，数组的最大值为[1,z-1]，元
                     * 素arr[x-1]的值为z，即dp[x][y][z]=dp[x-1][y-1][1]+dp[x-1][y-1][2]+……+dp[x-1][y-1][z-1]=
                     * prefixSums[z-1]
                     */
                    dp[x][y][z] = (dp[x][y][z] + prefixSums[z - 1]) % mod;
                }
            }
        }
        /**
         * 计算dp[n][k][1]+dp[n][k][2]+dp[n][k][3]+……+dp[n][k][m]
         */
        for (int z = 1; z <= m; z++) {
            result = (result + dp[n][k][z]) % mod;
        }
        return (int) result;
    }
}
