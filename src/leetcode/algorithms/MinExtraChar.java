package leetcode.algorithms;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description: 2707. Extra Characters in a String
 *
 * @author Baltan
 * @date 2023/5/28 14:28
 */
public class MinExtraChar {
    public static void main(String[] args) {
        System.out.println(minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
        System.out.println(minExtraChar("sayhelloworld", new String[]{"hello", "world"}));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        Set<String> words = Arrays.stream(dictionary).collect(Collectors.toSet());
        int length = s.length();
        /**
         * dp[i][j]表示s.substring(i,j)按照题意分割，剩下字符的最小数量，所求即为dp[0][length]
         */
        int[][] dp = new int[length + 1][length + 1];
        /**
         * 判断字符串s的所有长度为1的子串按照题意分割，剩下字符的最小数量，即判断子串是否在字典中存在
         */
        for (int i = 0; i < length; i++) {
            dp[i][i + 1] = words.contains(s.substring(i, i + 1)) ? 0 : 1;
        }
        /**
         * 依次判断字符串s的所有长度为i的子串按照题意分割，剩下字符的最小数量
         */
        for (int i = 2; i <= length; i++) {
            /**
             * j表示当前要判断的子串的起始索引
             */
            for (int j = 0; j + i <= length; j++) {
                /**
                 * 当前子串在字典中存在，所以剩下字符的最小数量为0
                 */
                if (words.contains(s.substring(j, j + i))) {
                    continue;
                }
                dp[j][j + i] = Integer.MAX_VALUE;
                /**
                 * 将子串分成两部分，一部分长度为k，另一部分长度为i-k，两部分子串各自按照题意分割后剩下字符的最小数量之和即为当前子串按照题
                 * 意分割后的剩下字符的最小数量
                 */
                for (int k = 1; k < i; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][j + k] + dp[j + k][j + i]);
                }
            }
        }
        return dp[0][length];
    }
}
