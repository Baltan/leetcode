package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1317. Convert Integer to the Sum of Two No-Zero Integers
 *
 * @author Baltan
 * @date 2020-01-19 10:14
 */
public class GetNoZeroIntegers {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(getNoZeroIntegers(2));
        OutputUtils.print1DIntegerArray(getNoZeroIntegers(11));
        OutputUtils.print1DIntegerArray(getNoZeroIntegers(10000));
        OutputUtils.print1DIntegerArray(getNoZeroIntegers(69));
        OutputUtils.print1DIntegerArray(getNoZeroIntegers(1010));
    }

    public static int[] getNoZeroIntegers(int n) {
        /**
         * 根据题意，n∈[2,10000]，逐一枚举尝试
         */
        for (int i = 1; i < 10000; i++) {
            if (!containsZero(i) && !containsZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{1, n - 1};
    }

    /**
     * 判断一个整数是否包含0
     *
     * @param n
     * @return
     */
    public static boolean containsZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
