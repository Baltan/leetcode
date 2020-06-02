package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1461. Check If a String Contains All Binary Codes of Size K
 *
 * @author Baltan
 * @date 2020-06-02 07:45
 */
public class HasAllCodes {
    public static void main(String[] args) {
        System.out.println(hasAllCodes(
                "01001000100111101001010101110100010001011100011100100101010000001101010101110100100011010110101000011111111111101000010010000001000111111001110010000001011010001110100010001010001110010111011010110101110110110011010001001000110001101010101010111011111000010110101101100010000001001110000000000001100110111001011010100101001011111110010010001100011100101110111001100101001011100001110",
                7));
        System.out.println(hasAllCodes("00110110", 2));
        System.out.println(hasAllCodes("00110", 2));
        System.out.println(hasAllCodes("0110", 1));
        System.out.println(hasAllCodes("0110", 2));
        System.out.println(hasAllCodes("0000000001011100", 4));
    }

    public static boolean hasAllCodes(String s, int k) {
        /**
         * 长度为k的二进制字符串有1<<k种可能，至少需要k-1+(1<<k)长度的字符串
         */
        if (s.length() < k - 1 + (1 << k)) {
            return false;
        }
        /**
         * 保存所有长度为k的二进制字符串的十进制值的集合
         */
        Set<Integer> set = new HashSet<>();
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * 前一个长度为k的二进制字符串的十进制值
         */
        int prev = 0;
        /**
         * 计算第一个长度为k的二进制字符串的十进制值
         */
        for (int i = 0; i < k; i++) {
            prev += (charArray[i] - '0') * (1 << (k - 1 - i));
        }

        set.add(prev);
        /**
         * 以s[i]结尾的长度为k的二进制字符串的十进制值
         */
        for (int i = k; i < length; i++) {
            /**
             * charArray[i-k]-'0'为前一个长度为k的二进制字符串最高位的值
             * (charArray[i-k]-'0')*(1<<(k-1))为前一个长度为k的二进制字符串最高位对应十进制的值
             * prev-(charArray[i-k]-'0')*(1<<(k-1))为前一个长度为k的二进制字符串除去最高位后剩余部分对应十
             * 进制的值
             * (prev-(charArray[i-k]-'0')*(1<<(k-1)))<<1为当前长度为k的二进制字符串除去最低位后剩余部分对
             * 应十进制的值
             * charArray[i]-'0'为当前长度为k的二进制字符串最低位对应十进制的值
             */
            prev = ((prev - (charArray[i - k] - '0') * (1 << (k - 1))) << 1) + (charArray[i] - '0');
            set.add(prev);
            /**
             * 如果set中包含1<<k个元素，说明长度为k的二进制字符串的所有可能都包括了，直接返回true
             */
            if (set.size() == 1 << k) {
                return true;
            }
        }
        return false;
    }
}
