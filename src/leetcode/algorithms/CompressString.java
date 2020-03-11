package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 面试题 01.06. 字符串压缩
 *
 * @author Baltan
 * @date 2020-03-11 17:31
 */
public class CompressString {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abbccd"));
        System.out.println(compressString("csscjcbskjnslcnslssjsdcsjjjdshdsshdsjchskdbj"));
        System.out.println(compressString("cddddddhhhhhsssssjjjjjjssssss"));
        System.out.println(compressString("sssskkkkkihs"));
        System.out.println(compressString("dcSDCDcskcsCSSsssSSS"));
        System.out.println(compressString("bb"));
    }

    public static String compressString(String S) {
        if (Objects.equals(S, "")) {
            return S;
        }

        StringBuilder builder = new StringBuilder();
        /**
         * 在S最后多补充一个字符，当遍历到这个补充的字符的时候，S原本最后一个字符也能被压缩了
         */
        String otherS = S + " ";
        int length = otherS.length();
        /**
         * 当前遍历重复的字符
         */
        char repeatedChar = otherS.charAt(0);
        /**
         * 当前遍历重复字符的数量
         */
        int repeatedCount = 1;

        for (int i = 1; i < length; i++) {
            char c = otherS.charAt(i);

            if (c != repeatedChar) {
                builder.append(repeatedChar).append(repeatedCount);
                /**
                 * 修改当前遍历重复的字符和重复字符的数量
                 */
                repeatedChar = c;
                repeatedCount = 1;
            } else {
                repeatedCount++;
            }
        }
        return builder.length() < S.length() ? builder.toString() : S;
    }
}
