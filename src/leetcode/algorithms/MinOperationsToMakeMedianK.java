package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3107. Minimum Operations to Make Median of Array Equal to K
 *
 * @author Baltan
 * @date 2024/4/8 21:49
 */
public class MinOperationsToMakeMedianK {
    public static void main(String[] args) {
        System.out.println(minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 4));
        System.out.println(minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 7));
        System.out.println(minOperationsToMakeMedianK(new int[]{1, 2, 3, 4, 5, 6}, 4));
    }

    public static long minOperationsToMakeMedianK(int[] nums, int k) {
        long result = 0L;
        /**
         * 数组nums排序后，中位数的索引值
         */
        int mid = nums.length / 2;
        Arrays.sort(nums);
        /**
         * 所有索引小于mid的元素都不大于k
         */
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] <= k) {
                break;
            }
            result += nums[i] - k;
        }
        /**
         * 所有索引大于mid的元素都不小于k
         */
        for (int i = mid + 1; i < nums.length; i++) {
            if (nums[i] >= k) {
                break;
            }
            result += k - nums[i];
        }
        /**
         * nums[mid]最终需要变为k
         */
        return result + Math.abs(nums[mid] - k);
    }
}
