package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1961. Check If String Is a Prefix of Array
 *
 * @author Baltan
 * @date 2022/2/5 09:57
 */
public class IsPrefixString {
    public static void main(String[] args) {
        System.out.println(isPrefixString("iloveleetcode", new String[]{"i", "love", "leetcode", "apples"}));
        System.out.println(isPrefixString("iloveleetcode", new String[]{"apples", "i", "love", "leetcode"}));
    }

    public static boolean isPrefixString(String s, String[] words) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        /**
         * 将words的前若干个字符串拼接在一起，直到总长度不小于字符串s的长度，或者words中的所有字符串都已参与拼接
         */
        while (builder.length() < s.length() && index < words.length) {
            builder.append(words[index++]);
        }
        return Objects.equals(builder.toString(), s);
    }
}
