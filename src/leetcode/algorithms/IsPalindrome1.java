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
        if (x < 0) {
            return false;
        }
        int y = x;
        int n = 0;
        while (y > 0) {
            y /= 10;
            n++;
        }
        int temp = 0;
        while (temp < (n + 1) / 2) {
            int tailNum = (int) (x % Math.pow(10, temp + 1) / Math.pow(10, temp));
            int headNum = (int) (x % Math.pow(10, n - temp) / Math.pow(10, n - 1 - temp));
            if (tailNum != headNum) {
                return false;
            }
            temp++;
        }
        return true;
    }
}
