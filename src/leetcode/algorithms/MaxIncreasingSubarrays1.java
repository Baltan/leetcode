package leetcode.algorithms;

import java.util.List;

/**
 * Description: 3350. Adjacent Increasing Subarrays Detection II
 *
 * @author Baltan
 * @date 2024/11/12 20:20
 * @see MaxIncreasingSubarrays
 */
public class MaxIncreasingSubarrays1 {
    public static void main(String[] args) {
        System.out.println(maxIncreasingSubarrays(List.of(7, 5, 4, 2)));
        System.out.println(maxIncreasingSubarrays(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)));
        System.out.println(maxIncreasingSubarrays(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)));
    }

    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int result = 0;
        /**
         * 当前严格递增子数组的第一个元素的索引值
         */
        int start = 0;
        /**
         * 紧邻元素nums[start]的前一个严格递增子数组的最大长度，初始时将[nums[0]]看做是一个严格递增子数组
         */
        int leftHalf = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                /**
                 * 当前严格递增子数组为nums[start……i]，将其一分为二，可以得到两个相邻的长度为(i-start+1)/2的严格递增子数组
                 */
                result = Math.max(result, (i - start + 1) / 2);
                /**
                 * 紧邻元素nums[start]的前一个严格递增子数组nums[i-leftHalf……i-1]可以和当前严格递增子数组nums[start……i]构成两个相邻
                 * 的严格递增子数组，其长度为前后两个子数组长度的较小值
                 */
                result = Math.max(result, Math.min(leftHalf, i - start + 1));
            } else {
                /**
                 * 紧邻当前元素nums[i]的前一个严格递增子数组到nums[i-1]为止结束，即nums[start……i-1]，长度为i-start
                 */
                leftHalf = i - start;
                /**
                 * 从当前元素开始重新计算一个新的严格递增子数组
                 */
                start = i;
                /**
                 * 紧邻当前元素nums[i]的前一个严格递增子数组nums[i-leftHalf……i-1]可以和当前严格递增子数组[nums[i]]构成两个相邻的严格
                 * 递增子数组，其长度为1
                 */
                result = Math.max(result, 1);
            }
        }
        return result;
    }
}
