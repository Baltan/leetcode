package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1390. Four Divisors
 *
 * @author Baltan
 * @date 2020-03-23 10:11
 */
public class SumFourDivisors {
    public static void main(String[] args) {
        System.out.println(sumFourDivisors(new int[]{21, 4, 7}));
        System.out.println(sumFourDivisors(new int[]{21, 4, 7, 1073741824}));
    }

    public static int sumFourDivisors(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * 一个整数不同因数的个数
         */
        int divisorCount = 0;
        /**
         * 一个整数所有因数的和
         */
        int divisorSum = 0;
        /**
         * 将nums中所有元素升序排列，避免重复计算
         */
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            /**
             * 如果当前元素和前一个元素相等，并且前一个元素有四个因数，直接在结果中加上那四个因数的和
             */
            if (i > 0 && nums[i] == nums[i - 1] && divisorCount == 4) {
                result += divisorSum;
                continue;
            }

            int threshold = (int) Math.sqrt(num);
            /**
             * 当前元素不同因数的个数
             */
            divisorCount = 0;
            /**
             * 当前元素所有因数的和
             */
            divisorSum = 0;

            for (int j = 1; j <= threshold; j++) {
                if (num % j == 0) {
                    if (num / j != j) {
                        divisorCount += 2;
                        divisorSum = divisorSum + num / j + j;
                    } else {
                        divisorCount += 1;
                        divisorSum += j;
                    }
                    /**
                     * 如果当前元素的因数个数已经超过4个了，就不需要继续计算了
                     */
                    if (divisorCount > 4) {
                        break;
                    }
                }
            }

            if (divisorCount == 4) {
                result += divisorSum;
            }
        }
        return result;
    }
}
