package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 786. K-th Smallest Prime Fraction
 *
 * @author Baltan
 * @date 2022/11/14 18:34
 * @see KthSmallestPrimeFraction
 */
public class KthSmallestPrimeFraction1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3));
        OutputUtils.print1DIntegerArray(kthSmallestPrimeFraction(new int[]{1, 7}, 1));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/k-th-smallest-prime-fraction/solutions/1127751/gong-shui-san-xie-yi-ti-shuang-jie-you-x-8ymk/"></a>
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int length = arr.length;
        /**
         * 维护一个长度为k的大顶堆，始终将最小的k个分数按照降序排列
         */
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] * x[1] - x[0] * y[1]);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (pq.size() < k) {
                    pq.offer(new int[]{arr[i], arr[j]});
                } else {
                    /**
                     * 如果堆顶分数大于当前分数，则堆顶分数肯定不是第k小的分数，将堆顶分数出队
                     */
                    if (pq.peek()[0] * arr[j] > pq.peek()[1] * arr[i]) {
                        pq.poll();
                        pq.offer(new int[]{arr[i], arr[j]});
                    }
                }
            }
        }
        return pq.peek();
    }
}
