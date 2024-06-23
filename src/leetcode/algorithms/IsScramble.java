package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 87. Scramble String
 *
 * @author Baltan
 * @date 2024/6/23 14:22
 */
public class IsScramble {
    public static void main(String[] args) {
        System.out.println(isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));
        System.out.println(isScramble("abb", "bba"));
        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScramble("abcde", "caebd"));
        System.out.println(isScramble("a", "a"));
        System.out.println(isScramble("a", "b"));
        System.out.println(isScramble("ab", "ba"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/scramble-string/solutions/51990/miao-dong-de-qu-jian-xing-dpsi-lu-by-sha-yu-la-jia/"></a>
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isScramble(String s1, String s2) {
        if (Objects.equals(s1, s2)) {
            return true;
        }
        /**
         * 如果字符串s1和s2长度不等，则不可能互为扰乱字符串
         */
        if (s1.length() != s2.length()) {
            return false;
        }
        int length = s1.length();
        /**
         * dp[i][j][l]表示子串s1.substring(i,i+l)和s2.substring(j,j+l)是否互为扰乱字符串，题目所求即为dp[0][0][length]
         */
        boolean[][][] dp = new boolean[length][length][length + 1];
        /**
         * 初始化子串长度为1的情况
         */
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        /**
         * l表示两个子串的长度
         */
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i + l <= length; i++) {
                for (int j = 0; j + l <= length; j++) {
                    /**
                     * 判断子串s1.substring(i,i+l)和s2.substring(j,j+l)是否互为扰乱字符串
                     */
                    for (int k = 1; k <= l - 1; k++) {
                        /**
                         * 假设子串s1.substring(i,i+l)被进一步分割为s1.substring(i,i+k)和s1.substring(i+k,i+l)两部分，子串
                         * s2.substring(j,j+l)被进一步分割为s2.substring(j,j+k)和s2.substring(j+k,j+l)两部分。如果子串
                         * s1.substring(i,i+k)和s2.substring(j,j+k)互为扰乱字符串，并且子串s1.substring(i+k,i+l)和
                         * s2.substring(j+k,j+l)互为扰乱字符串，则子串s1.substring(i,i+l)和s2.substring(j,j+l)互为扰乱字符串
                         */
                        if (dp[i][j][k] && dp[i + k][j + k][l - k]) {
                            dp[i][j][l] = true;
                            break;
                        }
                        /**
                         * 假设子串s1.substring(i,i+l)被进一步分割为s1.substring(i,i+k)和s1.substring(i+k,i+l)两部分，子串
                         * s2.substring(j,j+l)被进一步分割为s2.substring(j,j+l-k)和s2.substring(j+l-k,j+l)两部分。如果子串
                         * s1.substring(i,i+k)和s2.substring(j+l-k,j+l)互为扰乱字符串，并且子串s1.substring(i+k,i+l)和
                         * s2.substring(j,j+l-k)互为扰乱字符串，则子串s1.substring(i,i+l)和s2.substring(j,j+l)互为扰乱字符串
                         */
                        if (dp[i][j + l - k][k] && dp[i + k][j][l - k]) {
                            dp[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][length];
    }
}
