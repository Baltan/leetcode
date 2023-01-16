package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2537. Count the Number of Good Subarrays
 *
 * @author Baltan
 * @date 2023/1/16 09:48
 */
public class CountGood {
    public static void main(String[] args) {
        System.out.println(countGood(new int[]{1, 1, 1, 1, 1}, 10));
        System.out.println(countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
    }

    public static long countGood(int[] nums, int k) {
        long result = 0L;
        /**
         * 当前窗口中的数对
         */
        long currPairs = 0;
        int length = nums.length;
        /**
         * 窗口的起始索引
         */
        int lo = 0;
        /**
         * 窗口的结束索引
         */
        int hi = 0;
        /**
         * 元素i -> 窗口中元素i的数量
         */
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(nums[0], 1L);

        while (hi < length) {
            if (currPairs < k) {
                if (hi == length - 1) {
                    break;
                } else {
                    /**
                     * 扩大当前窗口
                     */
                    hi++;
                    /**
                     * 增加了元素nums[hi]后，元素nums[hi]可以和窗口中原有的元素nums[hi]都构成数对，所以可以增加prevCount个数对
                     */
                    long prevCount = countMap.getOrDefault(nums[hi], 0L);
                    currPairs += prevCount;
                    countMap.put(nums[hi], prevCount + 1);
                    /**
                     * 如果当前窗口的数对数量不少于k，则将窗口的结束索引放大后的窗口都符合题意
                     */
                    if (currPairs >= k) {
                        result += length - hi;
                    }
                }
            } else {
                /**
                 * 缩小窗口，移除元素nums[lo]，移除元素nums[lo]前窗口中元素nums[lo]的数量
                 */
                long prevCount = countMap.getOrDefault(nums[lo], 0L);
                /**
                 * 移除的nums[lo]和窗口中的其他prevCount-1个元素nums[lo]之前能构成数对，现在没有了
                 */
                currPairs -= prevCount - 1;
                countMap.put(nums[lo], prevCount - 1);
                lo++;
                /**
                 * 如果当前窗口的数对数量不少于k，则将窗口的结束索引放大后的窗口都符合题意
                 */
                if (currPairs >= k) {
                    result += length - hi;
                }
            }
        }
        return result;
    }
}
