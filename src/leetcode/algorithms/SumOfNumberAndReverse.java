package leetcode.algorithms;

/**
 * Description: 2443. Sum of Number and Its Reverse
 *
 * @author Baltan
 * @date 2022/12/4 14:14
 */
public class SumOfNumberAndReverse {
    public static void main(String[] args) {
        System.out.println(sumOfNumberAndReverse(0));
        System.out.println(sumOfNumberAndReverse(21));
        System.out.println(sumOfNumberAndReverse(101));
        System.out.println(sumOfNumberAndReverse(16665));
        System.out.println(sumOfNumberAndReverse(443));
        System.out.println(sumOfNumberAndReverse(63));
        System.out.println(sumOfNumberAndReverse(181));
    }

    public static boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + reverse(i) == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数字num跌到所有数位后得到的新数字
     *
     * @param num
     * @return
     */
    public static int reverse(int num) {
        int result = 0;

        while (num != 0) {
            int remainder = num % 10;
            num /= 10;
            result = result * 10 + remainder;
        }
        return result;
    }
}
