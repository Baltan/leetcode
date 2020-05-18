package leetcode.algorithms;

/**
 * Description: 152. Maximum Product Subarray
 *
 * @author Baltan
 * @date 2019-06-01 19:31
 */
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        int maxProductFromLeft = 1;
        int maxProductFromRight = 1;
        int length = nums.length;
        /**
         * 从左向右计算连续子数组的乘积
         */
        for (int i = 0; i < length; i++) {
            maxProductFromLeft *= nums[i];
            result = Math.max(result, maxProductFromLeft);
            /**
             * 当出现某个元素为0时，包含该元素的连续子数组的乘积一定都为0，跳过该元素，从下一个元素开始重新从左向右
             * 计算连续子数组的乘积
             */
            if (nums[i] == 0) {
                maxProductFromLeft = 1;
            }
        }
        /**
         * 从右向左计算连续子数组的乘积
         */
        for (int i = length - 1; i >= 0; i--) {
            maxProductFromRight *= nums[i];
            result = Math.max(result, maxProductFromRight);
            /**
             * 当出现某个元素为0时，包含该元素的连续子数组的乘积一定都为0，跳过该元素，从下一个元素开始重新从右向左
             * 计算连续子数组的乘积
             */
            if (nums[i] == 0) {
                maxProductFromRight = 1;
            }
        }
        return result;
    }
}
