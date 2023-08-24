package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2830. Maximize the Profit as the Salesman
 *
 * @author baltan
 * @date 2023/8/23 11:42
 */
public class MaximizeTheProfit {
    public static void main(String[] args) {
        System.out.println(maximizeTheProfit(5, Arrays.asList(Arrays.asList(0, 0, 1), Arrays.asList(0, 2, 2), Arrays.asList(1, 3, 2))));
        System.out.println(maximizeTheProfit(5, Arrays.asList(Arrays.asList(0, 0, 1), Arrays.asList(0, 2, 10), Arrays.asList(1, 3, 2))));
    }

    public static int maximizeTheProfit(int n, List<List<Integer>> offers) {
        /**
         * dp[i]表示前i座房子可以得到的最大利润
         */
        int[] dp = new int[n + 1];
        /**
         * 房屋编号x -> 所有end为x的订单集合
         */
        Map<Integer, List<List<Integer>>> endMap = new HashMap<>();

        for (List<Integer> offer : offers) {
            endMap.computeIfAbsent(offer.get(1), x -> new ArrayList<>()).add(offer);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            List<List<Integer>> orders = endMap.getOrDefault(i - 1, Collections.emptyList());

            for (List<Integer> order : orders) {
                /**
                 * 如果要接受订单order，因为order的start为order[0]，所以之前的所有订单的end最大只能为order[0]-1
                 */
                dp[i] = Math.max(dp[i], dp[order.get(0)] + order.get(2));
            }
        }
        return dp[n];
    }
}
