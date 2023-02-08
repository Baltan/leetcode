package leetcode.algorithms;

/**
 * Description: 2520. Count the Digits That Divide a Number
 *
 * @author Baltan
 * @date 2023/2/3 09:17
 */
public class CountDigits {
    public static void main(String[] args) {
        System.out.println(countDigits(7));
        System.out.println(countDigits(121));
        System.out.println(countDigits(1248));
    }

    public static int countDigits(int num) {
        int result = 0;
        int value = num;
        /**
         * 从低位到高位依次判断每位上的数字能否整除开始时的num
         */
        while (num != 0) {
            int digit = num % 10;

            if (value % digit == 0) {
                result++;
            }
            num /= 10;
        }
        return result;
    }
}
