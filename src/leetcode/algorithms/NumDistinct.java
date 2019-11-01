package leetcode.algorithms;

/**
 * Description: 115. Distinct Subsequences
 *
 * @author Baltan
 * @date 2019-11-01 08:52
 */
public class NumDistinct {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }

    public static int numDistinct(String s, String t) {
        /**
         * 参考：
         * <a href="https://leetcode-cn.com/problems/distinct-subsequences/solution/dong-tai-gui-hua-si-yao-su-by-a380922457-2/"></a>
         */
        int sLength = s.length();
        int tLength = t.length();
        /**
         * 如果t的长度比s的长度更长，s的子序列中不可能含有t
         */
        if (sLength < tLength) {
            return 0;
        }
        /**
         * dp[i][j]记录s的前i个字符构成的字符串的子序列中等于t的前j个字符构成的字符串的个数
         */
        int[][] dp = new int[sLength + 1][tLength + 1];
        /**
         * 显然对于空字符串t，任何字符串s中都只有一个子序列含有t，即将s的所有字符都删除完
         */
        for (int i = 0; i <= sLength; i++) {
            dp[i][0] = 1;
        }
        /**
         * 对于dp[i][j]：
         * 如果s的第i个字符和t的第j个字符相同，则可以从s的前i-1个字符构成的字符串的子序列中查找t的前j-1个字符构成的
         * 字符串，加上s的第i个字符（也就是t的第j个字符）即可，即dp[i-1][j-1]；也可以从s的前i-1个字符构成的字符串的
         * 子序列中查找t的前j个字符构成的字符串，忽略s的第i个字符，即dp[i-1][j]。例如：在"aabbcc"的子序列中查找
         * "abc"则可以从"aabbc"中查找"ab"，也可以从"aabbc"中查找"abc"
         * 如果s的第i个字符和t的第j个字符不相同，则可以从s的前i-1个字符构成的字符串的子序列中查找t的前j个字符构成的
         * 字符串，忽略s的第i个字符，即dp[i-1][j]。例如：在"aabbcc"的子序列中查找"abb"则可以从"aabbc"中查找"abb"
         */
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= tLength; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLength][tLength];
    }
}
