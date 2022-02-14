package leetcode.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2163. Minimum Difference in Sums After Removal of Elements
 *
 * @author Baltan
 * @date 2022/2/13 13:31
 */
public class MinimumDifference1 {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{3, 1, 2}));
        System.out.println(minimumDifference(new int[]{7, 9, 5, 8, 1, 3}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-difference-in-sums-after-removal-of-elements/solution/shan-chu-yuan-su-hou-he-de-zui-xiao-chai-ah0j/"></a>
     *
     * @param nums
     * @return
     */
    public static long minimumDifference(int[] nums) {
        long result = Long.MAX_VALUE;
        int length = nums.length;
        /**
         * 数组nums分成三部分后每部分的元素个数
         */
        int n = length / 3;
        int x = n - 1;
        int y = n * 2 - 1;
        /**
         * 数组已遍历元素中的最小的n个元素之和
         */
        long sum = 0L;
        /**
         * 大顶堆pq保存数组nums中已遍历元素中的最小的n个元素
         */
        Queue<Integer> pq = new PriorityQueue<>(n, Collections.reverseOrder());
        /**
         * firstPartSums[i]表示数组nums已遍历的前n+i个元素中的最小的n个元素之和
         */
        long[] firstPartSums = new long[n + 1];
        /**
         * 先将数组nums中最前面的n-1个元素加入大顶堆pq
         */
        for (int i = 0; i < x; i++) {
            pq.offer(nums[i]);
            sum += nums[i];
        }
        /**
         * 将数组的第n-1到第2n-1个元素逐一加入到大顶堆pq中，每加入一个元素，就得到了数组nums的第0个元素到第i个元素这部分元素中
         * 的最小的n个元素的和
         */
        for (int i = x; i <= y; i++) {
            pq.offer(nums[i]);
            sum += nums[i];
            firstPartSums[i - x] = sum;
            /**
             * 移除大顶堆中pq中的最大值，保持pq中只剩n-1个元素，因为我们始终只需要最小的n个元素
             */
            int max = pq.poll();
            sum -= max;
        }

        x = length - n;
        y = length - n * 2;
        /**
         * 数组已遍历元素中的最大的n个元素之和
         */
        sum = 0L;
        /**
         * 小顶堆pq保存数组nums中已遍历元素中的最大的n个元素
         */
        pq = new PriorityQueue<>(n);
        /**
         * 先将数组nums中最后面的n-1个元素加入小顶堆pq
         */
        for (int i = nums.length - 1; i > x; i--) {
            pq.offer(nums[i]);
            sum += nums[i];
        }
        /**
         * 将数组的第length-n到第length-2n个元素逐一加入到小顶堆pq中，每加入一个元素，就得到了数组nums的第i个元素到最后一个元
         * 素这部分元素中的最大的n个元素的和
         */
        for (int i = x; i >= y; i--) {
            pq.offer(nums[i]);
            sum += nums[i];
            /**
             * 此时，我们得到了数组nums的第0个元素到第i-1个元素这部分元素中的最小n个元素之和为firstPartSums[i-n]，数组nums
             * 的第i个元素到最后一个元素这部分元素中的最大n个元素之和为sum，此时两者之差即为题目要求的第一部分之和和第二部分之和
             * 的差，从所有这些差中得到最小值即可
             */
            result = Math.min(result, firstPartSums[i - n] - sum);
            /**
             * 移除小顶堆中pq中的最小值，保持pq中只剩n-1个元素，因为我们始终只需要最大的n个元素
             */
            int min = pq.poll();
            sum -= min;
        }
        return result;
    }
}
