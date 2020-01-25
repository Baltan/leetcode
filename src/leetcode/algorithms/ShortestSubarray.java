package leetcode.algorithms;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: 862. Shortest Subarray with Sum at Least K
 *
 * @author Baltan
 * @date 2020-01-15 11:53
 */
public class ShortestSubarray {
    public static void main(String[] args) {
        int[] A1 = {1};
        System.out.println(shortestSubarray(A1, 1));

        int[] A2 = {1, 2};
        System.out.println(shortestSubarray(A2, 4));

        int[] A3 = {2, -1, 2};
        System.out.println(shortestSubarray(A3, 3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-n/solution/he-zhi-shao-wei-n-de-zui-duan-zi-shu-zu-by-leetcod/"></a>
     *
     * @param A
     * @param K
     * @return
     */
    public static int shortestSubarray(int[] A, int K) {
        /**
         * 因为A.length∈[1,50000]，所以结果不可能为50001
         */
        int result = 50001;
        int length = A.length;
        /**
         * 数组A的前缀和
         */
        long[] prefixSum = new long[length + 1];
        /**
         * deque保存前缀和的索引，存入deque中的索引值单调递增i并且索引对应的前缀和prefixSum[i]单调递
         * 减
         */
        Deque<Integer> deque = new LinkedList();

        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        for (int i = 0; i <= length; ++i) {
            /**
             * 如果对于索引i和j，如果i大于j并且prefixSum[i]小于等于prefixSum[j]，那么对于大于i的索
             * 引n，如果prefixSum[n]-prefixSum[j]不小于K，一定也能保证prefixSum[n]-prefixSum[i]
             * 不小于K，并且i到n的子数组长度更小，则后续不必再考虑prefixSum[j]，从deque队尾移除索引
             * j
             */
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.getLast()]) {
                deque.removeLast();
            }
            /**
             * 对于索引j，如果prefixSum[i]-prefixSum[j]不小于K，则i到j的子数组之和满足题意，如果这
             * 个子数组的长度更小的话就更新result。因为deque中索引对应的前缀和是单调递减的，所以对于
             * 大于i的索引n，如果prefixSum[n]-prefixSum[j]不小于K，一定也能保证prefixSum[n]-
             * prefixSum[i]不小于K，并且i到n的子数组长度更小，则后续不必再考虑prefixSum[j]，
             * 从deque队首移除索引j
             */
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getFirst()] >= K) {
                result = Math.min(result, i - deque.getFirst());
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        return result == 50001 ? -1 : result;
    }
}
