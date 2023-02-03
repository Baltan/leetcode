package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2295. Replace Elements in an Array
 *
 * @author Baltan
 * @date 2023/1/20 18:27
 */
public class ArrayChange {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 6};
        int[][] operations1 = {{1, 3}, {4, 7}, {6, 1}};
        OutputUtils.print1DIntegerArray(arrayChange(nums1, operations1));

        int[] nums2 = {1, 2};
        int[][] operations2 = {{1, 3}, {2, 1}, {3, 2}};
        OutputUtils.print1DIntegerArray(arrayChange(nums2, operations2));
    }

    public static int[] arrayChange(int[] nums, int[][] operations) {
        /**
         * help[i]表示数字i在数组nums中的索引，如果help[i]为-1，表示数字i在数组nums中不存在，根据题意i∈[1,1000000]
         */
        int[] help = new int[1000001];
        int length = nums.length;
        /**
         * 初始化假设所有数字在数组nums中都不存在
         */
        Arrays.fill(help, -1);
        /**
         * 标记数组nums中的每个数字的索引
         */
        for (int i = 0; i < length; i++) {
            help[nums[i]] = i;
        }

        for (int[] operation : operations) {
            int from = operation[0];
            int to = operation[1];
            /**
             * 将索引index处的数字由数字from替换为数字to
             */
            int index = help[from];
            help[from] = -1;
            help[to] = index;
        }
        /**
         * 还原替换后的数组nums
         */
        for (int i = 0; i < help.length; i++) {
            if (help[i] != -1) {
                nums[help[i]] = i;
            }
        }
        return nums;
    }
}
