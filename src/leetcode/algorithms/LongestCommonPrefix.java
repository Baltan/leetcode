package leetcode.algorithms;

/**
 * Description: 14. Longest Common Prefix
 *
 * @author Baltan
 * @date 2017/11/27 15:33
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs1 = {"abcdef", "abcde", "abcdk", "abc"};
        String[] strs2 = {"abcdef", "abcde", "abcdk", "abbbbbb"};
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        int length = strs.length;
        /**
         * 将strs中的第一个单词作为比较的标准
         */
        String first = strs[0];
        /**
         * first中字母的索引位置
         */
        int index = 0;

        while (index < first.length()) {
            char c = first.charAt(index);

            for (int i = 1; i < length; i++) {
                /**
                 * 如果当前单词的长度比first短，或者当前单词索引位置为index的字母和first索引位置为index
                 * 的字母不一致，则可以结束公共前缀的查找
                 */
                if (strs[i].length() == index || strs[i].charAt(index) != c) {
                    return builder.toString();
                }
            }
            index++;
            builder.append(c);
        }
        return builder.toString();
    }
}
