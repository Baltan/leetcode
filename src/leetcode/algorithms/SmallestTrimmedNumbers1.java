package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 2343. Query Kth Smallest Trimmed Number
 *
 * @author Baltan
 * @date 2023/1/16 15:54
 * @see SmallestTrimmedNumbers
 */
public class SmallestTrimmedNumbers1 {
    public static void main(String[] args) {
        String[] nums1 = {"102", "473", "251", "814"};
        int[][] queries1 = {{1, 1}, {2, 3}, {4, 2}, {1, 2}};
        OutputUtils.print1DIntegerArray(smallestTrimmedNumbers(nums1, queries1));

        String[] nums2 = {"24", "37", "96", "04"};
        int[][] queries2 = {{2, 1}, {2, 2}};
        OutputUtils.print1DIntegerArray(smallestTrimmedNumbers(nums2, queries2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/query-kth-smallest-trimmed-number/solutions/1676162/by-tsreaper-hlt7/"></a>
     *
     * @param nums
     * @param queries
     * @return
     */
    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int length = nums[0].length();
        /**
         * 所有查询的trim的最大值
         */
        int maxTrim = Arrays.stream(queries).max(Comparator.comparingInt(x -> x[1])).get()[1];
        /**
         * radixSorts[i]保存对数组nums基数排序第i轮（1-based）后得到的结果，但是保存的对象不是字符串num本身，而是初始时每个num的索引
         */
        int[][] radixSorts = new int[maxTrim + 1][nums.length];
        /**
         * queues[i]保存基数排序某一轮中指定数位上值为i的字符串num的初始索引
         */
        Queue<Integer>[] queues = new Queue[10];
        /**
         * 初始时的各个num的索引
         */
        for (int i = 0; i < nums.length; i++) {
            radixSorts[0][i] = i;
        }

        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }
        /**
         * 基数排序maxTrim轮
         */
        for (int i = 1; i < radixSorts.length; i++) {
            int x = 0;
            /**
             * 顺序遍历基数排序上一轮结束后得到的索引
             */
            for (int j = 0; j < nums.length; j++) {
                int index = radixSorts[i - 1][j];
                String num = nums[index];
                /**
                 * 字符串num从低到高第i位上的数字
                 */
                int bit = num.charAt(length - i) - '0';
                queues[bit].offer(index);
            }
            /**
             * 将所有队列中的索引按序取出
             */
            for (Queue<Integer> queue : queues) {
                while (!queue.isEmpty()) {
                    radixSorts[i][x++] = queue.poll();
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int k = query[0];
            int trim = query[1];
            /**
             * 查询(k,trim)就是基数排序第trim轮后得到的第k个数字
             */
            result[i] = radixSorts[trim][k - 1];
        }
        return result;
    }
}
