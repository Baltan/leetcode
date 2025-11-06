package leetcode.algorithms;

/**
 * Description: 3689. Maximum Total Subarray Value I
 *
 * @author baltan
 * @date 2025/11/6 14:49
 */
public class MaxTotalValue {
    public static void main(String[] args) {
        System.out.println(maxTotalValue(new int[]{1, 3, 2}, 2));
        System.out.println(maxTotalValue(new int[]{4, 2, 5, 1}, 3));
    }

    public static long maxTotalValue(int[] nums, int k) {
        /**
         * 数组nums中的最小元素
         */
        int min = Integer.MAX_VALUE;
        /**
         * 数组nums中的最大元素
         */
        int max = Integer.MIN_VALUE;
        /**
         * 当子数组包含数组nums中的最大元素和最小元素时，子数组的值最大。又因为同一个子数组可以被重复选择，所以k个子数组的值之和最大为
         * (max-min)*k
         */
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (long) (max - min) * k;
    }
}
