package leetcode.algorithms;

/**
 * Description: 1616. Split Two Strings to Make Palindrome
 *
 * @author Baltan
 * @date 2022/10/4 12:37
 */
public class CheckPalindromeFormation {
    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
        System.out.println(checkPalindromeFormation("x", "y"));
        System.out.println(checkPalindromeFormation("abdef", "fecab"));
        System.out.println(checkPalindromeFormation("ulacfd", "jizalu"));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/split-two-strings-to-make-palindrome/solution/split-two-strings-to-make-palindrome-by-ikaruga/"></a>
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean checkPalindromeFormation(String a, String b) {
        /**
         * 当字符串长度为1时，一定可以分割成""+a和""+b，从而得到回文字符串""+b或""+a
         */
        if (a.length() == 1) {
            return true;
        }
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        /**
         * 判断字符串a的前缀和b的后缀能否拼接在一起构成回文字符串
         */
        if (help(charsA, charsB)) {
            return true;
        }
        /**
         * 判断字符串b的前缀和a的后缀能否拼接在一起构成回文字符串
         */
        return help(charsB, charsA);
    }

    /**
     * 判断字符串x的前缀和y的后缀能否拼接在一起构成回文字符串。如果可以构成回文字符串，结构一定在如下四种情况之一：
     * 1、字符串x长度为m的前缀+字符串x长度为length-2*m的中间部分的子串+字符串y长度为m的后缀
     * 2、字符串x长度为m的前缀+字符串y长度为length-2*m的中间部分的子串+字符串y长度为m的后缀
     * 3、字符串y长度为m的前缀+字符串x长度为length-2*m的中间部分的子串+字符串x长度为m的后缀
     * 4、字符串y长度为m的前缀+字符串x长度为length-2*m的中间部分的子串+字符串x长度为m的后缀
     * 其中，中间部分的子串本身为一个回文字符串
     *
     * @param charsX
     * @param charsY
     * @return
     */
    public static boolean help(char[] charsX, char[] charsY) {
        int length = charsX.length;
        int hi = length / 2;
        int lo = length % 2 == 0 ? hi - 1 : hi;
        /**
         * charsX[lo]和charsX[hi]、charsX[lo-1]和charsX[hi+1]、……、charsX[0]和charsX[length-1]逐一成对比较
         */
        while (lo >= 0 && hi < length && charsX[lo] == charsX[hi]) {
            lo--;
            hi++;
        }
        return isPalindrome(charsX, charsY, lo, hi) || isPalindrome(charsY, charsX, lo, hi);
    }

    /**
     * 判断字符串x的前缀子串x.substring(0,lo+1)和字符串y的后缀子串y.substring(hi,length)拼接在一起是否构成回文字符串
     *
     * @param charsX
     * @param charsY
     * @param lo
     * @param hi
     * @return
     */
    public static boolean isPalindrome(char[] charsX, char[] charsY, int lo, int hi) {
        int length = charsX.length;
        /**
         * charsX[lo]和charsY[hi]、charsX[lo-1]和charsY[hi+1]、……、charsX[0]和charsY[length-1]逐一成对比较
         */
        while (lo >= 0 && hi < length && charsX[lo] == charsY[hi]) {
            lo--;
            hi++;
        }
        return hi == length;
    }
}
