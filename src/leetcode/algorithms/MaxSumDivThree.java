package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 1262. Greatest Sum Divisible by Three
 *
 * @author Baltan
 * @date 2019-11-21 09:00
 */
public class MaxSumDivThree {
    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(maxSumDivThree(new int[]{4}));
        System.out.println(maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
    }

    public static int maxSumDivThree(int[] nums) {
        /**
         * 数组中所有数字的和
         */
        int sum = 0;
        /**
         * 保存所有除以3余数为1的数
         */
        List<Integer> list1 = new ArrayList<>();
        /**
         * 保存所有除以3余数为2的数
         */
        List<Integer> list2 = new ArrayList<>();

        for (int num : nums) {
            sum += num;

            if (num % 3 == 1) {
                list1.add(num);
            } else if (num % 3 == 2) {
                list2.add(num);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int size1 = list1.size();
        int size2 = list2.size();
        /**
         * 数组中所有数字的和除以3的余数
         */
        int remainder = sum % 3;

        if (remainder == 1) {
            int minDeletion = Integer.MAX_VALUE;
            /**
             * 如果数组中所有数字的和除以3的余数为1，则需要删除的数字之和除以3的余数也为1，为了保证删除的数字之和
             * 尽可能小，可能有两种操作：选择list1中最小的数字，或者选择list2中最小的两个数字
             */
            if (size1 > 0) {
                minDeletion = Math.min(minDeletion, list1.get(0));
            }

            if (size2 > 1) {
                minDeletion = Math.min(minDeletion, list2.get(0) + list2.get(1));
            }
            return sum - minDeletion;
        } else if (remainder == 2) {
            int minDeletion = Integer.MAX_VALUE;
            /**
             * 如果数组中所有数字的和除以3的余数为2，则需要删除的数字之和除以3的余数也为2，为了保证删除的数字之和
             * 尽可能小，可能有两种操作：选择list2中最小的数字，或者选择list1中最小的两个数字
             */
            if (size2 > 0) {
                minDeletion = Math.min(minDeletion, list2.get(0));
            }

            if (size1 > 1) {
                minDeletion = Math.min(minDeletion, list1.get(0) + list1.get(1));
            }
            return sum - minDeletion;
        } else {
            return sum;
        }
    }
}
