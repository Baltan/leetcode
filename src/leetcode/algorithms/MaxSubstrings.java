package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3557. Find Maximum Number of Non Intersecting Substrings
 *
 * @author Baltan
 * @date 2025/6/8 15:22
 */
public class MaxSubstrings {
    public static void main(String[] args) {
        System.out.println(maxSubstrings("abcdeafdef"));
        System.out.println(maxSubstrings("bcdaaaab"));
    }

    public static int maxSubstrings(String word) {
        int length = word.length();
        /**
         * dp1[i]表示前缀子串word.substring(0,i)中不相交子字符串的最大数量，并且word[i-1]不包含在不相交子字符串中
         */
        int[] dp1 = new int[length + 1];
        /**
         * dp2[i]表示前缀子串word.substring(0,i)中不相交子字符串的最大数量，并且word[i-1]包含在不相交子字符串中
         */
        int[] dp2 = new int[length + 1];
        /**
         * indexesList[0]-indexesList[25]依次升序保存word的前缀子串中字符a-z出现的索引位置
         */
        List<Integer>[] indexesList = new List[26];
        Arrays.setAll(indexesList, i -> new ArrayList<>());

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            /**
             * 如果字符c不包含在不相交子字符串中，则前缀子串word.substring(0,i)中不相交子字符串的最大数量等于word.substring(0,i-1)中
             * 不相交子字符串的最大数量
             */
            dp1[i + 1] = Math.max(dp1[i], dp2[i]);
            List<Integer> indexes = indexesList[c - 'a'];
            /**
             * 倒序遍历之前word的前缀子串中字符c出现的索引值，选择可以和当前字符c构成不相交子字符串的索引值最大的字符
             */
            for (int j = indexes.size() - 1; j >= 0; j--) {
                if (i - indexes.get(j) + 1 >= 4) {
                    /**
                     * 子串word.substring(j,i+1)构成一个不相交子字符串，另外需要再加上前缀子串word.substring(0,j)中不相交子字符串的
                     * 最大数量
                     */
                    dp2[i + 1] = Math.max(dp1[indexes.get(j)], dp2[indexes.get(j)]) + 1;
                    break;
                }
            }
            indexes.add(i);
        }
        return Math.max(dp1[length], dp2[length]);
    }
}
