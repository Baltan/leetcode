package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2212. Maximum Points in an Archery Competition
 *
 * @author Baltan
 * @date 2022/3/21 22:41
 */
public class MaximumBobPoints {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(maximumBobPoints(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0}));
        OutputUtils.print1DIntegerArray(maximumBobPoints(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2}));
    }

    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] result = new int[12];
        int min = 0;
        int max = (int) (Math.pow(2, 12) - 1);
        int bobPoint = Integer.MIN_VALUE;
        /**
         * 每个i的二进制的从低到高的第x位如果为1，表示Bob最终赢得了x分计分区域
         */
        for (int i = min; i <= max; i++) {
            /**
             * 当前情况下Bob至少需要的箭的数量
             */
            int totalArrows = 0;
            /**
             * 当前情况下Bob的总得分
             */
            int totalScore = 0;
            /**
             * 当前判断的计分区域得分
             */
            int currentScore = 0;
            /**
             * Bob赢得的最大计分区域得分
             */
            int maxScore = 0;
            int num = i;
            int[] condition = new int[12];

            while (num > 0) {
                int bit = num & 1;

                if (bit == 1) {
                    /**
                     * Bob要赢得当前计分区域，至少需要比Alice在当前计分区域的中箭多一支
                     */
                    condition[currentScore] = aliceArrows[currentScore] + 1;
                    totalArrows += condition[currentScore];
                    totalScore += currentScore;
                    maxScore = currentScore;
                }
                currentScore++;
                num >>= 1;
            }
            /**
             * 如果当前情况下Bob至少需要的箭的数量不超过限制numArrows，并且总得分更大，则是一种更优的方案
             */
            if (totalScore > bobPoint && totalArrows <= numArrows) {
                bobPoint = totalScore;
                result = condition;
                /**
                 * 不足numArrows的剩余的箭可以到分配给maxScore计分区域（任意分配给Bob赢得的计分区域都行）
                 */
                if (totalArrows < numArrows) {
                    result[maxScore] += (numArrows - totalArrows);
                }
            }
        }
        return result;
    }
}
