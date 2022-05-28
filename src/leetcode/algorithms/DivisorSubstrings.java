package leetcode.algorithms;

/**
 * Description: 2269. Find the K-Beauty of a Number
 *
 * @author Baltan
 * @date 2022/5/22 14:40
 */
public class DivisorSubstrings {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(10, 1));
        System.out.println(divisorSubstrings(240, 2));
        System.out.println(divisorSubstrings(430043, 2));
    }

    public static int divisorSubstrings(int num, int k) {
        int result = 0;
        /**
         * 当num对10^k取余时，可以得到当前num的最后k位数
         */
        int base = (int) Math.pow(10, k);
        /**
         * 符合条件的子串的长度为k，则子串表示数字的最小值为10^(k-1)
         */
        int lowerLimit = base / 10;
        int originalNum = num;

        while (num >= lowerLimit) {
            /**
             * num的最后k位数
             */
            int remainder = num % base;

            if (remainder != 0 && originalNum % remainder == 0) {
                result++;
            }
            /**
             * 将num的最低位去除
             */
            num /= 10;
        }
        return result;
    }
}
