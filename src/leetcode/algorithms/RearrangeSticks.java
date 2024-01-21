package leetcode.algorithms;

/**
 * Description: 1866. Number of Ways to Rearrange Sticks With K Sticks Visible
 *
 * @author Baltan
 * @date 2024/1/15 22:58
 */
public class RearrangeSticks {
    public static void main(String[] args) {
        System.out.println(rearrangeSticks(3, 2));
        System.out.println(rearrangeSticks(5, 5));
        System.out.println(rearrangeSticks(20, 11));
    }

    public static int rearrangeSticks(int n, int k) {
        int mod = 1000000007;
        /**
         * dp[i][j]表示长度为[n,n-i)的i根木棍，从左侧看刚好可以看到j根木棍的排列数
         */
        long[][] dp = new long[n + 1][n + 1];
        dp[1][1] = 1L;
        /**
         * 依次将所有木棍按照长度递减顺序加入到排列中
         */
        for (int i = 2; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                /**
                 * 如果当前加入的木棍放在已有木棍的最前面，则此前所有排列的情况下，都可以多看见这根木棍，所以共有dp[i-1][j-1]种排列数。如
                 * 果当前加入的木棍放在任意一根已有木棍的后面，共有i-1个选择，且都不会对此前的情况有影响，因为这根木棍是最短的，共有
                 * dp[i-1][j]*(i-1)种排列
                 */
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j] * (i - 1)) % mod;
            }
        }
        return (int) dp[n][k];
    }
}
