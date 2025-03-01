package leetcode.algorithms;

/**
 * Description: 3456. Find Special Substring of Length K
 *
 * @author Baltan
 * @date 2025/2/27 23:30
 */
public class HasSpecialSubstring {
    public static void main(String[] args) {
        System.out.println(hasSpecialSubstring("aaabaaa", 3));
        System.out.println(hasSpecialSubstring("abc", 2));
    }

    public static boolean hasSpecialSubstring(String s, int k) {
        /**
         * 当前字符的前一个字符
         */
        char prev = ' ';
        /**
         * 字符prev连续出现的次数
         */
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            } else if (count == k) {
                return true;
            } else {
                count = 1;
                prev = c;
            }
        }
        /**
         * 判断字符串s尾部的子串是否是特殊子字符串
         */
        return count == k;
    }
}
