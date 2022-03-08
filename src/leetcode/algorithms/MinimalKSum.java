package leetcode.algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 2195. Append K Integers With Minimal Sum
 *
 * @author Baltan
 * @date 2022/3/6 22:34
 */
public class MinimalKSum {
    public static void main(String[] args) {
        System.out.println(minimalKSum(
                new int[]{96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29,
                        98, 22, 21, 72, 100, 40, 84}, 35));
        System.out.println(minimalKSum(new int[]{1, 4, 25, 10, 25}, 2));
        System.out.println(minimalKSum(new int[]{5, 6}, 6));
        System.out.println(minimalKSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 100000000));
        System.out.println(
                minimalKSum(new int[]{53, 41, 90, 33, 84, 26, 50, 32, 63, 47, 66, 43, 29, 88, 71, 28, 83},
                        76));
    }

    public static long minimalKSum(int[] nums, int k) {
        /**
         * 先假设追加的k个数字就是[1,k]
         */
        long result = 1L * (1 + k) * k / 2;
        /**
         * [1,k]中已经在nums中包含的数字的个数（在nums中重复出现的只计算一次）
         */
        int count = 0;
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Set<Integer> existSet = new HashSet<>();
        /**
         * 找到[1,k]中已经在nums中包含的数字的个数（在nums中重复出现的只计算一次）
         */
        for (int num : nums) {
            if (num <= k && !existSet.contains(num)) {
                result -= num;
                count++;
                existSet.add(num);
            }
        }

        int current = k + 1;
        /**
         * 需要追加k个数字，缺失的count个数字需要用[k+1,+∞)中逐一取值尝试补充
         */
        while (count > 0) {
            /**
             * numSet中不存在的数字才可以追加
             */
            if (!numSet.contains(current)) {
                result += current;
                count--;
            }
            current++;
        }
        return result;
    }
}
