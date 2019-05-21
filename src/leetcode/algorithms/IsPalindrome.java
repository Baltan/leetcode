package leetcode.algorithms;

/**
 * Description: 125. Valid Palindrome
 *
 * @author Baltan
 * @date 2017/11/27 14:45
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            int startCharValue = s.charAt(start);
            int endCharValue = s.charAt(end);
            boolean startCharIsNotDigitOrLetter =
                    !(startCharValue >= 48 && startCharValue <= 57) && !(startCharValue >= 65 && startCharValue <= 90) &&
                            !(startCharValue >= 97 && startCharValue <= 122);
            boolean endCharIsNotDigitOrLetter =
                    !(endCharValue >= 48 && endCharValue <= 57) && !(endCharValue >= 65 && endCharValue <= 90) &&
                            !(endCharValue >= 97 && endCharValue <= 122);
            boolean startCharIsDigit = startCharValue >= 48 && startCharValue <= 57;
            boolean endCharIsDigit = endCharValue >= 48 && endCharValue <= 57;
            boolean startCharIsLetter =
                    (startCharValue >= 65 && startCharValue <= 90 || startCharValue >= 97 && startCharValue <= 122);
            boolean endCharIsLetter = (endCharValue >= 65 && endCharValue <= 90 || endCharValue >= 97 && endCharValue <= 122);
            if (startCharIsNotDigitOrLetter) {
                start++;
                continue;
            }
            if (endCharIsNotDigitOrLetter) {
                end--;
                continue;
            }
            if (startCharIsDigit && endCharIsDigit) {
                if (s.substring(start, start + 1).equals(s.substring(end, end + 1))) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            } else if (startCharIsLetter && endCharIsLetter) {
                if (s.substring(start, start + 1).equalsIgnoreCase(s.substring(end, end + 1))) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
