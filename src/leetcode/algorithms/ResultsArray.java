package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 3254. Find the Power of K-Size Subarrays I
 *
 * @author baltan
 * @date 2024/8/19 09:08
 * @see ResultsArray1
 */
public class ResultsArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3));
        OutputUtils.print1DIntegerArray(resultsArray(new int[]{2, 2, 2, 2, 2}, 4));
        OutputUtils.print1DIntegerArray(resultsArray(new int[]{3, 2, 3, 2, 3, 2}, 2));
    }

    public static int[] resultsArray(int[] nums, int k) {
        /**
         * 每一个长度为1的子数组都是连续且递增的，直接返回原数组nums即可
         */
        if (k == 1) {
            return nums;
        }
        /**
         * 连续且递增的子数组的长度
         */
        int consecutive = 1;
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, -1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                consecutive = 1;
            } else {
                consecutive++;
                /**
                 * 以nums[i]结尾的连续且递增的子数组的长度不小于k时，说明子数组[nums[i-k+1],……,nums[i]]的能量值为nums[i]
                 */
                if (consecutive >= k) {
                    result[i - k + 1] = nums[i];
                }
            }
        }
        return result;
    }
}
