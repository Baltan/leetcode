package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 322. Coin Change
 *
 * @author Baltan
 * @date 2019-06-21 09:41
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{1, 2, 5}, 1111));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{2}, 30));
        System.out.println(coinChange(new int[]{2}, 31));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int maxCoin = Integer.MIN_VALUE;
        int minCoin = Integer.MAX_VALUE;
        Set<Integer> coinSet = new HashSet<>();

        for (int coin : coins) {
            coinSet.add(coin);
            maxCoin = Math.max(maxCoin, coin);
            minCoin = Math.min(minCoin, coin);
        }

        for (int i = 1; i <= amount; i++) {
            if (coinSet.contains(i)) {
                dp[i] = 1;
            } else if (minCoin > i) {
                dp[i] = -1;
            } else {
                int min = Integer.MAX_VALUE;

                for (int coin : coinSet) {
                    if (coin < i && dp[i - coin] > 0) {
                        min = Integer.min(min, 1 + dp[i - coin]);
                    }
                }
                dp[i] = min == Integer.MAX_VALUE ? -1 : min;
            }
        }
        return dp[amount];
    }
}
