package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1224. Maximum Equal Frequency
 *
 * @author Baltan
 * @date 2019-10-17 09:20
 */
public class MaxEqualFreq {
    public static void main(String[] args) {
        System.out.println(maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}));
        System.out.println(maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5}));
        System.out.println(maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2}));
        System.out.println(maxEqualFreq(new int[]{10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6}));
        System.out.println(maxEqualFreq(new int[]{1, 1}));
        System.out.println(maxEqualFreq(new int[]{1, 2}));
    }

    public static int maxEqualFreq(int[] nums) {
        int result = 1;
        /**
         * 保存每个数字出现的次数
         */
        Map<Integer, Integer> m1 = new HashMap<>();
        /**
         * 保存出现每种次数的数字的个数
         */
        Map<Integer, Integer> m2 = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int oldTimes = m1.getOrDefault(num, 0);
            int newTimes = oldTimes + 1;
            /**
             * 更新当前数字出现的次数
             */
            m1.put(num, newTimes);
            /**
             * 如果之前出现oldTimes次的数字只有num一个，那么现在num出现的次数已经为newTimes次了，没有数字出现的次数
             * 为oldTimes次了，将oldTimes这个key从m2中移除；否则m2中保存的出现oldTimes次的数字的个数减1。将m2中保
             * 存的出现newTimes次的数字的个数加1
             */
            if (m2.containsKey(oldTimes) && m2.get(oldTimes) == 1) {
                m2.remove(oldTimes);
            } else if (m2.containsKey(oldTimes)) {
                m2.put(oldTimes, m2.get(oldTimes) - 1);
            }
            m2.put(newTimes, m2.getOrDefault(newTimes, 0) + 1);
            /**
             * 以下几种情况是符合题目要求的：
             * 1、所有出现的数字都相同
             * 2、所有数字出现的次数都为1次
             * 3、m2中保存的次数只有2种情况，出现较多次数的数字只有1个，例如：1，1，2，2，3，3，3
             * 4、m2中保存的次数只有2种情况，较少次数为1次，并且出现1次的数字只有1个，例如：1，1，2，2，3，3，4
             */
            if (m1.size() == 1) {
                result = i + 1;
            } else if (m1.size() == i + 1) {
                result = i + 1;
            } else if (m2.size() == 2) {
                Integer[] keys = m2.keySet().toArray(new Integer[0]);
                int minTimes = Math.min(keys[0], keys[1]);
                int maxTimes = Math.max(keys[0], keys[1]);

                if (maxTimes - minTimes == 1 && m2.get(maxTimes) == 1) {
                    result = i + 1;
                } else if (minTimes == 1 && m2.get(minTimes) == 1) {
                    result = i + 1;
                }
            }
        }
        return result;
    }
}
