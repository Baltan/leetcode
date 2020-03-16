package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 面试题 08.07. 无重复字符串的排列组合
 *
 * @author Baltan
 * @date 2020-03-16 13:29
 * @see leetcode.algorithms.Permute
 * @see leetcode.algorithms.PermuteUnique
 * @see Permutation1
 */
public class Permutation {
    public static void main(String[] args) {
        OutputUtils.print1DStringArray(permutation("qwe"));
        OutputUtils.print1DStringArray(permutation("ab"));
    }

    public static String[] permutation(String S) {
        List<String> result = new LinkedList<>();
        List<Character> chars = new ArrayList<>(S.length());
        int length = S.length();

        for (int i = 0; i < length; i++) {
            chars.add(S.charAt(i));
        }
        dfs(result, chars, new StringBuilder());
        return result.toArray(new String[0]);
    }

    public static void dfs(List<String> result, List<Character> chars, StringBuilder builder) {
        /**
         * 如果chars中没有字符可以再拼接到builder中了，说明所有字符已经完成一组排列，将这个排列加入result
         */
        if (chars.isEmpty()) {
            result.add(builder.toString());
        }
        /**
         * 考虑以每个字符开头的所有排列
         */
        for (int i = 0; i < chars.size(); i++) {
            char c = chars.get(i);
            builder.append(c);
            /**
             * 当前字符在递归查找其他字符的所有排列的过程中不会再出现，暂时从chars中移除
             */
            chars.remove(i);
            dfs(result, chars, builder);
            /**
             * 还原chars到初始状态
             */
            chars.add(i, c);
            /**
             * 还原builder到初始状态
             */
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
