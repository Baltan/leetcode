package leetcode.algorithms;

/**
 * Description: 880. Decoded String at Index
 *
 * @author Baltan
 * @date 2020-02-22 12:05
 */
public class DecodeAtIndex {
    public static void main(String[] args) {
        System.out.println(decodeAtIndex("leet2code3", 10));
        System.out.println(decodeAtIndex("ha22", 5));
        System.out.println(decodeAtIndex("a2345678999999999999999", 1));
        System.out.println(decodeAtIndex("a23", 6));
    }

    public static String decodeAtIndex(String S, int K) {
        int length = S.length();
        /**
         * 解码字符串的总长度
         */
        long decodedStringLength = 0;
        /**
         * 计算解码字符串的总长度
         */
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);

            if (Character.isDigit(c)) {
                decodedStringLength *= (c - '0');
            } else {
                decodedStringLength++;
            }
        }

        for (int i = length - 1; i >= 0; --i) {
            char c = S.charAt(i);
            /**
             * 如果当前编码字符串的字符c是数字，说明解码字符串decodedString是某个字符串s重复了
             * c遍拼接在一起，接下来只要考虑字符串s即可。
             */
            if (Character.isDigit(c)) {
                /**
                 * s的长度
                 */
                decodedStringLength /= (c - '0');
                /**
                 * decodedString的第K个字符就是s的第K%(s.length)个字符，如果K刚好是s.length
                 * 的整数倍的话，则就是s的最后一个字符。例如：
                 *
                 * "abcdeabcdeabcde"的第13个字符就是"abcde"的第3（=13%5）个字符
                 * "abcdeabcdeabcde"的第10个字符就是"abcde"的第5个字符
                 */
                K = (int) (K % decodedStringLength == 0 ? decodedStringLength : K % decodedStringLength);
            } else {
                /**
                 * 如果当前剩余解码字符串的长度正好等于K，说明当前字符就是所求字符
                 */
                if (K == decodedStringLength) {
                    return String.valueOf(c);
                }
                /**
                 * 将剩余解码字符串长度减1
                 */
                decodedStringLength--;
            }
        }
        return null;
    }
}
