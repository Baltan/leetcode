package leetcode.algorithms;

/**
 * Description: 576. Out of Boundary Paths
 *
 * @author Baltan
 * @date 2019-12-06 08:58
 */
public class FindPaths {
    public static void main(String[] args) {
        System.out.println(findPaths(2, 2, 2, 0, 0));
        System.out.println(findPaths(3, 3, 3, 1, 2));
        System.out.println(findPaths(50, 50, 50, 10, 20));
        System.out.println(findPaths(50, 50, 50, 10, 30));
        System.out.println(findPaths(50, 50, 50, 25, 25));
        System.out.println(findPaths(1, 3, 3, 0, 1));
        System.out.println(findPaths(1, 1, 5, 0, 0));
        System.out.println(findPaths(10, 10, 0, 5, 5));
    }

    public static int findPaths(int m, int n, int N, int i, int j) {
        /**
         * 如果没有移动次数，球不可能出界
         */
        if (N == 0) {
            return 0;
        }

        int result = 0;
        /**
         * dp[i][j][k]表示从起始坐标(i,j)出发，刚好移动i次，球出界的情况数
         */
        int[][][] dp = new int[N + 1][m][n];
        int mod = 1000000007;
        /**
         * 初始化从每个单元格出发，移动1次，球出界的情况数
         */
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                /**
                 * 从该单元格球可以上移一次出界
                 */
                if (k - 1 < 0) {
                    dp[1][k][l]++;
                }
                /**
                 * 从该单元格球可以下移一次出界
                 */
                if (k + 1 >= m) {
                    dp[1][k][l]++;
                }
                /**
                 * 从该单元格球可以左移一次出界
                 */
                if (l - 1 < 0) {
                    dp[1][k][l]++;
                }
                /**
                 * 从该单元格球可以右移一次出界
                 */
                if (l + 1 >= n) {
                    dp[1][k][l]++;
                }
            }
        }
        /**
         * 计算移动[2,N]次的情况
         */
        for (int k = 2; k <= N; k++) {
            for (int l = 0; l < m; l++) {
                for (int o = 0; o < n; o++) {
                    /**
                     * 判断是否可以先上移一次，再移动k-1次出界
                     */
                    if (l - 1 >= 0) {
                        dp[k][l][o] = (dp[k][l][o] + dp[k - 1][l - 1][o]) % mod;
                    }
                    /**
                     * 判断是否可以先下移一次，再移动k-1次出界
                     */
                    if (l + 1 < m) {
                        dp[k][l][o] = (dp[k][l][o] + dp[k - 1][l + 1][o]) % mod;
                    }
                    /**
                     * 判断是否可以先左移一次，再移动k-1次出界
                     */
                    if (o - 1 >= 0) {
                        dp[k][l][o] = (dp[k][l][o] + dp[k - 1][l][o - 1]) % mod;
                    }
                    /**
                     * 判断是否可以先右移一次，再移动k-1次出界
                     */
                    if (o + 1 < n) {
                        dp[k][l][o] = (dp[k][l][o] + dp[k - 1][l][o + 1]) % mod;
                    }
                }
            }
        }
        /**
         * 从起始坐标(i,j)出发，移动[1,N]次，球出界的情况数总和
         */
        for (int k = 1; k <= N; k++) {
            result = (result + dp[k][i][j]) % mod;
        }
        return result;
    }
}
