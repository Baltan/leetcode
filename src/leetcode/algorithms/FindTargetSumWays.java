package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 494. Target Sum
 *
 * @author Baltan
 * @date 2019-08-06 09:07
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums1, 3));

        int[] nums2 =
                {0, 7, 3, 2, 5, 7, 9, 0, 1, 3, 5, 7, 4, 2, 5, 7, 9, 5, 3, 0};
        System.out.println(findTargetSumWays(nums2, 10));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        /**
         * 用于记录可能的结果，每实现一种可能就在list中追加一个"1"
         */
        List<Integer> list = new LinkedList<>();
        /**
         * 假设所有数字前都添加"+"，计算所有数字的总和
         */
        for (int num : nums) {
            sum += num;
        }

        int difference = sum - S;
        /**
         * 如果目标值target和总和的差为奇数或者小于0，则不可能实现，直接返回0
         */
        if ((difference & 1) == 1 || difference < 0) {
            return 0;
        }
        /**
         * 当把某个数前的"+"改为"-"，表达式的和会减少该值的2倍，所以尝试找出一些数，这些数的和为差值的一半
         */
        int target = difference >> 1;
        /**
         * 对数组进行升序排序，因为数组中可能有若干0，需要特殊处理
         */
        Arrays.sort(nums);

        dfs(list, nums, target, 0);
        return list.size();
    }

    public static void dfs(List<Integer> list, int[] nums, int target, int index) {
        int length = nums.length;

        if (target == 0) {
            /**
             * 每实现一种可能就在list中追加一个"1"
             */
            list.add(1);
            /**
             * 当可修改的数字都大于0时，说明没有可以修改的数字了，直接返回，
             * 否则，可以将若干个0前的"+"改为"-"
             * 如果可以修改的数字的起始索引已经越界了，说明没有可以修改的数字了，直接返回
             */
            if (index == length || nums[index] > 0) {
                return;
            }
        }
        /**
         * 如果可以修改的数字的起始索引已经越界了，说明没有可以修改的数字了，直接返回
         */
        if (index == length) {
            return;
        }

        for (int i = index; i < length; i++) {
            target -= nums[i];
            /**
             * 将下一步修改的起始索引+1，即只修改当前数字后面的数字的符号
             */
            dfs(list, nums, target, i + 1);
            target += nums[i];
        }
    }
}
