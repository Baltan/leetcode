package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3502. Minimum Cost to Reach Every Position
 *
 * @author Baltan
 * @date 2025/4/21 22:59
 */
public class MinCosts {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(minCosts(new int[]{5, 3, 4, 1, 3, 2}));
        OutputUtils.print1DIntegerArray(minCosts(new int[]{1, 2, 4, 6, 7}));
    }

    public static int[] minCosts(int[] cost) {
        int[] result = new int[cost.length];
        /**
         * 只能通过第一种方式到达索引为0的位置，费用为cost[0]
         */
        result[0] = cost[0];

        for (int i = 1; i < cost.length; i++) {
            /**
             * 如果通过第一种方式到达索引为i的位置，费用为cost[i]；如果先花费最小费用result[i-1]到达索引为i-1的位置，再通过第二种方式到
             * 达索引为i的位置，总费用为result[i-1]。两者取较小值
             */
            result[i] = Math.min(cost[i], result[i - 1]);
        }
        return result;
    }
}
