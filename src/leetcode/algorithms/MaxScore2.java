package leetcode.algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Description: 2542. Maximum Subsequence Score
 *
 * @author Baltan
 * @date 2023/1/24 13:17
 */
public class MaxScore2 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3));
        System.out.println(maxScore(new int[]{4, 2, 3, 1, 1}, new int[]{7, 5, 10, 9, 6}, 1));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-subsequence-score/solutions/2073033/zhuan-huan-wen-ti-zui-xiao-dui-by-endles-9t8t/"></a>
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        long result = Long.MIN_VALUE;
        int length = nums1.length;
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        /**
         * 小顶堆维护从数组nums1中选择的k个较大的元素
         */
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        /**
         * 从数组nums1中选择的k个较大的元素的和
         */
        long sum = 0L;
        /**
         * 将数组nums1和nums2的索引按照数组nums2中的元素降序排列
         */
        Arrays.sort(indexes, (x, y) -> nums2[y] - nums2[x]);
        /**
         * 假设先选择了索引值为indexes[0]、indexes[1]、……、indexes[k-1]的k个元素，则数组nums1中这k个索引的元素之和sum，数组nums2中这k
         * 个索引的元素的最小值为nums2[indexes[k-1]]
         */
        for (int i = 0; i < k; i++) {
            int num = nums1[indexes[i]];
            minHeap.offer(num);
            sum += num;
        }
        result = Math.max(result, sum * nums2[indexes[k - 1]]);
        /**
         * 逐一用索引值i替换已选择的k个索引中的某一个，因为数组nums2中替换后的k个索引的元素的最小值一定是nums2[indexes[i]]，为了使得结果尽
         * 可能大，只需要将数组nums1替换前的k个索引中的元素的最小值换成nums1[indexes[i]]即可
         */
        for (int i = k; i < length; i++) {
            int num = nums1[indexes[i]];
            /**
             * 数组nums1替换前的k个索引中的元素的最小值
             */
            int min = minHeap.poll();
            minHeap.offer(num);
            sum = sum - min + num;
            result = Math.max(result, sum * nums2[indexes[i]]);
        }
        return result;
    }
}
