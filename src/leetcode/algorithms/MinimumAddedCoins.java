package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2952. Minimum Number of Coins to be Added
 *
 * @author Baltan
 * @date 2023/12/3 22:08
 * @see GetMaximumConsecutive
 */
public class MinimumAddedCoins {
    public static void main(String[] args) {
        System.out.println(minimumAddedCoins(new int[]{15, 1, 12}, 43));
        System.out.println(minimumAddedCoins(new int[]{1, 4, 10}, 19));
        System.out.println(minimumAddedCoins(new int[]{1, 4, 10, 5, 7, 19}, 19));
        System.out.println(minimumAddedCoins(new int[]{1, 1, 1}, 20));
    }

    /**
     * 参考：<a href="https://leetcode.com/problems/minimum-number-of-coins-to-be-added/solutions/4356386/1798-maximum-number-of-consecutive-values/"></a>
     *
     * @param coins
     * @param target
     * @return
     */
    public static int minimumAddedCoins(int[] coins, int target) {
        int result = 0;
        /**
         * 当前期望得到的总额
         */
        int sum = 1;
        Arrays.sort(coins);

        for (int i = 0; i < coins.length && sum <= target; ) {
            /**
             * 如果当前可用的硬币金额大于sum，需要增加一枚价值为sum的硬币，这枚硬币和之前已得到的总额[1,sum-1)可以凑在一起得到总额
             * [sum+1,sum+sum-1)，所以下一步可以直接判断能否得到总额sum+sum；如果当前可用的硬币金额不大于sum，则这枚硬币和之前已得到的
             * 总额[1,sum-1)可以凑在一起得到总额[1+coin,sum-1+coin)，所以下一步可以直接判断能否得到总额sum+coin
             */
            if (coins[i] > sum) {
                result++;
                sum += sum;
            } else {
                sum += coins[i];
                i++;
            }
        }
        /**
         * 此前已得到的最大总额为sum-1，而硬币已用完，后面继续按照上述规则增加硬币，直到可得到的最大总额不小于target
         */
        while (sum <= target) {
            result++;
            sum += sum;
        }
        return result;
    }
}
