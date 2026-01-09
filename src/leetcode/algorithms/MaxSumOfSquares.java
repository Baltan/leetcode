package leetcode.algorithms;

/**
 * Description: 3723. Maximize Sum of Squares of Digits
 *
 * @author baltan
 * @date 2026/1/9 14:26
 */
public class MaxSumOfSquares {
    public static void main(String[] args) {
        System.out.println(maxSumOfSquares(1, 9));
        System.out.println(maxSumOfSquares(2, 3));
        System.out.println(maxSumOfSquares(2, 17));
        System.out.println(maxSumOfSquares(1, 10));
    }

    public static String maxSumOfSquares(int num, int sum) {
        /**
         * 如果num个数位上的每个数字都为“9”，这些数字之和仍小于sum，则不存在满足条件的数字
         */
        if (num * 9 < sum) {
            return "";
        }
        /**
         * 满足条件的唯一数字为"999……999"（共num个9）
         */
        if (num * 9 == sum) {
            return "9".repeat(num);
        }
        /**
         * 数字中"9"的个数
         */
        int count1 = sum / 9;
        /**
         * 数字中非"9"和"0"的数字
         */
        int remainder = sum - 9 * count1;
        /**
         * 数字中"0"的个数
         */
        int count3 = num - count1 - 1;
        /**
         * 将count1个数字9、1个数字remainder、count3个数字0依次拼接构成满足条件的最大数字
         */
        return "9".repeat(count1) + remainder + (count3 <= 0 ? "" : "0".repeat(count3));
    }
}
