package leetcode.algorithms;

/**
 * Description: 3099. Harshad Number
 *
 * @author Baltan
 * @date 2024/4/6 13:43
 */
public class SumOfTheDigitsOfHarshadNumber {
    public static void main(String[] args) {
        System.out.println(sumOfTheDigitsOfHarshadNumber(18));
        System.out.println(sumOfTheDigitsOfHarshadNumber(23));
    }

    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int num = x;
        /**
         * x各个数位上数字之和
         */
        int sum = 0;

        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return num % sum == 0 ? sum : -1;
    }
}
