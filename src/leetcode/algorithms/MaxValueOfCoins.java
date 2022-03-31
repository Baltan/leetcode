package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2218. Maximum Value of K Coins From Piles
 *
 * @author Baltan
 * @date 2022/3/30 22:45
 */
public class MaxValueOfCoins {
    public static void main(String[] args) {
        System.out.println(
                maxValueOfCoins(Arrays.asList(Arrays.asList(1, 100, 3), Arrays.asList(7, 8, 9)), 2));
        System.out.println(
                maxValueOfCoins(Arrays.asList(Arrays.asList(100), Arrays.asList(100), Arrays.asList(100),
                        Arrays.asList(100), Arrays.asList(100), Arrays.asList(100),
                        Arrays.asList(1, 1, 1, 1, 1, 1, 700)), 7));
        System.out.println(
                maxValueOfCoins(Arrays.asList(Arrays.asList(100), Arrays.asList(100), Arrays.asList(100),
                        Arrays.asList(100), Arrays.asList(100), Arrays.asList(100)), 7));
        System.out.println(
                maxValueOfCoins(Arrays.asList(Arrays.asList(1, 100, 3)), 10));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/maximum-value-of-k-coins-from-piles/solution/zhuan-hua-cheng-fen-zu-bei-bao-pythongoc-3xnk/"></a>
     *
     * @param piles
     * @param k
     * @return
     */
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int length = piles.size();
        /**
         * 前几堆硬币栈中累计的硬币总个数
         */
        int coinCount = 0;
        /**
         * dp[i][j]表示从第0堆到第i堆个硬币栈中一共取j个硬币时，可以得到的最大面值
         */
        int[][] dp = new int[length][k + 1];
        List<Integer> Pile0 = piles.get(0);
        coinCount += Pile0.size();
        /**
         * 初始化只从第0堆硬币栈中取硬币的情况，最多可以取Math.min(k,coinCount)个硬币
         */
        for (int i = 1, most = Math.min(k, coinCount); i <= most; i++) {
            dp[0][i] = dp[0][i - 1] + Pile0.get(i - 1);
        }

        for (int i = 1; i < length; i++) {
            List<Integer> PileI = piles.get(i);
            coinCount += PileI.size();
            /**
             * 从第0堆到第i堆个硬币栈中一共取j个硬币的情况，最多可以取Math.min(k,coinCount)个硬币
             */
            for (int j = 1, x = Math.min(k, coinCount); j <= x; j++) {
                /**
                 * 从当前硬币栈累计取的总面值
                 */
                int pileSum = 0;
                /**
                 * 初始化最大面值为，当前硬币栈不取硬币，j个硬币都从之前的硬币栈中取的情况
                 */
                dp[i][j] = dp[i - 1][j];
                /**
                 * 从当前硬币栈中依次取1到j个硬币时，可以得到的最大面值，最多可以取Math.min(j,PileI.size())个硬币
                 */
                for (int l = 1, y = Math.min(j, PileI.size()); l <= y; l++) {
                    pileSum += PileI.get(l - 1);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - l] + pileSum);
                }
            }
        }
        return dp[length - 1][Math.min(coinCount, k)];
    }
}
