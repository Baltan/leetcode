package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 3728. Stable Subarrays With Equal Boundary and Interior Sum
 *
 * @author baltan
 * @date 2026/1/26 17:12
 */
public class CountStableSubarrays {
    public static void main(String[] args) {
        System.out.println(countStableSubarrays(new int[]{9, 3, 3, 3, 9}));
        System.out.println(countStableSubarrays(new int[]{1, 2, 3, 4, 5}));
        System.out.println(countStableSubarrays(new int[]{-4, 4, 0, 0, -8, -4}));
    }

    public static long countStableSubarrays(int[] capacity) {
        long result = 0L;
        /**
         * 数组capacity的前缀和数组
         */
        long[] prefixSums = new long[capacity.length + 1];
        /**
         * i -> 数组capacity中所有元素i的索引值的集合
         */
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < capacity.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + capacity[i];
            /**
             * capacity[i]之前所有元素capacity[i]的索引值的集合
             */
            List<Integer> indexes = indexMap.computeIfAbsent(capacity[i], x -> new ArrayList<>());

            for (int index : indexes) {
                /**
                 * 只有子数组capacity[index……i]的长度不小于3，并且子数组capacity[index+1……i-1]的元素之和为capacity[i]时，该子数组
                 * 才是一个稳定子数组
                 */
                if (i - index >= 2 && prefixSums[i] - prefixSums[index + 1] == capacity[i]) {
                    result++;
                }
            }
            indexes.add(i);
        }
        return result;
    }
}
