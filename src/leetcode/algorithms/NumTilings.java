package leetcode.algorithms;

/**
 * Description: 790. Domino and Tromino Tiling
 *
 * @author Baltan
 * @date 2020-02-17 11:12
 */
public class NumTilings {
    public static void main(String[] args) {
        System.out.println(numTilings(1));
        System.out.println(numTilings(2));
        System.out.println(numTilings(3));
        System.out.println(numTilings(4));
        System.out.println(numTilings(5));
        System.out.println(numTilings(6));
        System.out.println(numTilings(7));
        System.out.println(numTilings(8));
        System.out.println(numTilings(9));
        System.out.println(numTilings(1000));
    }

    public static int numTilings(int N) {
        if (N == 1) {
            return 1;
        }

        int mod = 1000000007;
        /**
         * dp[i][0]表示刚好铺满i*2的面板，dp[i][1]表示铺满i*2的面板还差右上角一格，dp[i][2]
         * 表示铺满i*2的面板还差右下角一格
         */
        long[][] dp = new long[N + 1][3];
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[2][1] = 1;
        dp[2][2] = 1;

        for (int i = 3; i <= N; i++) {
            /**
             * 刚好铺满i*2的面板有4种情况：
             * 1、刚好铺满(i-1)*2的面板，再加一块"┃"
             * 2、铺满(i-1)*2的面板还差右上角一格，再加一块"┓"
             * 3、铺满(i-1)*2的面板还差右下角一格，再加一块"┛"
             * 4、刚好铺满(i-2)*2的面板，再加两块"━"
             */
            dp[i][0] =
                    (dp[i - 1][0] % mod + dp[i - 1][1] % mod + dp[i - 1][2] % mod + dp[i - 2][0] % mod) % mod;
            /**
             * 铺满i*2的面板还差右上角一格有两种情况：
             * 1、铺满(i-1)*2的面板还差右下角一格，再加一块"━"
             * 2、刚好铺满(i-2)*2的面板，再加一块"┗"
             */
            dp[i][1] = (dp[i - 1][2] % mod + dp[i - 2][0] % mod) % mod;
            /**
             * 铺满i*2的面板还差右下角一格有两种情况：
             * 1、铺满(i-1)*2的面板还差右上角一格，再加一块"━"
             * 2、刚好铺满(i-2)*2的面板，再加一块"┏"
             */
            dp[i][2] = (dp[i - 1][1] % mod + dp[i - 2][0] % mod) % mod;
        }
        return (int) dp[N][0];
    }
}
