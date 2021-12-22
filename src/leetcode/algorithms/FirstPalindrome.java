package leetcode.algorithms;

/**
 * Description: 2108. Find First Palindromic String in the Array
 *
 * @author Baltan
 * @date 2021/12/22 09:07
 */
public class FirstPalindrome {
    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}));
        System.out.println(firstPalindrome(new String[]{"notapalindrome", "racecar"}));
        System.out.println(firstPalindrome(new String[]{"def", "ghi"}));
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindromic(word)) {
                return word;
            }
        }
        return "";
    }

    /**
     * 判断字符串word是否是回文字符串
     *
     * @param word
     * @return
     */
    public static boolean isPalindromic(String word) {
        char[] charArray = word.toCharArray();
        int lo = 0;
        int hi = charArray.length - 1;

        while (lo < hi) {
            if (charArray[lo] != charArray[hi]) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
