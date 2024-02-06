package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3026. Maximum Good Subarray Sum
 *
 * @author Baltan
 * @date 2024/2/6 22:04
 */
public class MaximumSubarraySum1 {
    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1, 2, 3, 4, 5, 6}, 1));
        System.out.println(maximumSubarraySum(new int[]{-1, 3, 2, 4, 5}, 3));
        System.out.println(maximumSubarraySum(new int[]{-1, -2, -3, -4}, 2));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long result = Long.MIN_VALUE;
        int length = nums.length;
        /**
         * 数组nums已遍历元素的前缀和
         */
        long prefixSum = nums[0];
        /**
         * 数组nums中的元素i -> 元素i之前所有元素之和的最小值
         */
        Map<Integer, Long> minPrefixSumMap = new HashMap<>();
        /**
         * 元素nums[0]之前没有前缀子数组，可以认为nums[0]之前所有元素之和为0
         */
        minPrefixSumMap.put(nums[0], 0L);

        for (int i = 1; i < length; i++) {
            /**
             * 如果之前已遍历过的前缀子数组中存在某个元素为nums[i]+k，则该元素之前所有元素之和的最小值为minPrefixSumMap[nums[i]+k]，子
             * 数组nums[j..i]中所有元素之和为prefixSum+nums[i]-minPrefixSumMap[nums[i]+k]
             */
            if (minPrefixSumMap.containsKey(nums[i] + k)) {
                result = Math.max(result, prefixSum + nums[i] - minPrefixSumMap.get(nums[i] + k));
            }
            /**
             * 如果之前已遍历过的前缀子数组中存在某个元素为nums[i]-k，则该元素之前所有元素之和的最小值为minPrefixSumMap[nums[i]-k]，子
             * 数组nums[j..i]中所有元素之和为prefixSum+nums[i]-minPrefixSumMap[nums[i]-k]
             */
            if (minPrefixSumMap.containsKey(nums[i] - k)) {
                result = Math.max(result, prefixSum + nums[i] - minPrefixSumMap.get(nums[i] - k));
            }
            /**
             * 更新数组nums中的元素nums[i]之前所有元素之和的最小值
             */
            if (minPrefixSumMap.containsKey(nums[i])) {
                minPrefixSumMap.put(nums[i], Math.min(minPrefixSumMap.get(nums[i]), prefixSum));
            } else {
                minPrefixSumMap.put(nums[i], prefixSum);
            }
            /**
             * 更新数组nums已遍历元素的前缀和
             */
            prefixSum += nums[i];
        }
        return result == Long.MIN_VALUE ? 0L : result;
    }
}
