package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2841. Maximum Sum of Almost Unique Subarray
 *
 * @author Baltan
 * @date 2023/9/3 14:45
 */
public class MaxSum2 {
    public static void main(String[] args) {
        System.out.println(maxSum(Arrays.asList(1, 1, 1, 2), 2, 4));
        System.out.println(maxSum(Arrays.asList(2, 6, 7, 3, 1, 7), 3, 4));
        System.out.println(maxSum(Arrays.asList(5, 9, 9, 2, 4, 5, 4), 1, 3));
        System.out.println(maxSum(Arrays.asList(1, 2, 1, 2, 1, 2, 1), 3, 3));
    }

    public static long maxSum(List<Integer> nums, int m, int k) {
        long result = 0L;
        /**
         * 长度为k的子数组中所有数字之和
         */
        long sum = 0L;
        /**
         * 数字i -> 长度为k的子数组中数字i的个数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        /**
         * 对子数组nums.sublist(0,k)中的所有数字进行计数和求和
         */
        for (int i = 0; i < k; i++) {
            int num = nums.get(i);
            sum += num;
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        /**
         * 判断子数组nums.sublist(0,k)是否是一个几乎唯一子数组
         */
        if (countMap.size() >= m) {
            result = sum;
        }
        /**
         * 逐个数字向右移动子数组，判断是否能得到所有元素之和更大的几乎唯一子数组
         */
        for (int i = k; i < nums.size(); i++) {
            /**
             * 子数组中要新增的数字
             */
            int add = nums.get(i);
            /**
             * 子数组中要移除的数字
             */
            int remove = nums.get(i - k);
            sum = sum + add - remove;
            countMap.put(add, countMap.getOrDefault(add, 0) + 1);

            if (countMap.get(remove) == 1) {
                countMap.remove(remove);
            } else {
                countMap.put(remove, countMap.get(remove) - 1);
            }
            /**
             * 判断当前子数组是否是一个几乎唯一子数组
             */
            if (countMap.size() >= m) {
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
