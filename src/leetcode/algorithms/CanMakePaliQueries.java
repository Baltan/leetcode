package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1177. Can Make Palindrome from Substring
 *
 * @author Baltan
 * @date 2020-03-06 12:51
 */
public class CanMakePaliQueries {
    public static void main(String[] args) {
        int[][] queries1 = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        System.out.println(canMakePaliQueries("abcda", queries1));
    }

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new LinkedList<>();
        int length = s.length();
        /**
         * prefix[i]为s.substring(0,i)中各个字母出现的次数统计
         */
        int[][] prefix = new int[length + 1][26];

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            for (int j = 0; j < 26; j++) {
                prefix[i + 1][j] = c - 'a' == j ? prefix[i][j] + 1 : prefix[i][j];
            }
        }

        for (int[] query : queries) {
            int firstIndex = query[0];
            int lastIndex = query[1];
            /**
             * 当前子串的长度
             */
            int substringLength = lastIndex - firstIndex + 1;

            for (int i = 0; i < 26; i++) {
                /**
                 * 当前子串中某一字母出现的次数
                 */
                int count = prefix[lastIndex + 1][i] - prefix[firstIndex][i];
                /**
                 * 如果某一字母出现了count次，则这count个字母可以构成count/2对字符对，则回文
                 * 子串的substringLength个位置中的count/2*2个位置已经可以构成回文
                 */
                substringLength -= count / 2 * 2;
            }
            /**
             * 剩余的substringLength个位置需要通过替换字符来构成回文，至少需要替换
             * substringLength/2个字符，只要该值不大于query[2]即可
             */
            result.add(substringLength / 2 <= query[2]);
        }
        return result;
    }
}
