package leetcode.algorithms;

/**
 * Description: 357. Count Numbers with Unique Digits
 *
 * @author Baltan
 * @date 2019-06-27 10:20
 */
public class CountNumbersWithUniqueDigits {
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

        for (int i = 2; i <= n; i++) {
            int digitNum = i;
            int count = 9;
            int digitIndex = 2;

            while (digitIndex <= digitNum) {
                count *= (11 - digitIndex);
                digitIndex++;
            }
            result += count;
        }
        return result;
    }
}
