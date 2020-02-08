package leetcode.algorithms;

/**
 * Description: 1332. Remove Palindromic Subsequences
 *
 * @author Baltan
 * @date 2020-02-08 13:57
 */
public class RemovePalindromeSub {
    public static void main(String[] args) {
        System.out.println(removePalindromeSub("ababa"));
        System.out.println(removePalindromeSub("abb"));
        System.out.println(removePalindromeSub("baabb"));
        System.out.println(removePalindromeSub(""));
    }

    public static int removePalindromeSub(String s) {
        /**
         * 如果字符串s为空字符串，不用进行删除操作；如果s本身为回文字符串，将s直接删除即可；如果s不是
         * 回文字符串，第一次删除所有a构成的子序列，第二次删除所有b构成的子序列，两次删除操作即可
         */
        if (s.length() == 0) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * 判断字符串s是否是回文字符串
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
