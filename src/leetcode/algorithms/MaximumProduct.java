package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description:Maximum Product of Three Numbers
 * @author Baltan
 *
 * @date 2017/11/7 19:35
 */
public class MaximumProduct {
    public static void main(String[] args) {

    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int num1 = nums[length - 1] * nums[length - 2] * nums[length - 3];
        int num2 = nums[length - 1] * nums[0] * nums[1];
        return Math.max(num1, num2);
    }
}
