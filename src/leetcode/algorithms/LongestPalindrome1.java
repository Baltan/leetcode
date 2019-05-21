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
        System.out.println(longestPalindrome(null));
    }

    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.equals("")) {
            return "";
        }
        int thisPalindromeLength;
        int sLength = s.length();
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int evenLength = 0;
            int evenOffset = 0;
            while (i - evenOffset >= 0 && i + 1 + evenOffset <= sLength - 1 &&
                    s.charAt(i - evenOffset) == s.charAt(i + 1 + evenOffset)) {
                evenLength += 2;
                evenOffset++;
            }
            int oddLength = 1;
            int oddOffset = 1;
            while (i - oddOffset >= 0 && i + oddOffset <= sLength - 1 &&
                    s.charAt(i - oddOffset) == s.charAt(i + oddOffset)) {
                oddLength += 2;
                oddOffset++;
            }
            thisPalindromeLength = evenLength > oddLength ? evenLength : oddLength;
            if (thisPalindromeLength > endIndex - startIndex) {
                startIndex = i - (thisPalindromeLength - 1) / 2;
                endIndex = i + thisPalindromeLength / 2;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
}
