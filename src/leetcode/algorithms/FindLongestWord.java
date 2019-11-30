package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 524. Longest Word in Dictionary through Deleting
 *
 * @author Baltan
 * @date 2019-11-30 08:58
 */
public class FindLongestWord {
    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        System.out.println(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
    }

    public static String findLongestWord(String s, List<String> d) {
        String result = "";

        for (String word : d) {
            if (isSubstring(word, s)) {
                /**
                 * 如果当前字符串符合条件并且长度更长，更新结果
                 */
                if (word.length() > result.length()) {
                    result = word;
                    /**
                     * 如果当前字符串符合条件并且长度一样，取字典顺序较小的字符串
                     */
                } else if (word.length() == result.length()) {
                    result = result.compareTo(word) >= 0 ? word : result;
                }
            }
        }
        return result;
    }

    /**
     * 判断字符串word是否可以通过删除字符串s中的某些字符得到
     *
     * @param word
     * @param s
     * @return
     */
    public static boolean isSubstring(String word, String s) {
        int index = 0;
        int length = s.length();

        for (char c : word.toCharArray()) {
            /**
             * 能否在s中找到word中当前的字符c
             */
            boolean find = false;

            for (int i = index; i < length; i++) {
                if (s.charAt(i) == c) {
                    /**
                     * 查找word的下一个字符时，要从当前s位置的下一个位置开始找
                     */
                    index = i + 1;
                    find = true;
                    break;
                }
            }
            /**
             * 如果s中找不到word中当前的字符c，说明字符串word无法通过删除字符串s中的某些字符得到
             */
            if (!find) {
                return false;
            }
        }
        return true;
    }
}
