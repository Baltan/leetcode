package leetcode.algorithms;

/**
 * Description: 3196. Maximize Total Cost of Alternating Subarrays
 *
 * @author baltan
 * @date 2024/6/27 16:35
 */
public class MaximumTotalCost {
    public static void main(String[] args) {
        System.out.println(maximumTotalCost(new int[]{1, -2, 3, 4}));
        System.out.println(maximumTotalCost(new int[]{1, -1, 1, -1}));
        System.out.println(maximumTotalCost(new int[]{0}));
        System.out.println(maximumTotalCost(new int[]{1, -1}));
    }

    public static long maximumTotalCost(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        /**
         * 当前数字取正号时，数组nums到当前数字为止的最大成本
         */
        long positive = nums[0] + nums[1];
        /**
         * 当前数字取负号时，数组nums到当前数字为止的最大成本
         */
        long negative = nums[0] - nums[1];

        for (int i = 2; i < nums.length; i++) {
            /**
             * 如果当前数字要取正号，则前一个数字可以取正号，也可以取负号
             */
            long currPositive = Math.max(positive, negative) + nums[i];
            /**
             * 如果当前数字要取负号，则前一个数字只能取正号
             */
            long currNegative = positive - nums[i];
            positive = currPositive;
            negative = currNegative;
        }
        return Math.max(positive, negative);
    }
}
