package leetcode.interview;

import java.util.Objects;

/**
 * Description: 面试题 01.09. 字符串轮转
 *
 * @author Baltan
 * @date 2020-03-11 22:22
 * @see IsFlipedString1
 */
public class IsFlipedString {
    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(isFlipedString("aa", "aba"));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (Objects.equals(s1, s2)) {
            return true;
        }

        int length = s1.length();
        String tail = "";
        /**
         * 逐一判断s2尾部的子串是否和s1头部的子串相等，如果相等的话比较两个字符串剩余部分发子串，如果相等则s2
         * 可以由s1旋转得到，否则则不行
         */
        for (int i = length - 1; i >= 0; i--) {
            tail = s2.charAt(i) + tail;

            if (s1.startsWith(tail)) {
                int tailLength = tail.length();
                return Objects.equals(s1.substring(tailLength), s2.substring(0, length - tailLength));
            }
        }
        return false;
    }
}
