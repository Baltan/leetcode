package leetcode.algorithms;

import java.util.List;

/**
 * Description: 3349. Adjacent Increasing Subarrays Detection I
 *
 * @author Baltan
 * @date 2024/11/12 20:20
 * @see MaxIncreasingSubarrays1
 */
public class MaxIncreasingSubarrays {
    public static void main(String[] args) {
        System.out.println(maxIncreasingSubarrays(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3));
        System.out.println(maxIncreasingSubarrays(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5));
    }

    public static boolean maxIncreasingSubarrays(List<Integer> nums, int k) {
        /**
         * 判断子数组nums[i-k+1……i]和nums[i+1……i+k]是否都是严格递增子数组
         */
        outer:
        for (int i = k - 1; i + k < nums.size(); i++) {
            /**
             * 判断子数组nums[i-k+1……i]是否是严格递增子数组
             */
            for (int j = i - k + 1; j < i; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    continue outer;
                }
            }
            /**
             * 判断子数组nums[i+1……i+k]是否是严格递增子数组
             */
            for (int j = i + k; j > i + 1; j--) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }
}
