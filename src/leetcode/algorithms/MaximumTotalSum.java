package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3301. Maximize the Total Height of Unique Towers
 *
 * @author baltan
 * @date 2024/9/29 17:29
 */
public class MaximumTotalSum {
    public static void main(String[] args) {
        System.out.println(maximumTotalSum(new int[]{2, 3, 4, 3}));
        System.out.println(maximumTotalSum(new int[]{15, 10}));
        System.out.println(maximumTotalSum(new int[]{2, 2, 1}));
    }

    public static long maximumTotalSum(int[] maximumHeight) {
        long result = 0L;
        /**
         * 前一座塔的高度
         */
        int prev = Integer.MAX_VALUE;
        Arrays.sort(maximumHeight);
        /**
         * 贪心思想，从高到低重新分配塔的高度，尽可能为每一座塔分配最大高度
         */
        for (int i = maximumHeight.length - 1; i >= 0; i--) {
            /**
             * 当前塔的高度不能超过maximumHeight[i]，并且必须小于前一座塔的高度prev
             */
            int height = Math.min(prev - 1, maximumHeight[i]);

            if (height <= 0) {
                return -1L;
            }
            result += height;
            prev = height;
        }
        return result;
    }
}
