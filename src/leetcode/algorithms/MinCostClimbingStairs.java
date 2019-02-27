package leetcode.algorithms;

/**
 * Description: Min Cost Climbing Stairs
 *
 * @author Baltan
 * @date 2018/8/7 16:59
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int[] costArray = new int[length];

        costArray[0] = 0;
        costArray[1] = 0;

        for (int i = 2; i < length; i++) {
            costArray[i] = Math.min(costArray[i - 1] + cost[i - 1], costArray[i - 2] + cost[i - 2]);
        }
        return costArray[length - 1];
    }
}
