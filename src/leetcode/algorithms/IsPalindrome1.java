package leetcode.algorithms;

/**
 * Description: 9. Palindrome Number
 *
 * @author Baltan
 * @date 2018/1/6 21:50
 */
public class IsPalindrome1 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12331));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(1231));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        char[] charArray = String.valueOf(x).toCharArray();
        int lo = 0;
        int hi = charArray.length - 1;
        /**
         * 将x转为字符串后判断是否是回文字符串
         */
        while (lo < hi) {
            if (charArray[lo++] != charArray[hi--]) {
                return false;
            }
        }
        return true;
    }
}
