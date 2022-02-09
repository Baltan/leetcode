package leetcode.algorithms;

/**
 * Description: 1952. Three Divisors
 *
 * @author Baltan
 * @date 2022/2/8 15:06
 */
public class IsThree {
    public static void main(String[] args) {
        System.out.println(isThree(2));
        System.out.println(isThree(4));
        System.out.println(isThree(10000));
    }

    public static boolean isThree(int n) {
        if (n < 4) {
            return false;
        }
        /**
         * n的平方根取整
         */
        int sqrt = (int) Math.sqrt(n);
        /**
         * 如果n刚好有3个除数，则n一定是一个平方数，反之如果n不是平方数，则n的除数个数一定不是3个
         */
        if (sqrt * sqrt != n) {
            return false;
        }
        /**
         * n除了除数1、sqrt、n外不能有其他除数
         */
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
