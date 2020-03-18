package leetcode.algorithms;

/**
 * Description: 409. Longest Palindrome
 *
 * @author Baltan
 * @date 2018/1/4 10:58
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }

    public static int longestPalindrome(String s) {
        int result = 0;
        /**
         * 对字符串中各个英文字母的出现次数计数
         */
        int[] count = new int['z' - 'A' + 1];
        int length = s.length();
        /**
         * 字符串中是否有出现奇数次的字母
         */
        boolean oddCount = false;

        for (int i = 0; i < length; i++) {
            count[s.charAt(i) - 'A']++;
        }
        /**
         * 在回文字符串中，除了正中间可能出现单独一个字母，其他字母都是首尾两两对应的，即最多只有一个字母
         * 可以出现奇数次。
         */
        for (int value : count) {
            if ((value & 1) == 1) {
                result += value - 1;
                oddCount = true;
            } else {
                result += value;
            }
        }
        /**
         * 如果有出现奇数次的字母，可以将该字母作为回文字符串正中间的字母
         */
        return oddCount ? result + 1 : result;
    }
}
