package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2767. Partition String Into Minimum Beautiful Substrings
 *
 * @author Baltan
 * @date 2023/7/9 17:19
 */
public class MinimumBeautifulSubstrings {
    public static void main(String[] args) {
        System.out.println(minimumBeautifulSubstrings("101101111101"));
        System.out.println(minimumBeautifulSubstrings("100111000110111"));
        System.out.println(minimumBeautifulSubstrings("1011"));
        System.out.println(minimumBeautifulSubstrings("111"));
        System.out.println(minimumBeautifulSubstrings("0"));
    }

    public static int minimumBeautifulSubstrings(String s) {
        /**
         * 如果字符串s有前导0，则不符合第一个条件，s一定不是美丽字符串
         */
        if (s.charAt(0) == '0') {
            return -1;
        }
        int length = s.length();
        int power = 1;
        int limit = (1 << 16) - 1;
        /**
         * 根据题意，字符串s所表示二进制数字的十进制值最大为(1<<16)-1
         */
        Set<Integer> powers = new HashSet<>();
        /**
         * values[i][j]表示s.substring(i,j)所表示二进制数字的十进制值
         */
        int[][] values = new int[length + 1][length + 1];
        /**
         * dp[i][j]表示s.substring(i,j)最少可以分割成的美丽字符串个数
         */
        int[][] dp = new int[length + 1][length + 1];

        while (power <= limit) {
            powers.add(power);
            power *= 5;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                values[i][j] = (values[i][j - 1] << 1) + (s.charAt(j - 1) - '0');
            }
        }
        /**
         * 初始化假设字符串s的所有子串都不是美丽字符串
         */
        for (int i = 0; i <= length; i++) {
            for (int j = i + 1; j <= length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        /**
         * 找到字符串s所有长度为1的子串中的美丽字符串
         */
        for (int i = 0; i < length; i++) {
            /**
             * 1=5^0
             */
            if (s.charAt(i) == '1') {
                dp[i][i + 1] = 1;
            }
        }
        /**
         * 计算字符串s中所有长度为i，子串中第一个字符的索引值为j的子串最少可以分割成的美丽字符串个数
         */
        for (int i = 2; i <= length; i++) {
            for (int j = 0; i + j <= length; j++) {
                /**
                 * s.substring(j,j+i)自身是一个美丽字符串，不需要进一步分割
                 */
                if (powers.contains(values[j][j + i])) {
                    dp[j][j + i] = 1;
                    continue;
                }
                /**
                 * 将s.substring(j,j+i)分割为s.substring(j,k)和s.substring(k,j+i)两部分，分别判断两部分子串是否是美丽字符串
                 */
                for (int k = j + 1; k < j + i; k++) {
                    if (s.charAt(j) == '0' || s.charAt(k) == '0') {
                        continue;
                    }

                    if (dp[j][k] != Integer.MAX_VALUE && dp[k][j + i] != Integer.MAX_VALUE) {
                        dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k][j + i]);
                    }
                }
            }
        }
        return dp[0][length] == Integer.MAX_VALUE ? -1 : dp[0][length];
    }
}
