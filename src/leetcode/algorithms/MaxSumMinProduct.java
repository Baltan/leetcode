package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Description: 1856. Maximum Subarray Min-Product
 *
 * @author Baltan
 * @date 2023/1/29 14:25
 */
public class MaxSumMinProduct {
    public static void main(String[] args) {
        System.out.println(maxSumMinProduct(new int[]{1, 2, 3, 2}));
        System.out.println(maxSumMinProduct(new int[]{2, 3, 3, 1, 2}));
        System.out.println(maxSumMinProduct(new int[]{3, 1, 5, 6, 4, 2}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-subarray-min-product/solutions/766373/java-qian-zhui-he-dan-diao-zhan-zhu-xing-95ui/?languageTags=java"></a>
     *
     * @param nums
     * @return
     */
    public static int maxSumMinProduct(int[] nums) {
        long result = Integer.MIN_VALUE;
        int mod = 1000000007;
        int length = nums.length;
        /**
         * 数组nums的前缀和
         */
        long[] prefixSums = new long[length + 1];
        /**
         * 单调栈
         */
        Deque<Integer> deque = new ArrayDeque<>();
        /**
         * rightIndexes[i]表示数组nums中nums[i]右边第一个小于它的元素的索引
         */
        int[] rightIndexes = new int[length];
        /**
         * leftIndexes[i]表示数组nums中nums[i]左边第一个小于它的元素的索引
         */
        int[] leftIndexes = new int[length];
        /**
         * 假设nums[i]右边不存在小于它的元素
         */
        Arrays.fill(rightIndexes, length);
        /**
         * 假设nums[i]左边不存在小于它的元素
         */
        Arrays.fill(leftIndexes, -1);
        /**
         * 从左向右遍历计算rightIndexes[i]，顺便计算数组nums的前缀和
         */
        for (int i = 0; i < length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
            /**
             * 从索引i向左遍历，找到所有满足index∈(x,i)且nums[index]>nums[i]的索引index，对这些索引而言，i就是nums[index]右边第一个小
             * 于它的元素的索引
             */
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
                int index = deque.pollLast();
                rightIndexes[index] = i;
            }
            deque.offerLast(i);
        }
        /**
         * 从右向左遍历计算leftIndexes[i]
         */
        for (int i = length - 1; i >= 0; i--) {
            /**
             * 从索引i向右遍历，找到所有满足index∈(i,x)且nums[index]>nums[i]的索引index，对这些索引而言，i就是nums[index]左边第一个小
             * 于它的元素的索引
             */
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
                int index = deque.pollLast();
                leftIndexes[index] = i;
            }
            deque.offerLast(i);
        }
        /**
         * 遍历计算数组nums中的所有最小乘积
         */
        for (int i = 0; i < length; i++) {
            int leftIndex = leftIndexes[i];
            int rightIndex = rightIndexes[i];
            long sum = prefixSums[rightIndex] - prefixSums[leftIndex + 1];
            result = Math.max(result, sum * nums[i]);
        }
        return (int) (result % mod);
    }
}
