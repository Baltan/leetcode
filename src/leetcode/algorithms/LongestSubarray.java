package leetcode.algorithms;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 *
 * @author Baltan
 * @date 2020-05-13 23:02
 */
public class LongestSubarray {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/jue-dui-chai-bu-chao-guo-xian-zhi-de-zui-chang-lia/"></a>
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray(int[] nums, int limit) {
        int result = 0;
        int length = nums.length;
        /**
         * increasedQueue中保存nums中的索引，并且这些索引对应nums中的元素是单调递增的
         */
        Deque<Integer> increasedQueue = new LinkedList<>();
        /**
         * decreasedQueue中保存nums中的索引，并且这些索引对应nums中的元素是单调递减的
         */
        Deque<Integer> decreasedQueue = new LinkedList<>();
        /**
         * 窗口第一个元素的索引
         */
        int left = 0;
        /**
         * right为窗口最后一个元素的索引
         */
        for (int right = 0; right < length; right++) {
            /**
             * 维护最小值单调队列，队首始终为最小值的索引
             */
            while (!increasedQueue.isEmpty() && nums[increasedQueue.peekLast()] > nums[right]) {
                increasedQueue.pollLast();
            }
            increasedQueue.offerLast(right);
            /**
             * 维护最大值单调队列，队首始终为最大值的索引
             */
            while (!decreasedQueue.isEmpty() && nums[decreasedQueue.peekLast()] < nums[right]) {
                decreasedQueue.pollLast();
            }
            decreasedQueue.offerLast(right);
            /**
             * 如果当前窗口中的最大值和最小值之差大于limit，就一直向右移动窗口第一个元素的索引
             */
            while (!decreasedQueue.isEmpty() && !increasedQueue.isEmpty() &&
                    nums[decreasedQueue.peekFirst()] - nums[increasedQueue.peekFirst()] > limit) {
                if (decreasedQueue.peekFirst() <= left) {
                    decreasedQueue.pollFirst();
                }

                if (increasedQueue.peekFirst() <= left) {
                    increasedQueue.pollFirst();
                }
                left++;
            }
            /**
             * 更新窗口的大小
             */
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
