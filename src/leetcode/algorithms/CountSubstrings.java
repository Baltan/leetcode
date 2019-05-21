package leetcode.algorithms;

/**
 * Description: 647. Palindromic Substrings
 *
 * @author Baltan
 * @date 2018/1/11 14:35
 */
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int palindromeNum = 0;
        for (int i = 0; i < s.length(); i++) {
            int extendNum = 0;
            while (i - extendNum >= 0 && i + extendNum < s.length()) {
                if (s.substring(i - extendNum, i - extendNum + 1).equals(s.substring(i + extendNum, i + extendNum + 1))) {
                    palindromeNum++;
                    extendNum++;
                } else {
                    break;
                }
            }
            extendNum = 0;
            while (i - extendNum >= 0 &&
                    i + 1 + extendNum < s.length() && s.substring(i, i + 1).equals(s.substring(i + 1, i + 2))) {
                if (s.substring(i - extendNum, i - extendNum + 1).equals(s.substring(i + 1 + extendNum, i + 2 + extendNum))) {
                    palindromeNum++;
                    extendNum++;
                } else {
                    break;
                }
            }
        }
        return palindromeNum;
    }
}
