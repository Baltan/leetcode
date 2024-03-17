package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 3080. Mark Elements on Array by Performing Queries
 *
 * @author Baltan
 * @date 2024/3/17 13:49
 */
public class UnmarkedSumArray {
    public static void main(String[] args) {
        OutputUtils.print1DLongArray(unmarkedSumArray(new int[]{1, 2, 2, 1, 2, 3, 1}, new int[][]{{1, 2}, {3, 3}, {4, 2}}));
        OutputUtils.print1DLongArray(unmarkedSumArray(new int[]{1, 4, 2, 3}, new int[][]{{0, 1}}));
    }

    public static long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long[] result = new long[queries.length];
        /**
         * marked[i]表示nums[i]是否被标记
         */
        boolean[] marked = new boolean[nums.length];
        /**
         * 数组nums中所有元素的索引
         */
        Integer[] indexes = IntStream.range(0, nums.length).boxed().toArray(Integer[]::new);
        int index = 0;
        /**
         * 数组nums中所有元素的和
         */
        long sum = 0L;
        /**
         * 将数组nums中所有元素的索引按照元素值升序排列
         */
        Arrays.sort(indexes, Comparator.comparingInt(x -> nums[x]));

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < queries.length; i++) {
            /**
             * 判断是否可以标记数组nums中索引为queries[i][0]的元素
             */
            if (!marked[queries[i][0]]) {
                marked[queries[i][0]] = true;
                sum -= nums[queries[i][0]];
            }
            /**
             * 判断是否可以标记数组nums中元素值最小的queries[i][1]个元素
             */
            while (queries[i][1] > 0 && index < indexes.length) {
                /**
                 * 数组nums剩余元素中值最小的元素为nums[indexes[index]]
                 */
                if (!marked[indexes[index]]) {
                    marked[indexes[index]] = true;
                    queries[i][1]--;
                    sum -= nums[indexes[index]];
                }
                index++;
            }
            result[i] = sum;
        }
        return result;
    }
}
