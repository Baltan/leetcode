package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2615. Sum of Distances
 *
 * @author Baltan
 * @date 2023/4/9 21:24
 */
public class Distance {
    public static void main(String[] args) {
        OutputUtils.print1DLongArray(distance(new int[]{1, 3, 1, 1, 2}));
        OutputUtils.print1DLongArray(distance(new int[]{0, 5, 3}));
    }

    public static long[] distance(int[] nums) {
        long[] result = new long[nums.length];
        int length = nums.length;
        /**
         * 元素nums[i] -> nums[i]的前缀子数组中所有相等元素的索引之和
         */
        Map<Integer, Long> prefixIndexSums = new HashMap<>();
        /**
         * 元素nums[i] -> nums[i]的前缀子数组中所有相等元素的个数
         */
        Map<Integer, Integer> prefixNumCounts = new HashMap<>();
        /**
         * 元素nums[i] -> nums[i]的后缀子数组中所有相等元素的索引之和
         */
        Map<Integer, Long> suffixIndexSums = new HashMap<>();
        /**
         * 元素nums[i] -> nums[i]的后缀子数组中所有相等元素的个数
         */
        Map<Integer, Integer> suffixNumCounts = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            Long prefixIndexSum = prefixIndexSums.getOrDefault(num, 0L);
            Integer prefixNumCount = prefixNumCounts.getOrDefault(num, 0);
            /**
             * nums[i]的前缀子数组中所有相等元素的索引都小于i
             */
            result[i] += (long) i * prefixNumCount - prefixIndexSum;
            /**
             * 将当前元素累计进前缀子数组中
             */
            prefixIndexSums.put(num, prefixIndexSum + i);
            prefixNumCounts.put(num, prefixNumCount + 1);
        }

        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i];
            Long suffixIndexSum = suffixIndexSums.getOrDefault(num, 0L);
            Integer suffixNumCount = suffixNumCounts.getOrDefault(num, 0);
            /**
             * nums[i]的后缀子数组中所有相等元素的索引都大于i
             */
            result[i] += suffixIndexSum - (long) i * suffixNumCount;
            /**
             * 将当前元素累计进后缀子数组中
             */
            suffixIndexSums.put(num, suffixIndexSum + i);
            suffixNumCounts.put(num, suffixNumCount + 1);
        }
        return result;
    }
}
