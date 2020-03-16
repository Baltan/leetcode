package leetcode.interview;

/**
 * Description: 面试题 08.11. 硬币
 *
 * @author Baltan
 * @date 2020-03-16 17:46
 * @see leetcode.algorithms.Change
 */
public class WaysToChange {
    public static void main(String[] args) {
        System.out.println(waysToChange(5));
        System.out.println(waysToChange(10));
        System.out.println(waysToChange(1000000));
    }

    public static int waysToChange(int n) {
        /**
         * dp[i]表示金额为i时，有dp[i]种方式凑成
         */
        long[] dp = new long[n + 1];
        int[] coins = {1, 5, 10, 25};
        dp[0] = 1;
        int mod = 1000000007;
        /**
         * 每新增一种面额的硬币后，不小于该面额的总额可能有新的凑法，例如：
         * ①只有面额为1的硬币时，0、1、2、3、4、5元各有1种方式凑成，dp=[1,1,1,1,1,1]，
         * ②新增面额为2的硬币后，2元的凑法可以在0元的基础上加一个2元硬币获得，dp=[1,1,2,1,1,1]，
         * 3元的凑法可以在1元的基础上加一个2元硬币获得，dp=[1,1,2,2,1,1]，4元的凑法可以在2元的基
         * 础上加一个2元硬币获得，dp=[1,1,2,2,3,1]，5元的凑法可以在3元的基础上加一个2元硬币获得，
         * dp=[1,1,2,2,3,3]
         * ③新增面额为5的硬币后，5元的凑法可以在0元的基础上加一个5元硬币获得，dp=[1,1,2,2,3,4]。
         */
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return (int) (dp[n] % mod);
    }
}
