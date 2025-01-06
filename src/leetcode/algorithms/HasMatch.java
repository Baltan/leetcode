package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 3407. Substring Matching Pattern
 *
 * @author Baltan
 * @date 2025/1/6 23:42
 */
public class HasMatch {
    public static void main(String[] args) {
        System.out.println(hasMatch("l", "*"));
        System.out.println(hasMatch("leetcode", "ee*e"));
        System.out.println(hasMatch("car", "c*v"));
        System.out.println(hasMatch("luck", "u*"));
    }

    public static boolean hasMatch(String s, String p) {
        if (Objects.equals(p, "*")) {
            return true;
        }
        String[] parts = p.split("\\*");
        /**
         * parts的长度为1，说明字符串p中"*"在头部或尾部，只需判断剩余部分是否是字符串s的子串
         */
        if (parts.length == 1) {
            return s.contains(parts[0]);
        }
        int index1 = s.indexOf(parts[0]);
        int index2 = s.lastIndexOf(parts[1]);
        /**
         * 如果字符串p能变换为字符串s的子串，则字符串s中一定包含一个子串的构成形式为parts[0]+任意字符串str+parts[1]，即字符串s中必须同时
         * 包含子串parts[0]和parts[1]，并且parts[0]的最后一个字符的索引值小于parts[1]的第一个字符的索引值
         */
        return index1 != -1 && index2 != -1 && index1 + parts[0].length() <= index2;
    }
}
