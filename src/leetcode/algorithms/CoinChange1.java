package leetcode.algorithms;

/**
 * Description: 322. Coin Change
 *
 * @author Baltan
 * @date 2019-06-21 09:41
 */
public class CoinChange1 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{1, 2, 5}, 1111));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{2}, 30));
        System.out.println(coinChange(new int[]{2}, 31));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        foo:
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (coin == i) {
                    dp[i] = 1;
                    continue foo;
                } else if (coin < i && dp[i - coin] > 0) {
                    min = Integer.min(min, 1 + dp[i - coin]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }
}
