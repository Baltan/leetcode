package leetcode.algorithms;

/**
 * Description: 3584. Maximum Product of First and Last Elements of a Subsequence
 *
 * @author baltan
 * @date 2025/7/8 14:46
 */
public class MaximumProduct2 {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-100000, 100000}, 2));
        System.out.println(maximumProduct(new int[]{-1, -9, 2, 3, -2, -3, 1}, 1));
        System.out.println(maximumProduct(new int[]{1, 3, -5, 5, 6, -4}, 3));
        System.out.println(maximumProduct(new int[]{2, -1, 2, -6, 5, 2, -5, 7}, 2));
    }

    public static long maximumProduct(int[] nums, int m) {
        long result = Long.MIN_VALUE;

        if (m == 1) {
            /**
             * 如果子序列长度为1，则子序列左端点和右端点都是元素本身
             */
            for (int num : nums) {
                result = Math.max(result, (long) num * num);
            }
        } else {
            /**
             * 前缀数组中的最小值
             */
            int min = nums[0];
            /**
             * 前缀数组中的最大值
             */
            int max = nums[0];
            /**
             * 当以元素nums[i]作为子序列的右端点时，子序列的左端点可能在nums[0……i-m+1]中。当nums[i]为负数时，就和nums[0……i-m+1]中的
             * 最小值相乘得到乘积的最大值；当nums[i]为正数时，就和nums[0……i-m+1]中的最大值相乘得到乘积的最大值。计算结束后，将
             * nums[i-m+2]加入前缀子数组中用于下一个数字的计算
             */
            for (int i = m - 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    result = Math.max(result, (long) nums[i] * min);
                } else {
                    result = Math.max(result, (long) nums[i] * max);
                }
                min = Math.min(min, nums[i - m + 2]);
                max = Math.max(max, nums[i - m + 2]);
            }
        }
        return result;
    }
}
