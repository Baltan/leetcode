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

        for (int i = 0; i < length; i++) {
            maxProductFromLeft *= nums[i];
            result = Math.max(result, maxProductFromLeft);

            if (nums[i] == 0) {
                maxProductFromLeft = 1;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            maxProductFromRight *= nums[i];
            result = Math.max(result, maxProductFromRight);

            if (nums[i] == 0) {
                maxProductFromRight = 1;
            }
        }
        return result;
    }
}
