package leetcode.algorithms;

/**
 * Description: 1328. Break a Palindrome
 *
 * @author Baltan
 * @date 2020-01-26 13:57
 */
public class BreakPalindrome {
    public static void main(String[] args) {
        System.out.println(breakPalindrome("abccba"));
        System.out.println(breakPalindrome("a"));
        System.out.println(breakPalindrome("aba"));
        System.out.println(breakPalindrome("aabaa"));
        System.out.println(breakPalindrome("abbbba"));
        System.out.println(breakPalindrome("zywfwyz"));
        System.out.println(breakPalindrome("zzzzzzz"));
    }

    public static String breakPalindrome(String palindrome) {
        char[] charArray = palindrome.toCharArray();
        int length = palindrome.length();
        /**
         * 回文字符串的长度是否是奇数
         */
        boolean lengthIsOdd = (length & 1) == 1;
        /**
         * 回文字符串正中间的索引位置
         */
        int midIndex = length / 2;

        for (int i = 0; i < length; i++) {
            /**
             * 当回文字符串的长度为奇数时，正中间的字符不论替换成什么字符串还是回文字符串
             */
            if (lengthIsOdd && i == midIndex) {
                continue;
            }
            /**
             * 从左向右找到第一个不是正中间且不是"a"的字符，替换成"a"即可
             */
            if (charArray[i] != 'a') {
                charArray[i] = 'a';
                return new String(charArray);
            }
        }
        /**
         * 当回文字符串的长度不为1，但是又没有可以替换成"a"的字符时，将最后一个字符替换成"b"即可，
         * 例如：aaaa -> aaab
         *      aabaa -> aabab
         */
        if (length != 1) {
            charArray[length - 1] = 'b';
            return new String(charArray);
        }
        return "";
    }
}
