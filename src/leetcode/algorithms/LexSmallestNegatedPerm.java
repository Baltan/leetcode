package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3752. Lexicographically Smallest Negated Permutation that Sums to Target
 *
 * @author baltan
 * @date 2026/1/23 17:07
 */
public class LexSmallestNegatedPerm {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(lexSmallestNegatedPerm(1, 0));
        OutputUtils.print1DIntegerArray(lexSmallestNegatedPerm(3, 0));
        OutputUtils.print1DIntegerArray(lexSmallestNegatedPerm(1, 10000000000L));
    }

    public static int[] lexSmallestNegatedPerm(int n, long target) {
        int[] result = new int[n];
        /**
         * 大小为n的排列中所有元素之和的最大值
         */
        long sum = (long) (1 + n) * n / 2;
        /**
         * 大小为n的排列中的所有元素之和奇偶性一定和sum相同，如果target和sum的奇偶性不同，说明排列中的所有元素之和不可能为target
         */
        if ((sum + target) % 2 == 1) {
            return new int[0];
        }
        /**
         * 大小为n的排列中负数元素的索引值，为了使得排列的字典顺序最小，绝对值越大的负数越排在数组前面
         */
        int negativeIndex = 0;
        /**
         * 大小为n的排列中正数元素的索引值，为了使得排列的字典顺序最小，绝对值越大的正数越排在数组后面
         */
        int positiveIndex = n - 1;
        /**
         * 如果大小为n的排列的所有元素之和范围为[-sum,sum]，如果target不在这个范围内，说明不存在满足要求的数组
         */
        if (target > sum || target < -sum) {
            return new int[0];
        }

        for (int i = n; i >= 1; i--) {
            /**
             * 如果大小为n的排列中可以包含元素-i，则将-i尽可能放在数组前面；否则排列中只能包含元素i，将i尽可能放在数组后面
             */
            if (target + i <= sum - i) {
                result[negativeIndex++] = -i;
                target += i;
            } else {
                result[positiveIndex--] = i;
                target -= i;
            }
            sum -= i;
        }
        return result;
    }
}
