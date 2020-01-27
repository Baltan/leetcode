package leetcode.algorithms;

/**
 * Description: 1312. Minimum Insertion Steps to Make a String Palindrome
 *
 * @author Baltan
 * @date 2020-01-27 14:28
 * @see LongestPalindromeSubseq
 */
public class MinInsertions {
    public static void main(String[] args) {
        System.out.println(minInsertions("zzazz"));
        System.out.println(minInsertions("mbadm"));
        System.out.println(minInsertions("leetcode"));
        System.out.println(minInsertions("g"));
        System.out.println(minInsertions("no"));
    }

    public static int minInsertions(String s) {
        int length = s.length();
        /**
         * dp[i][j]表示以s.chatAt(i)作为第一个字符，以s.charAt(j)作为最后一个字符的子串中的
         * 最长回文子序列
         */
        int[][] dp = new int[length][length];
        /**
         * 当i≠j时，如果s.chatAt(i)和s.charAt(j)相等，则dp[i][j]=dp[i+1][j-1]+2，如果
         * s.chatAt(i)和s.charAt(j)不相等，则dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])
         *
         * 当i=j时，显然该子串本身即为长度为1的回文序列，所以dp[0][0]、dp[1][1]、……、
         * dp[length-1][length-1]为1
         *
         * 例如：s="cbbd"
         *
         * <pre>
         * 0  0  0  0    0  0  0  0    0  0  0  0    1  1  2  2
         * 0  0  0  0 => 0  0  0  0 => 0  1  2  2 => 0  1  2  2
         * 0  0  0  0    0  0  1  1    0  0  1  1    0  0  1  1
         * 0  0  0  1    0  0  0  1    0  0  0  1    0  0  0  1
         * </pre>
         */
        for (int row = length - 1; row >= 0; row--) {
            dp[row][row] = 1;

            for (int col = row + 1; col < length; col++) {
                char c1 = s.charAt(row);
                char c2 = s.charAt(col);

                if (c1 == c2) {
                    dp[row][col] = dp[row + 1][col - 1] + 2;
                } else {
                    dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]);
                }
            }
        }
        /**
         * 字符串s的长度减去s中的最长回文子序列的长度就是让字符串s成为回文串的最少插入次数
         */
        return length - dp[0][length - 1];
    }
}
