package leetcode.algorithms;

/**
 * Description: 1800. Maximum Ascending Subarray Sum
 *
 * @author Baltan
 * @date 2022/6/30 16:05
 */
public class MaxAscendingSum {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        System.out.println(maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
    }

    public static int maxAscendingSum(int[] nums) {
        int result = nums[0];
        /**
         * 当前递增子数组中元素的和
         */
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                /**
                 * 开始计算一个新的递增子数组
                 */
                sum = nums[i];
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
