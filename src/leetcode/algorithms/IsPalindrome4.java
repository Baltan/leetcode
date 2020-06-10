package leetcode.algorithms;

/**
 * Description: 9. Palindrome Number
 *
 * @author Baltan
 * @date 2020-06-10 08:08
 * @see IsPalindrome1
 */
public class IsPalindrome4 {
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
        /**
         * 将x的原始值保存给y
         */
        int y = x;
        /**
         * 将x翻转后得到的数字
         */
        int reverse = 0;
        /**
         * 计算x翻转后得到的数字
         */
        while (x > 0) {
            int remainder = x % 10;
            reverse = reverse * 10 + remainder;
            x /= 10;
        }
        return reverse == y;
    }
}
