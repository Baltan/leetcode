package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 2100. Find Good Days to Rob the Bank
 *
 * @author Baltan
 * @date 2021/12/14 17:02
 */
public class GoodDaysToRobBank {
    public static void main(String[] args) {
        System.out.println(goodDaysToRobBank(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
        System.out.println(goodDaysToRobBank(new int[]{1, 2, 3, 4, 5, 6}, 2));
        System.out.println(goodDaysToRobBank(new int[]{1}, 5));
    }

    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        if (security.length <= time * 2) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        int length = security.length;
        /**
         * left2Right[i]表示从左向右计算，守卫人数连续非增的天数是否超过time天
         */
        boolean[] left2Right = new boolean[length];
        /**
         * 从左向右计算，守卫人数连续非增的天数
         */
        int left2RightCount = 0;
        /**
         * 从左向右计算守卫人数连续非增的天数
         */
        for (int i = 0; i < length; i++) {
            if (i == 0 || security[i] <= security[i - 1]) {
                left2RightCount++;
            } else {
                left2RightCount = 1;
            }

            if (left2RightCount > time) {
                left2Right[i] = true;
            }
        }
        /**
         * 从右向左计算，守卫人数连续非增的天数
         */
        int right2LeftCount = 0;
        /**
         * 从右向左计算守卫人数连续非增的天数
         */
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1 || security[i] <= security[i + 1]) {
                right2LeftCount++;
            } else {
                right2LeftCount = 1;
            }
            /**
             * 如果当天从右向左守卫人数连续非增的天数和从左向右守卫人数连续非增的天数都超过time天，则当天适合抢劫
             */
            if (right2LeftCount > time && left2Right[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
