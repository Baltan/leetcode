package leetcode.algorithms;

/**
 * Description: Divide Two Integers
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
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (divisor == 1) {
            return dividend;
        }

        boolean isDividendPositive;
        boolean isDivisorPositive;
        int quotient = 0;

        if (dividend < 0) {
            isDividendPositive = false;
        } else {
            isDividendPositive = true;
            dividend = -dividend;
        }

        if (divisor < 0) {
            isDivisorPositive = false;
        } else {
            isDivisorPositive = true;
            divisor = -divisor;
        }

        while (dividend <= divisor) {
            quotient--;
            dividend -= divisor;
        }
        return isDividendPositive == isDivisorPositive ? -quotient : quotient;
    }
}
