package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题 17.19. 消失的两个数字
 *
 * @author Baltan
 * @date 2022/2/23 16:59
 */
public class MissingTwo {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(missingTwo(new int[]{1}));
        OutputUtils.print1DIntegerArray(missingTwo(new int[]{2, 3}));
    }

    public static int[] missingTwo(int[] nums) {
        /**
         * 不缺失数字的情况下数字总个数
         */
        int total = nums.length + 2;
        /**
         * 不缺失数字的情况下所有数字之和
         */
        int sum = (1 + total) * total / 2;
        /**
         * 不缺失数字的情况下所有数字平方和，利用平方和公式：1^2+2^2+3^2+……+n^2=n(n+1)(2n+1)/6
         */
        long powerSum = 1L * total * (total + 1) * (2 * total + 1) / 6;
        /**
         * 当前所有数字之和
         */
        int currSum = 0;
        /**
         * 当前所有数字平方和
         */
        long currPowerSum = 0L;

        for (int num : nums) {
            currSum += num;
            currPowerSum += num * num;
        }
        /**
         * 缺失的两个数字之和
         */
        int sumDiff = sum - currSum;
        /**
         * 缺失的两个数字平方和
         */
        long powerSumDiff = powerSum - currPowerSum;
        /**
         * 假设缺失的两个数字为x和y，则：①、x+y=sumDiff，②、x^2+y^2=powerSumDiff，通过换元和求根公式可得：
         * y=(sumDiff±Math.sqrt(2*powerSumDiff-sumDiff*sumDiff))/2，其中delta=2*powerSumDiff-sumDiff*sumDiff
         */
        long delta = 2 * powerSumDiff - sumDiff * sumDiff;
        int deltaSqrt = (int) Math.sqrt(delta);
        int num1 = (sumDiff + deltaSqrt) / 2;

        if (num1 > total) {
            num1 = (sumDiff - deltaSqrt) / 2;
        }
        int num2 = sumDiff - num1;
        return new int[]{num1, num2};
    }
}
