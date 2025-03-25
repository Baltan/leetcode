package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Description: 3478. Choose K Elements With Maximum Sum
 *
 * @author Baltan
 * @date 2025/3/23 23:06
 */
public class FindMaxSum {
    public static void main(String[] args) {
        OutputUtils.print1DLongArray(findMaxSum(new int[]{19, 11, 24, 9, 16, 11, 21, 26, 13}, new int[]{15, 27, 20, 1, 12, 11, 19, 30, 27}, 4));
        OutputUtils.print1DLongArray(findMaxSum(new int[]{4, 2, 1, 5, 3}, new int[]{10, 20, 30, 40, 50}, 2));
        OutputUtils.print1DLongArray(findMaxSum(new int[]{2, 2, 2, 2}, new int[]{3, 1, 2, 3}, 1));
    }

    public static long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        long[] result = new long[nums1.length];
        /**
         * 数组nums1的索引数组，并且所有索引值按照数组nums1中对应的数字升序排列
         */
        Integer[] indexes = IntStream.range(0, nums1.length).boxed().toArray(Integer[]::new);
        /**
         * 最小堆保存数组nums2中可被选择求和的数字，并且保持堆中的数字个数不超过k个
         */
        Queue<Integer> pq = new PriorityQueue<>(k);
        /**
         * 最小堆中所有数字之和
         */
        long sum = 0L;
        Arrays.sort(indexes, Comparator.comparingInt(x -> nums1[x]));

        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];

            if (i > 0 && nums1[index] == nums1[indexes[i - 1]]) {
                /**
                 * 数组nums1中相同元素对应在数组nums2中可被选择求和的数字也相同，所以结果一样
                 */
                result[index] = result[indexes[i - 1]];
            } else {
                result[index] = sum;
            }
            /**
             * 因为nums1[index]不大于后续遍历到的数字nums1[j]，并且如果nums1[j]等于nums1[index]时，不会被重新计算数组nums2中被选择数
             * 字的和，所以对于后续的nums1[j]而言，nums2[index]肯定可被选择，将nums2[index]将入最小堆中，并计算堆中数字之和
             */
            sum += nums2[index];
            pq.offer(nums2[index]);
            /**
             * 如果堆中数字个数超过了k个，因为我们至多选择较大的k个数字求和，所以可以将堆中最小的数字排除
             */
            if (pq.size() > k) {
                sum -= pq.poll();
            }
        }
        return result;
    }
}
