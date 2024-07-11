package leetcode.algorithms;

/**
 * Description: 3210. Find the Encrypted String
 *
 * @author Baltan
 * @date 2024/7/11 23:00
 */
public class GetEncryptedString {
    public static void main(String[] args) {
        System.out.println(getEncryptedString("dart", 3));
        System.out.println(getEncryptedString("aaa", 1));
        System.out.println(getEncryptedString("x", 5));
    }

    public static String getEncryptedString(String s, int k) {
        int remainder = k % s.length();
        /**
         * 字符串s头部的remainder个字符会按顺序移动到尾部
         */
        return s.substring(remainder) + s.substring(0, remainder);
    }
}
