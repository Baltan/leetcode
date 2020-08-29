package leetcode.algorithms;

/**
 * Description: 214. Shortest Palindrome
 *
 * @author Baltan
 * @date 2019-06-08 10:15
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
        System.out.println(shortestPalindrome("abcba"));
        System.out.println(shortestPalindrome("abcbbcba"));
        System.out.println(shortestPalindrome(""));
        System.out.println(shortestPalindrome("a"));
        System.out.println(shortestPalindrome("aa"));
        System.out.println(shortestPalindrome("ab"));
    }

    public static String shortestPalindrome(String s) {
        /**
         * 如果s是空字符串或者只包含一个字符，则s本身就是回文字符串，直接返回即可
         */
        if (s.length() < 2) {
            return s;
        }
        /**
         * 可能得到的最长回文字符串就是将s翻转后再拼接上s自身
         */
        String result = new StringBuilder(s).reverse().append(s).toString();
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * 以一个字符作为轴的回文字符串的情况，因为只能在s前面添加字符，所以轴只可能在length/2的索引位置或者该
         * 位置之前
         */
        for (int axis = length / 2; axis >= 0; axis--) {
            int lo = axis - 1;
            int hi = axis + 1;

            while (lo >= 0 && hi < length && charArray[lo] == charArray[hi]) {
                lo--;
                hi++;
            }
            /**
             * 如果前半部分的所有字符，都在后半部分找到了对称位置的字符，则将后半部分剩余的字符翻转添加到s前面
             * 即可，并且不需要再继续查找，因为后面得到的回文字符串一定更长
             */
            if (lo == -1) {
                String s1 = new StringBuilder(s.substring(hi)).reverse().append(s).toString();
                /**
                 * 如果得到的回文字符串比result短，就更新result
                 */
                result = s1.length() < result.length() ? s1 : result;
                break;
            }
        }
        /**
         * 以两个字符作为轴的回文字符串的情况，因为只能在s前面添加字符，所以轴只可能在(length-1)/2的索引位置
         * 或者该位置之前
         */
        for (int axis = (length - 1) / 2; axis >= 0; axis--) {
            /**
             * 只有当两个相邻的字符相等时才能作为回文字符串的轴
             */
            if (charArray[axis] == charArray[axis + 1]) {
                int lo = axis - 1;
                int hi = axis + 2;

                while (lo >= 0 && hi < length && charArray[lo] == charArray[hi]) {
                    lo--;
                    hi++;
                }
                /**
                 * 如果前半部分的所有字符，都在后半部分找到了对称位置的字符，则将后半部分剩余的字符翻转添加到
                 * s前面即可，并且不需要再继续查找，因为后面得到的回文字符串一定更长
                 */
                if (lo == -1) {
                    String s2 = new StringBuilder(s.substring(hi)).reverse().append(s).toString();
                    /**
                     * 如果得到的回文字符串比result短，就更新result
                     */
                    result = s2.length() < result.length() ? s2 : result;
                    break;
                }
            }
        }
        return result;
    }
}
