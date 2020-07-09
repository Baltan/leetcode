package leetcode.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 面试题 17.13. 恢复空格
 *
 * @author Baltan
 * @date 2020-07-09 10:10
 */
public class Respace {
    public static void main(String[] args) {
        System.out.println(respace(new String[]{"looked", "just", "like", "her", "brother"},
                "jesslookedjustliketimherbrother"));
        System.out.println(respace(new String[]{"mztt", "ui", "tial"}, ""));
    }

    public static int respace(String[] dictionary, String sentence) {
        if (sentence.length() == 0) {
            return 0;
        }

        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        char[] charArray = sentence.toCharArray();
        int length = charArray.length;
        /**
         * dp[i]表示sentence前i个字符连成的子串当中未识别的字符数
         */
        int[] dp = new int[length + 1];
        dp[1] = dictionarySet.contains(new String(charArray, 0, 1)) ? 0 : 1;

        for (int i = 2; i <= length; i++) {
            /**
             * sentence前i个字符连成的子串中至多只有i个未识别的字符数
             */
            dp[i] = i;
            /**
             * 以sentence的第i个字符作为最后一个字符的子串的长度，最短为1，最长为i
             */
            for (int j = 1; j <= i; j++) {
                /**
                 * 以sentence的第i个字符作为最后一个字符的子串
                 */
                String s = new String(charArray, i - j, j);
                /**
                 * 如果dictionarySet不包含s，则dp[i]要在dp[i-j]的基础上再增加j个未识别的字符，否则不增加未识别的
                 * 字符
                 */
                dp[i] = Math.min(dp[i], dp[i - j] + (dictionarySet.contains(s) ? 0 : j));
            }
        }
        return dp[length];
    }
}
