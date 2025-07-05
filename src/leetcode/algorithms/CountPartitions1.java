package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 3578. Count Partitions With Max-Min Difference at Most K
 *
 * @author Baltan
 * @date 2025/6/27 22:55
 */
public class CountPartitions1 {
    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{9, 4, 1, 3, 7}, 4));
        System.out.println(countPartitions(new int[]{3, 3, 4}, 0));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/count-partitions-with-max-min-difference-at-most-k/solutions/3695749/dp-dan-diao-dui-lie-qian-zhui-he-by-qing-nml6/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int countPartitions(int[] nums, int k) {
        int mod = 1000000007;
        int length = nums.length;
        /**
         * dp[i]表示子数组nums[i……length-1]按照题意分割的方案数
         */
        long[] dp = new long[length + 1];
        /**
         * suffixSums[i]表示数组dp的后缀和，即dp[i]+dp[i+1]+……+dp[length]
         */
        long[] suffixSums = new long[length + 2];
        /**
         * 对于元素nums[i]，能和它分配到同一数组的元素的索引最大值的上限
         */
        int right = length - 1;
        dp[length] = 1;
        suffixSums[length] = 1;
        /**
         * 保持队列中的元素递增，用于计算子数组nums[i……right]中的最小值
         */
        Deque<Integer> minDeque = new ArrayDeque<>();
        /**
         * 保持队列中的元素递减，用于计算子数组nums[i……right]中的最大值
         */
        Deque<Integer> maxDeque = new ArrayDeque<>();

        for (int i = length - 1; i >= 0; i--) {
            /**
             * 将递增队列中尾部大于nums[i]的元素全部出队
             */
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[i]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[i]);
            /**
             * 将递减队列中尾部小于nums[i]的元素全部出队
             */
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[i]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[i]);
            /**
             * 如果当前子数组nums[i……right]中的最大值maxDeque.peekFirst()和最小值minDeque.peekFirst()之差大于k，则需要缩小right
             */
            while (maxDeque.peekFirst() - minDeque.peekFirst() > k) {
                /**
                 * 如果nums[right]就是子数组nums[i……right]中的最小值，则缩小right后，需要将子数组中最小值出队
                 */
                if (nums[right] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                /**
                 * 如果nums[right]就是子数组nums[i……right]中的最大值，则缩小right后，需要将子数组中最大值出队
                 */
                if (nums[right] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                right--;
            }
            /**
             * 以nums[i]作为左端点的子数组，右端点可以为nums[i]、nums[i+1]、……、nums[right]，共有dp[i+1]+dp[i+2]+……+dp[right+1]
             * 种方案数，即suffixSums[i+1]-suffixSums[right+2]种方案数
             */
            dp[i] = (suffixSums[i + 1] - suffixSums[right + 2] + mod) % mod;
            suffixSums[i] = (dp[i] + suffixSums[i + 1]) % mod;
        }
        return (int) dp[0];
    }
}