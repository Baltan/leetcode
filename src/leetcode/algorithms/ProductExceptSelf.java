package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description:Product of Array Except Self
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
        int[] resArr = new int[nums.length];
        int[] leftArr = new int[nums.length];
        int[] rightArr = new int[nums.length];
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 1; i <= nums.length; i++) {
            leftArr[i - 1] = leftProduct;
            leftProduct *= nums[i - 1];
        }
        for (int i = nums.length - 2; i >= -1; i--) {
            rightArr[i + 1] = rightProduct;
            rightProduct *= nums[i + 1];
        }
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = leftArr[i] * rightArr[i];
        }
        return resArr;
    }
}
