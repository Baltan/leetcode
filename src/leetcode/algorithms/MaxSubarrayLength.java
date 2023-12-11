package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2958. Length of Longest Subarray With at Most K Frequency
 *
 * @author Baltan
 * @date 2023/12/10 16:22
 */
public class MaxSubarrayLength {
    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1));
        System.out.println(maxSubarrayLength(new int[]{5, 5, 5, 5, 5, 5, 5}, 4));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        int lo = 0;
        int hi = 0;
        /**
         * 数字i -> 滑动窗口中数字i的个数
         */
        Map<Integer, Integer> countMap = new HashMap<>();

        while (hi < length) {
            /**
             * 将滑动窗口中数字nums[hi]出现的次数加1
             */
            int count = countMap.getOrDefault(nums[hi], 0) + 1;
            countMap.put(nums[hi], count);
            /**
             * 如果滑动窗口中数字nums[hi]出现的次数大于k，则需要从左侧缩小窗口，直到窗口中数字nums[hi]出现的次数不大于k
             */
            if (count > k) {
                /**
                 * 因为窗口中只可能有k+1个数字nums[hi]，所以只需要缩小窗口直到最左边的第一个nums[hi]即可
                 */
                while (nums[lo] != nums[hi]) {
                    countMap.put(nums[lo], countMap.get(nums[lo]) - 1);
                    lo++;
                }
                /**
                 * 将窗口中最左边的一个nums[hi]移出窗口后，窗口中剩余k个nums[hi]
                 */
                countMap.put(nums[hi], k);
                lo++;
            }
            result = Math.max(result, hi - lo + 1);
            /**
             * 从右侧放大窗口
             */
            hi++;
        }
        return result;
    }
}
