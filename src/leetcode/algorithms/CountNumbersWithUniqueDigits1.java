package leetcode.algorithms;

/**
 * Description: 357. Count Numbers with Unique Digits
 *
 * @author Baltan
 * @date 2019-06-27 10:20
 */
public class CountNumbersWithUniqueDigits1 {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(0));
        System.out.println(countNumbersWithUniqueDigits(1));
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(3));
        System.out.println(countNumbersWithUniqueDigits(4));
        System.out.println(countNumbersWithUniqueDigits(5));
        System.out.println(countNumbersWithUniqueDigits(6));
        System.out.println(countNumbersWithUniqueDigits(7));
        System.out.println(countNumbersWithUniqueDigits(8));
        System.out.println(countNumbersWithUniqueDigits(9));
        System.out.println(countNumbersWithUniqueDigits(10));
        System.out.println(countNumbersWithUniqueDigits(11));
        System.out.println(countNumbersWithUniqueDigits(12));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 10;
        }

        if (n > 10) {
            return countNumbersWithUniqueDigits(10);
        }

        int result = 10;
        int[] help = new int[n];
        help[0] = 9;
        int leftCount = 9;

        for (int i = 1; i < n; i++) {
            help[i] = help[i - 1] * leftCount;
            leftCount--;
            result += help[i];
        }
        return result;
    }
}
