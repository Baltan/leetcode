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
        System.out.println(isPalindrome(".,"));
    }

    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int lo = 0;
        int hi = length - 1;

        while (lo < hi) {
            /**
             * 从低位向高位找到第一个字母或数字
             */
            while (lo < length && !Character.isAlphabetic(charArray[lo]) &&
                    !Character.isDigit(charArray[lo])) {
                lo++;
            }
            /**
             * 从高位向低位找到第一个字母或数字
             */
            while (hi >= 0 && !Character.isAlphabetic(charArray[hi]) && !Character.isDigit(charArray[hi])) {
                hi--;
            }
            /**
             * 如果低位和高位上都没有数字或字母了，直接返回true
             */
            if (lo >= length && hi < 0) {
                return true;
            }
            /**
             * 如果低位和高位上一边有数字或字母，另一边没有，直接返回false
             */
            if (lo >= length || hi < 0) {
                return false;
            }
            /**
             * 如果找到的是字母，转为小写字母
             */
            if (Character.isAlphabetic(charArray[lo])) {
                charArray[lo] = Character.toLowerCase(charArray[lo]);
            }
            /**
             * 如果找到的是字母，转为小写字母
             */
            if (Character.isAlphabetic(charArray[hi])) {
                charArray[hi] = Character.toLowerCase(charArray[hi]);
            }

            if (charArray[lo] != charArray[hi]) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
