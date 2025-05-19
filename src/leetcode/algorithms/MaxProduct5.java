package leetcode.algorithms;

/**
 * Description: 3536. Maximum Product of Two Digits
 *
 * @author Baltan
 * @date 2025/5/19 23:37
 */
public class MaxProduct5 {
    public static void main(String[] args) {
        System.out.println(maxProduct(31));
        System.out.println(maxProduct(22));
        System.out.println(maxProduct(124));
    }

    public static int maxProduct(int n) {
        /**
         * 数字n的各个数位上最大的数字
         */
        int first = -1;
        /**
         * 数字n的各个数位上第二大的数字
         */
        int second = -1;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            if (digit >= first) {
                second = first;
                first = digit;
            } else if (digit > second) {
                second = digit;
            }
        }
        return first * second;
    }
}
