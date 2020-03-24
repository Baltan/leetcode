package leetcode.algorithms;

/**
 * Description: 375. Guess Number Higher or Lower II
 *
 * @author Baltan
 * @date 2020-03-24 12:22
 * @see GuessNumber
 */
public class GetMoneyAmount {
    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/cai-shu-zi-da-xiao-ii-by-leetcode/"></a>
     *
     * @param n
     * @return
     */
    public static int getMoneyAmount(int n) {
        /**
         * dp[i][j]表示在[i,j]中猜中至少要花的钱，则我们第一次可以猜[i,j]中的任意一个数字，比如说第一次
         * 猜了x，如果没有猜对那么接下去要在[i,x-1]或[x+1,j]中继续猜，最坏情况可以花费
         * x+Math.max(dp[i][x-1],dp[x+1][j])猜中数字。对于开头先猜[i,j]这j-i+1种情况，我们选择花费
         * 最小的
         */
        int[][] dp = new int[n + 1][n + 1];
        /**
         * 在[i,i]中猜中不用花费，因为只能猜i一个数字
         */
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }
        /**
         * length代表区间长度，因为猜了某个数字之后，会被分成两个更小的区间，所以先计算较短区间的情况
         */
        for (int length = 2; length <= n; length++) {
            /**
             * start代表length长度的区间的起始值，最小为1，最大为n+1-length
             */
            for (int start = 1; start <= n + 1 - length; start++) {
                /**
                 * 当前计算区间的上界，即当前在[start,end]中猜数字
                 */
                int end = length + start - 1;
                /**
                 * 在当前区间中猜数字的最大花费
                 */
                int cost = Integer.MAX_VALUE;
                /**
                 * i为第一次猜的数字
                 */
                for (int i = start; i <= end; i++) {
                    if (i == n) {
                        /**
                         * 如果第一次就猜上界值，如果没猜对，后面就只能在左边区间继续猜了
                         */
                        cost = Math.min(cost, i + dp[start][i - 1]);
                    } else {
                        cost = Math.min(cost, i + Math.max(dp[start][i - 1], dp[i + 1][end]));
                    }
                }
                dp[start][end] = cost;
            }
        }
        return dp[1][n];
    }
}
