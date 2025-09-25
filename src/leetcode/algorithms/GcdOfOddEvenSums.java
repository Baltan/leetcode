package leetcode.algorithms;

/**
 * Description: 3658. GCD of Odd and Even Sums
 *
 * @author baltan
 * @date 2025/9/23 17:29
 */
public class GcdOfOddEvenSums {
    public static void main(String[] args) {
        System.out.println(gcdOfOddEvenSums(4));
        System.out.println(gcdOfOddEvenSums(5));
    }

    public static int gcdOfOddEvenSums(int n) {
        /**
         * 前n个奇数的总和=1+3+5+……+(2n-1)
         */
        int min = n * n;
        /**
         * 前n个偶数的总和=2+4+6+……+2n=1+3+5+……+(2n-1)+n=min+n
         */
        int max = min + n;
        int remainder;
        /**
         * 辗转相除法计算min和max的最大公约数
         */
        while ((remainder = max % min) != 0) {
            max = min;
            min = remainder;
        }
        return min;
    }
}
