package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 238. Product of Array Except Self
 *
 * @author Baltan
 * @date 2017/11/29 08:58
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        OutputUtils.print1DIntegerArray(productExceptSelf(nums1));
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        /**
         * 数组nums的前缀积，prefixProduct[i]=nums[0]*nums[1]*…*nums[i-1]
         */
        int[] prefixProduct = new int[length + 1];
        /**
         * 数组nums的后缀积，suffixProduct[i]=nums[length-1]*nums[length-2]*…*nums[i]
         */
        int[] suffixProduct = new int[length + 1];
        prefixProduct[0] = 1;
        suffixProduct[length] = 1;

        for (int i = 1; i <= length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i];
        }

        for (int i = 0; i < result.length; i++) {
            /**
             * result[i]=(nums[0]*…*nums[i-1])*(nums[i+1]*…*nums[length-1])
             *          =prefixProduct[i]*suffixProduct[i+1]
             */
            result[i] = prefixProduct[i] * suffixProduct[i + 1];
        }
        return result;
    }
}
