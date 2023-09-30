package leetcode.algorithms;

/**
 * Description: 2864. Maximum Odd Binary Number
 *
 * @author baltan
 * @date 2023/9/30 15:43
 */
public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("010"));
        System.out.println(maximumOddBinaryNumber("0101"));
    }

    public static String maximumOddBinaryNumber(String s) {
        char[] charArray = new char[s.length()];
        /**
         * 二进制字符串中1的个数
         */
        int oneCount = 0;
        /**
         * 因为最后得到的二进制数是奇数，所以最低位为1
         */
        charArray[s.length() - 1] = '1';

        for (char c : s.toCharArray()) {
            if (c == '1') {
                oneCount++;
            }
        }
        /**
         * 剩余的oneCount-1个1都放在最高位
         */
        for (int i = 0; i < oneCount - 1; i++) {
            charArray[i] = '1';
        }

        for (int i = oneCount - 1; i < s.length() - 1; i++) {
            charArray[i] = '0';
        }
        return new String(charArray);
    }
}
