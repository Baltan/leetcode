package leetcode.algorithms;

/**
 * Description: 2894. Divisible and Non-divisible Sums Difference
 *
 * @author baltan
 * @date 2023/10/10 12:21
 */
public class DifferenceOfSums {
    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3));
        System.out.println(differenceOfSums(5, 6));
        System.out.println(differenceOfSums(5, 1));
    }

    public static int differenceOfSums(int n, int m) {
        /**
         * [1,n]中所有数字的和
         */
        int sum = 0;
        /**
         * [1,n]中所有能被m整除的数字的和
         */
        int num2 = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        for (int i = m; i <= n; i += m) {
            num2 += i;
        }
        /**
         * sum-num2为[1,n]中所有不能被m整除的数字的和，即num1
         */
        return sum - num2 - num2;
    }
}
