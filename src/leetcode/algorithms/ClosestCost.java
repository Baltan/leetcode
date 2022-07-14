package leetcode.algorithms;

/**
 * Description: 1774. Closest Dessert Cost
 *
 * @author Baltan
 * @date 2022/7/12 08:44
 */
public class ClosestCost {
    public static void main(String[] args) {
        System.out.println(closestCost(new int[]{1, 7}, new int[]{3, 4}, 10));
        System.out.println(closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18));
        System.out.println(closestCost(new int[]{3, 10}, new int[]{2, 5}, 9));
        System.out.println(closestCost(new int[]{10}, new int[]{1}, 1));
    }

    private static int result;

    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        /**
         * 将甜点成本初始化成一个极大值
         */
        result = Integer.MAX_VALUE;

        for (int baseCost : baseCosts) {
            dfs(toppingCosts, baseCost, target, 0);
        }
        return result;
    }

    /**
     * 递归结算最接近目标价格的甜点成本
     *
     * @param toppingCosts
     * @param totalCost    当前总价
     * @param target
     * @param from         可以选择toppingCosts中索引值大于等于from的配料
     */
    public static void dfs(int[] toppingCosts, int totalCost, int target, int from) {
        if ((totalCost > target && totalCost - target < Math.abs(result - target)) ||
                (totalCost <= target && target - totalCost <= Math.abs(result - target))) {
            result = totalCost;
        }
        /**
         * 没有配料可以选择
         */
        if (from == toppingCosts.length) {
            return;
        }
        /**
         * 如果当前总价已经大于等于目标价格，不需要继续增加配料，因为只会使得总价更加偏离目标价格
         */
        if (totalCost >= target) {
            return;
        }

        for (int i = from; i < toppingCosts.length; i++) {
            /**
             * 每种配料可以增加份数为[0,2]
             */
            for (int j = 0; j <= 2; j++) {
                totalCost += toppingCosts[i] * j;
                dfs(toppingCosts, totalCost, target, i + 1);
                totalCost -= toppingCosts[i] * j;
            }
        }
    }
}
