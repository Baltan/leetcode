package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 189. Rotate Array
 *
 * @author Baltan
 * @date 2017/11/17 10:51
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {1, 2};
        int k1 = 3;
        int k2 = 1;
        rotate(nums1, k1);
        rotate(nums2, k2);
    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int steps = k % length;
        int[] newNums = new int[length];
        for (int i = 0; i < length; i++) {
            if (i < steps) {
                newNums[i] = nums[length - steps + i];
            } else {
                newNums[i] = nums[i - steps];
            }
        }
        for (int i = 0; i < length; i++) {
            nums[i] = newNums[i];
        }
        OutputUtils.print1DIntegerArray(nums);
    }
}
