package leetcode.algorithms;

/**
 * Description: 3472. Longest Palindromic Subsequence After at Most K Operations
 *
 * @author baltan
 * @date 2025/3/17 17:55
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequence("abced", 2));
        System.out.println(longestPalindromicSubsequence("aaazzz", 4));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/longest-palindromic-subsequence-after-at-most-k-operations/solutions/3591706/qu-jian-dppythonjavacgo-by-endlesscheng-sd78/"></a>
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestPalindromicSubsequence(String s, int k) {
        int length = s.length();
        /**
         * dp[i][j][l]表示长度为i，以字符s[j]开头的子串，最多进行l次操作后，能够得到的最长回文子序列的长度，所求即为dp[length][0][k]
         */
        int[][][] dp = new int[length + 1][length][k + 1];
        /**
         * 初始化，长度为1的所有子串本身就是长度为1的回文子序列
         */
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= k; j++) {
                dp[1][i][j] = 1;
            }
        }

        for (int i = 2; i <= length; i++) {
            for (int j = 0; i + j <= length; j++) {
                for (int l = 0; l <= k; l++) {
                    /**
                     * 如果字符s[j+i-1]不在回文子序列中，则子串s[j……j+i-1]最多进行l次操作后，能够得到的最长回文子序列的长度和子串
                     * s[j……j+i-2]最多进行l次操作后能够得到的最长回文子序列的长度相同
                     */
                    dp[i][j][l] = Math.max(dp[i][j][l], dp[i - 1][j][l]);
                    /**
                     * 如果字符s[j]不在回文子序列中，则子串s[j……j+i-1]最多进行l次操作后，能够得到的最长回文子序列的长度和子串
                     * s[j+1……j+i-1]最多进行l次操作后能够得到的最长回文子序列的长度相同
                     */
                    dp[i][j][l] = Math.max(dp[i][j][l], dp[i - 1][j + 1][l]);
                    /**
                     * 如果字符s[j]和s[j+i-1]都在回文子序列中，则操作后它们应该是相同字符，最少操作次数为operations
                     */
                    int distance = Math.abs(s.charAt(j) - s.charAt(i + j - 1));
                    int operations = Math.min(distance, 26 - distance);

                    if (l >= operations) {
                        /**
                         * 字符s[j]和s[j+i-1]都在回文子序列中，则子串s[j……j+i-1]最多进行l次操作后，能够得到的最长回文子序列的长度比子
                         * 串s[j+1……j+i-2]最多进行l-operations次操作后能够得到的最长回文子序列的长度多2
                         */
                        dp[i][j][l] = Math.max(dp[i][j][l], dp[i - 2][j + 1][l - operations] + 2);
                    }
                }
            }
        }
        return dp[length][0][k];
    }
}
