package leetcode.algorithms;

/**
 * Description: 516. Longest Palindromic Subsequence
 *
 * @author Baltan
 * @date 2019-10-04 11:54
 * @see MinInsertions
 * @see MaxProduct3
 */
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
        System.out.println(longestPalindromeSubseq("c"));
        System.out.println(longestPalindromeSubseq("cc"));
    }

    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 1;
        int length = s.length();
        int[][] dp = new int[length][length];
        /**
         * dp[i][j]表示以s.chatAt(i)作为第一个字符，以s.charAt(j)作为最后一个字符的子串中的
         * 最长回文子序列。当i=j时，显然该子串本身即为长度为1的回文序列，所以初始化dp[0][0]、
         * dp[1][1]、……、dp[length-1][length-1]为1
         */
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        /**
         * 当i≠j时，如果s.chatAt(i)和s.charAt(j)相等，则dp[i][j]=dp[i+1][j-1]+2，如果
         * s.chatAt(i)和s.charAt(j)不相等，则dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])
         * 例如：s="cbbd"
         * <pre>
         * 1  0  0  0    1  1  0  0    1  1  2  0    1  1  2  2
         * 0  1  0  0 => 0  1  2  0 => 0  1  2  2 => 0  1  2  2
         * 0  0  1  0    0  0  1  1    0  0  1  1    0  0  1  1
         * 0  0  0  1    0  0  0  1    0  0  0  1    0  0  0  1
         * </pre>
         */
        for (int i = 1; i < length; i++) {
            int row = 0;
            int col = i;

            while (row < length && col < length) {
                char c1 = s.charAt(row);
                char c2 = s.charAt(col);

                if (c1 == c2) {
                    dp[row][col] = dp[row + 1][col - 1] + 2;
                } else {
                    dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]);
                }
                result = Math.max(result, dp[row][col]);
                row++;
                col++;
            }
        }
        return result;
    }
}
