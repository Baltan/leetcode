package leetcode.algorithms;

/**
 * Description: 1281. Subtract the Product and Sum of Digits of an Integer
 *
 * @author Baltan
 * @date 2019-12-09 09:04
 */
public class SubtractProductAndSum {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
        System.out.println(subtractProductAndSum(1));
        System.out.println(subtractProductAndSum(99999));
        System.out.println(subtractProductAndSum(10008));
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0) {
            /**
             * 余数即为个位数字
             */
            int remainder = n % 10;
            sum += remainder;
            product *= remainder;
            n /= 10;
        }
        return product - sum;
    }
}
