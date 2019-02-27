package leetcode.algorithms;

/**
 * Description:Largest Palindrome Product
 *
 * @author Baltan
 * @date 2018/1/10 11:29
 */
public class LargestPalindrome {
    public static void main(String[] args) {
        System.out.println(largestPalindrome(2));
        System.out.println(largestPalindrome(5));
    }

    public static int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        //回文数的前半部分数字上限，同时也是n位数的上限
        int firstHalfTopLimit = (int) (Math.pow(10, n) - 1);
        //回文数的前半部分数字下限，同时也是n位数的下限
        int firstHalfBottomLimit = (int) Math.pow(10, n - 1);
        for (int i = firstHalfTopLimit; i >= firstHalfBottomLimit; i--) {
            String secondHalf = new StringBuilder(String.valueOf(i)).reverse().toString();
            String palindromeString = i + secondHalf;
            long palindromeNum = Long.valueOf(palindromeString);
            for (int j = firstHalfTopLimit; j >= firstHalfBottomLimit; j--) {
                if (palindromeNum / j > firstHalfTopLimit) {
                    break;
                }
                if (palindromeNum % j == 0) {
                    return (int) (palindromeNum % 1337);
                }
            }
        }
        return -1;
    }
}
