package leetcode.algorithms;

/**
 * Description: 29. Divide Two Integers
 *
 * @author Baltan
 * @date 2019-03-20 09:48
 */
public class Divide {
    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(5, 5));
        System.out.println(divide(-1, 1));
        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(1, Integer.MIN_VALUE));
        System.out.println(divide(Integer.MAX_VALUE, 1));
        System.out.println(divide(Integer.MAX_VALUE, 3));
        System.out.println(divide(Integer.MIN_VALUE, 2));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend < 0 && divisor > 0) {
            long lDividend = 0L - dividend;
            return (int) -Math.exp(Math.log(lDividend) - Math.log(divisor));
        } else if (dividend > 0 && divisor < 0) {
            long lDivisor = 0L - divisor;
            return (int) -Math.exp(Math.log(dividend) - Math.log(lDivisor));
        } else if (dividend < 0 && divisor < 0) {
            long lDividend = 0L - dividend;
            long lDivisor = 0L - divisor;
            return (int) Math.exp(Math.log(lDividend) - Math.log(lDivisor));
        } else {
            return (int) Math.exp(Math.log(dividend) - Math.log(divisor));
        }
    }
}
