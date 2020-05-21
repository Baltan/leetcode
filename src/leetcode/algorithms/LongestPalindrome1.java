package leetcode.algorithms;

/**
 * Description: 5. Longest Palindromic Substring
 *
 * @author Baltan
 * @date 2018/1/12 10:25
 */
public class LongestPalindrome1 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("abcdc"));
        System.out.println(longestPalindrome("abcdee"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("abcde"));
        System.out.println(longestPalindrome(null));
    }

    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        if (s.equals("")) {
            return "";
        }

        int maxLength = 0;
        int length = s.length();
        /**
         * 最长回文子串的起始索引
         */
        int lo = 0;
        /**
         * 最长回文子串的结束索引
         */
        int hi = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            /**
             * 长度为偶数的回文子串的长度
             */
            int evenLength = 0;
            /**
             * 长度为偶数的回文子串从中心开始向两端延伸的长度
             */
            int evenOffset = 0;

            while (i - evenOffset >= 0 && i + 1 + evenOffset < length &&
                    s.charAt(i - evenOffset) == s.charAt(i + 1 + evenOffset)) {
                evenLength += 2;
                evenOffset++;
            }
            /**
             * 如果当前偶数长度的回文子串长度更长，则更新最长回文子串的起始索引和结束索引
             */
            if (evenLength > maxLength) {
                maxLength = evenLength;
                lo = i - (evenLength - 1) / 2;
                hi = i + evenLength / 2;
            }
            /**
             * 长度为奇数的回文子串的长度
             */
            int oddLength = 1;
            /**
             * 长度为奇数的回文子串从中心开始向两端延伸的长度
             */
            int oddOffset = 1;

            while (i - oddOffset >= 0 && i + oddOffset < length &&
                    s.charAt(i - oddOffset) == s.charAt(i + oddOffset)) {
                oddLength += 2;
                oddOffset++;
            }
            /**
             * 如果当前奇数长度的回文子串长度更长，则更新最长回文子串的起始索引和结束索引
             */
            if (oddLength > maxLength) {
                maxLength = oddLength;
                lo = i - (oddLength - 1) / 2;
                hi = i + oddLength / 2;
            }
        }
        return s.substring(lo, hi + 1);
    }
}