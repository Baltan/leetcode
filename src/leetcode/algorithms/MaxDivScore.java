package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2644. Find the Maximum Divisibility Score
 *
 * @author Baltan
 * @date 2023/4/16 13:18
 */
public class MaxDivScore {
    public static void main(String[] args) {
        System.out.println(maxDivScore(new int[]{4, 7, 9, 3, 9}, new int[]{5, 2, 3}));
        System.out.println(maxDivScore(new int[]{20, 14, 21, 10}, new int[]{5, 7, 5}));
        System.out.println(maxDivScore(new int[]{12}, new int[]{10, 16}));
    }

    public static int maxDivScore(int[] nums, int[] divisors) {
        int result = Integer.MAX_VALUE;
        int maxScore = Integer.MIN_VALUE;
        /**
         * 根据题意，divisors[i]∈[1,1000]，定义一个不在这个范围内的值作为数组divisors中第一个元素的比较对象
         */
        int prev = -1;
        /**
         * 对数组divisors进行排列，避免相同元素重复计算score值
         */
        Arrays.sort(divisors);

        for (int divisor : divisors) {
            if (divisor == prev) {
                continue;
            }
            prev = divisor;
            /**
             * 数组nums中能被divisor整除的元素的个数
             */
            int score = (int) Arrays.stream(nums).filter(x -> x % divisor == 0).count();

            if (score > maxScore || (score == maxScore && divisor < result)) {
                result = divisor;
                maxScore = score;
            }
        }
        return result;
    }
}
