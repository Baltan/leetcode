package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2861. Maximum Number of Alloys
 *
 * @author baltan
 * @date 2023/9/20 10:49
 */
public class MaxNumberOfAlloys {
    public static void main(String[] args) {
        List<List<Integer>> composition1 = Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 10));
        List<Integer> stock1 = Arrays.asList(0, 0, 0);
        List<Integer> cost1 = Arrays.asList(1, 2, 3);
        System.out.println(maxNumberOfAlloys(3, 2, 15, composition1, stock1, cost1));

        List<List<Integer>> composition2 = Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 10));
        List<Integer> stock2 = Arrays.asList(0, 0, 100);
        List<Integer> cost2 = Arrays.asList(1, 2, 3);
        System.out.println(maxNumberOfAlloys(3, 2, 15, composition2, stock2, cost2));

        List<List<Integer>> composition3 = Arrays.asList(Arrays.asList(2, 1), Arrays.asList(1, 2), Arrays.asList(1, 1));
        List<Integer> stock3 = Arrays.asList(1, 1);
        List<Integer> cost3 = Arrays.asList(5, 5);
        System.out.println(maxNumberOfAlloys(2, 3, 10, composition3, stock3, cost3));
    }

    public static int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        /**
         * 二分查找可以制造的最大合金数
         */
        outer:
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            inner:
            for (int i = 0; i < k; i++) {
                /**
                 * 第i台机器制造mid份合金，扣除原有库存之后，需要购买金属的总开支
                 */
                long totalCost = 0L;
                List<Integer> materials = composition.get(i);

                for (int j = 0; j < n; j++) {
                    /**
                     * 第j种金属如果原有库存足够，则不需要另外购买，否则还需要购买mid×materials[j]-stock[j]份金属j
                     */
                    totalCost += Math.max(0, (long) mid * materials.get(j) - stock.get(j)) * cost.get(j);
                    /**
                     * 需要购买金属的总开支已超过budget，说明不能用第i台机器制造mid份合金，继续计算下一台机器的情况
                     */
                    if (totalCost > budget) {
                        continue inner;
                    }
                }
                /**
                 * 此时说明可以用第i台机器制造mid份合金，继续计算制造更多合金的情况
                 */
                lo = mid;
                continue outer;
            }
            /**
             * 此时说明没有任何机器可以制造mid份合金
             */
            hi = mid - 1;
        }
        return lo;
    }
}
