package leetcode.algorithms;

/**
 * Description: 2697. Lexicographically Smallest Palindrome
 *
 * @author Baltan
 * @date 2023/5/21 22:39
 */
public class MakeSmallestPalindrome {
    public static void main(String[] args) {
        System.out.println(makeSmallestPalindrome("egcfe"));
        System.out.println(makeSmallestPalindrome("abcd"));
        System.out.println(makeSmallestPalindrome("seven"));
    }

    public static String makeSmallestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int lo = 0;
        int hi = charArray.length - 1;
        /**
         * 将字符串s中首尾对称的两个字符都修改为其中字典顺序较小的字符
         */
        while (lo < hi) {
            if (charArray[lo] < charArray[hi]) {
                charArray[hi] = charArray[lo];
            } else if (charArray[lo] > charArray[hi]) {
                charArray[lo] = charArray[hi];
            }
            lo++;
            hi--;
        }
        return new String(charArray);
    }
}
