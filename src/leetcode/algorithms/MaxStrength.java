package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2708. Maximum Strength of a Group
 *
 * @author Baltan
 * @date 2023/5/28 17:50
 */
public class MaxStrength {
    public static void main(String[] args) {
        System.out.println(maxStrength(new int[]{3, -1, -5, 2, 5, -9}));
        System.out.println(maxStrength(new int[]{-4, -5, -4}));
    }

    public static long maxStrength(int[] nums) {
        /**
         * 如果数组nums中只有一个数字，则只能选择该数字
         */
        if (nums.length == 1) {
            return nums[0];
        }
        /**
         * 数组nums中的所有正数
         */
        List<Integer> positives = new ArrayList<>();
        /**
         * 数组nums中的所有负数
         */
        List<Integer> negatives = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                positives.add(num);
            } else if (num < 0) {
                negatives.add(num);
            }
        }

        if (negatives.size() > 1) {
            long result = 1L;
            Collections.sort(negatives);
            /**
             * 选择negatives中值最小的2n个数字，累乘这2n个数字
             */
            for (int i = 0; i + 1 < negatives.size(); i += 2) {
                result = result * negatives.get(i) * negatives.get(i + 1);
            }
            /**
             * 继续累乘positives中的所有数字
             */
            for (int num : positives) {
                result *= num;
            }
            return result;
        } else {
            /**
             * 如果数组nums中存在正数，则累乘所有正数即可，剩余的0个或1个负数以及数字0都忽略
             */
            if (!positives.isEmpty()) {
                long result = 1L;

                for (int num : positives) {
                    result *= num;
                }
                return result;
            } else {
                /**
                 * 因为数组nums中至少有两个数字，不存在正数，负数可能为0个或1个，所以至少有1个0
                 */
                return 0L;
            }
        }
    }
}
