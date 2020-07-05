package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 *
 * @author Baltan
 * @date 2020-07-05 14:40
 */
public class MinSumOfLengths {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 2, 4, 3};
        System.out.println(minSumOfLengths(arr1, 3));

        int[] arr2 = {7, 3, 4, 7};
        System.out.println(minSumOfLengths(arr2, 7));

        int[] arr3 = {4, 3, 2, 6, 2, 3, 4};
        System.out.println(minSumOfLengths(arr3, 6));

        int[] arr4 = {5, 5, 4, 4, 5};
        System.out.println(minSumOfLengths(arr4, 3));

        int[] arr5 = {3, 1, 1, 1, 5, 1, 2, 1};
        System.out.println(minSumOfLengths(arr5, 3));
    }

    public static int minSumOfLengths(int[] arr, int target) {
        int result = Integer.MAX_VALUE;
        int length = arr.length;
        /**
         * dp1[i]表示子数组arr.subarray(0,i)中的和为target的最小子数组的长度
         */
        int[] dp1 = new int[length + 1];
        /**
         * dp2[i]表示子数组arr.subarray(i)中的和为target的最小子数组的长度
         */
        int[] dp2 = new int[length + 1];
        dp1[0] = Integer.MAX_VALUE;
        dp2[length] = Integer.MAX_VALUE;
        /**
         * arr的前缀和
         */
        int prefixSum = 0;
        /**
         * 前缀和i -> 前缀和为i的元素的索引
         */
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);
        /**
         * arr的后缀和
         */
        int suffixSum = 0;
        /**
         * 后缀和i -> 后缀和为i的元素的索引
         */
        Map<Integer, Integer> suffixSumMap = new HashMap<>();
        suffixSumMap.put(0, length);

        for (int i = 1; i <= length; i++) {
            prefixSum += arr[i - 1];
            prefixSumMap.put(prefixSum, i - 1);
            /**
             * 如果prefixSumMap包含值为prefixSum-target的key，说明存在最后一个元素为arr[i]且和为target的子数组，
             * 更新dp1[i]
             */
            if (prefixSumMap.containsKey(prefixSum - target)) {
                dp1[i] = Math.min(dp1[i - 1], i - 1 - prefixSumMap.get(prefixSum - target));
            } else {
                dp1[i] = dp1[i - 1];
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            suffixSum += arr[i];
            suffixSumMap.put(suffixSum, i);
            /**
             * 如果suffixSumMap包含值为suffixSum-target的key，说明存在第一个元素为arr[i]且和为target的子数组，
             * 更新dp2[i]
             */
            if (suffixSumMap.containsKey(suffixSum - target)) {
                dp2[i] = Math.min(dp2[i + 1], suffixSumMap.get(suffixSum - target) - i);
            } else {
                dp2[i] = dp2[i + 1];
            }
        }
        /**
         * 将arr分成arr.subarray(0,i)和arr.subarray(i)两个子数组后如果能从两个子数组中各找到一个和为target
         * 的子数组，则说明满足题目要求，更新result
         */
        for (int i = 1; i < length; i++) {
            if (dp1[i] != Integer.MAX_VALUE && dp2[i] != Integer.MAX_VALUE) {
                result = Math.min(result, dp1[i] + dp2[i]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
