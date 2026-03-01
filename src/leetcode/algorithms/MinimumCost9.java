package leetcode.algorithms;

/**
 * Description: 3789. Minimum Cost to Acquire Required Items
 *
 * @author baltan
 * @date 2026/2/10 11:22
 */
public class MinimumCost9 {
    public static void main(String[] args) {
        System.out.println(minimumCost(3, 2, 1, 3, 2));
        System.out.println(minimumCost(5, 4, 15, 2, 3));
        System.out.println(minimumCost(5, 4, 15, 0, 0));
    }

    public static long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (cost1 + cost2 < costBoth) {
            /**
             * 购买need1个类型1物品和购买need2个类型2物品
             */
            return (long) need1 * cost1 + (long) need2 * cost2;
        }

        if (need1 >= need2) {
            /**
             * 购买need2个类型3物品和need1-need2个类型1或类型3物品
             */
            return (long) need2 * costBoth + (long) (need1 - need2) * Math.min(cost1, costBoth);
        } else {
            /**
             * 购买need1个类型3物品和need2-need1个类型2或类型3物品
             */
            return (long) need1 * costBoth + (long) (need2 - need1) * Math.min(cost2, costBoth);
        }
    }
}
