package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2099. Find Subsequence of Length K With the Largest Sum
 *
 * @author Baltan
 * @date 2021/12/17 09:16
 */
public class MaxSubsequence {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(maxSubsequence(new int[]{2, 1, 3, 3}, 2));
        OutputUtils.print1DIntegerArray(maxSubsequence(new int[]{-1, -2, 3, 4}, 3));
        OutputUtils.print1DIntegerArray(maxSubsequence(new int[]{3, 4, 3, 3}, 2));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        int index = 0;
        int minCount = nums.length - k;
        /**
         * i -> nums中i的个数
         */
        Map<Integer, Integer> minMap = new HashMap<>();
        int[] clone = nums.clone();
        Arrays.sort(clone);
        /**
         * 对nums中最小的minCount个数进行计数
         */
        for (int i = 0; i < minCount; i++) {
            int num = clone[i];
            minMap.put(num, minMap.getOrDefault(num, 0) + 1);
        }
        /**
         * 依次遍历nums中的值，如果是nums中最小的minCount个数其中之一的就不加入result
         */
        for (int num : nums) {
            int count = minMap.getOrDefault(num, 0);

            if (count != 0) {
                minMap.put(num, count - 1);
            } else {
                result[index++] = num;
            }
        }
        return result;
    }
}
