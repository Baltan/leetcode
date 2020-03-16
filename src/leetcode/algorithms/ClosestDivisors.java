package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1362. Closest Divisors
 *
 * @author Baltan
 * @date 2020-03-16 12:01
 */
public class ClosestDivisors {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(closestDivisors(8));
        OutputUtils.print1DIntegerArray(closestDivisors(123));
        OutputUtils.print1DIntegerArray(closestDivisors(999));
    }

    public static int[] closestDivisors(int num) {
        int[] pair1 = factorization(num + 1);
        int[] pair2 = factorization(num + 2);
        /**
         * num+1和num+2的因式分解结果取绝对值差较小的
         */
        if (Math.abs(pair1[0] - pair1[1]) <= Math.abs(pair2[0] - pair2[1])) {
            return pair1;
        } else {
            return pair2;
        }
    }

    /**
     * 对num进行因式分解，分解成两数的乘积并且两数的绝对值差尽可能小
     *
     * @param num
     * @return
     */
    public static int[] factorization(int num) {
        int[] result = new int[2];
        int threshold = (int) Math.ceil(Math.sqrt(num));

        for (int i = threshold; i >= 1; i--) {
            double j = 1.0 * num / i;

            if (j % 1 == 0) {
                result[0] = i;
                result[1] = (int) j;
                break;
            }
        }
        return result;
    }
}
