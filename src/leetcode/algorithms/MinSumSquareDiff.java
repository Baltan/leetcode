package leetcode.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2333. Minimum Sum of Squared Difference
 *
 * @author Baltan
 * @date 2023/1/18 10:02
 */
public class MinSumSquareDiff {
    public static void main(String[] args) {
        System.out.println(minSumSquareDiff(new int[]{1, 2, 3, 4}, new int[]{2, 10, 20, 19}, 0, 0));
        System.out.println(minSumSquareDiff(new int[]{1, 4, 10, 12}, new int[]{5, 8, 6, 9}, 1, 1));
        System.out.println(minSumSquareDiff(new int[]{10, 10, 10, 11, 5}, new int[]{1, 0, 6, 6, 1}, 11, 27));
        System.out.println(minSumSquareDiff(new int[]{7, 5, 0, 12, 14}, new int[]{7, 5, 0, 12, 14}, 2, 9));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-sum-of-squared-difference/solutions/1658538/javascript-6118-zui-xiao-chai-zhi-ping-f-pp7t/"></a>
     *
     * @param nums1
     * @param nums2
     * @param k1
     * @param k2
     * @return
     */
    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long result = 0L;
        int length = nums1.length;
        /**
         * 因为让nums1[i]+/-1等于让nums2[i]-/+1，所以原题等价于将数组arr=
         * [abs(nums1[0]-nums2[0]),abs(nums1[1]-nums2[1]),……,abs(nums1[i]-nums2[i])]进行k次操作，令所有元素的平方和最小
         */
        int k = k1 + k2;
        /**
         * 初始时数组arr所有元素的平方和
         */
        long sum = 0L;
        /**
         * diffCounts[x]表示数组arr中元素x的个数
         */
        int[] diffCounts = new int[100001];
        /**
         * diffPq保存数组diffCounts中值不为0的索引，即数组arr中非0值的情况
         */
        Queue<Integer> diffPq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            diffCounts[diff]++;
            sum += 1L * diff * diff;
        }
        /**
         * 不能进行任何操作，直接返回结果
         */
        if (k == 0) {
            return sum;
        }

        for (int i = 1; i < diffCounts.length; i++) {
            if (diffCounts[i] != 0) {
                diffPq.offer(i);
            }
        }
        /**
         * 反复对数组arr的元素进行减1操作，直到k为0或者arr中所有元素都变成0
         */
        while (k > 0 && !diffPq.isEmpty()) {
            /**
             * 数组arr中的最大元素，接下去尝试将数组arr中尽可能多的元素diff都进行一次减1操作变成diff-1
             */
            int diff = diffPq.poll();
            int diffCount = diffCounts[diff];

            if (k >= diffCount) {
                /**
                 * 如果diffCounts[diff-1]不为0，说明数组arr中本来就有元素为diff-1，也说明队列diffPq本来就有diff-1，不需要重复入队，否
                 * 则将diff-1加入队列diffPq中
                 */
                if (diff - 1 > 0 && diffCounts[diff - 1] == 0) {
                    diffPq.offer(diff - 1);
                }
                /**
                 * 数组arr中所有的diff都变成了diff-1，消耗了diffCount次减1操作
                 */
                k -= diffCount;
                diffCounts[diff - 1] += diffCount;
                diffCounts[diff] = 0;
            } else {
                /**
                 * 数组arr中的diff没有全都变成diff-1，需要将diff重新加入队列diffPq中
                 */
                diffPq.offer(diff);
                /**
                 * 如果diffCounts[diff-1]不为0，说明数组arr中本来就有元素为diff-1，也说明队列diffPq本来就有diff-1，不需要重复入队，否
                 * 则将diff-1加入队列diffPq中
                 */
                if (diff - 1 > 0 && diffCounts[diff - 1] == 0) {
                    diffPq.offer(diff - 1);
                }
                /**
                 * 数组arr中的k个diff变成了diff-1，消耗了k次减1操作
                 */
                diffCounts[diff] -= k;
                diffCounts[diff - 1] += k;
                k = 0;
            }
        }
        /**
         * 计算最终数组arr所有元素的平方和
         */
        while (!diffPq.isEmpty()) {
            int diff = diffPq.poll();
            result += 1L * diff * diff * diffCounts[diff];
        }
        return result;
    }
}
