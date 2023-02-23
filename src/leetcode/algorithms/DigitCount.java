package leetcode.algorithms;

/**
 * Description: 2283. Check if Number Has Equal Digit Count and Digit Value
 *
 * @author Baltan
 * @date 2023/2/17 09:55
 */
public class DigitCount {
    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
        System.out.println(digitCount("030"));
    }

    public static boolean digitCount(String num) {
        /**
         * counts[i]表示字符串nums中数字i的个数
         */
        int[] counts = new int[10];
        char[] charArray = num.toCharArray();
        int length = charArray.length;

        for (char c : charArray) {
            counts[c - '0']++;
        }

        for (int i = 0; i < length; i++) {
            /**
             * 字符串num中数字i的个数不为num[i]，直接返回false
             */
            if (counts[i] != charArray[i] - '0') {
                return false;
            }
        }
        return true;
    }
}
