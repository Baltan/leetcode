package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3138. Minimum Length of Anagram Concatenation
 *
 * @author baltan
 * @date 2024/5/7 15:52
 */
public class MinAnagramLength {
    public static void main(String[] args) {
        System.out.println(minAnagramLength("pqqppqpqpq"));
        System.out.println(minAnagramLength("aabbabab"));
        System.out.println(minAnagramLength("abba"));
        System.out.println(minAnagramLength("cdef"));
    }

    public static int minAnagramLength(String s) {
        /**
         * prefixCounts[i][0]-prefixCounts[i][25]依次表示子串s.substring(0,i)中字符a-z的个数
         */
        int[][] prefixCounts = new int[s.length() + 1][26];

        for (int i = 0; i < s.length(); i++) {
            prefixCounts[i + 1] = Arrays.copyOf(prefixCounts[i], 26);
            prefixCounts[i + 1][s.charAt(i) - 'a']++;
        }
        /**
         * 从小到大遍历字符串t可能的长度
         */
        outer:
        for (int i = 1; i <= s.length(); i++) {
            /**
             * 因为字符串s由若干个字符串t的同位字符串拼接而成，所以s的长度一定可以被t的长度整除
             */
            if (s.length() % i != 0) {
                continue;
            }
            /**
             * 判断子串s.substring(j-i,j)和子串s.substring(j-2i,j-i)中每个小写字母出现的次数是否相等，如果存在某一个小写字母出现的次
             * 数不相等，则字符串s不可能由若干个字符串t的同位字符串拼接而成
             */
            for (int j = 2 * i; j <= s.length(); j += i) {
                for (int k = 0; k < 26; k++) {
                    if (prefixCounts[j][k] - prefixCounts[j - i][k] != prefixCounts[j - i][k] - prefixCounts[j - 2 * i][k]) {
                        continue outer;
                    }
                }
            }
            return i;
        }
        return s.length();
    }
}
