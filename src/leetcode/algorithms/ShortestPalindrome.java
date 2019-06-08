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
    }

    public static String shortestPalindrome(String s) {
        int length = s.length();
        int lo = 0;
        int hi = length - 1;

        while (hi >= lo) {
            if (isPalindrome(s, lo, hi)) {
                int offset = length - 1 - hi;
                StringBuilder builder = new StringBuilder(s);

                for (int i = 1; i <= offset; i++) {
                    builder.insert(0, s.charAt(hi + i));
                }
                return builder.toString();
            }
            hi--;
        }
        return "";
    }

    public static boolean isPalindrome(String s, int lo, int hi) {
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
