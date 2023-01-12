package leetcode.algorithms;

/**
 * Description: 2370. Longest Ideal Subsequence
 *
 * @author Baltan
 * @date 2023/1/11 09:29
 * @see LongestIdealString1
 */
public class LongestIdealString {
    public static void main(String[] args) {
        System.out.println(longestIdealString("a", 1));
        System.out.println(longestIdealString("acfgbd", 2));
        System.out.println(longestIdealString("abcd", 3));
    }

    public static int longestIdealString(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }
        int result = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * dp[i][j]表示子串s.substring(0,i+1)，即到s[i]为止的子串中，以字符'a'+j结尾的最长理想子序列的长度
         */
        int[][] dp = new int[length][26];
        dp[0][charArray[0] - 'a'] = 1;

        for (int i = 1; i < length; i++) {
            int index = charArray[i] - 'a';
            /**
             * 当前最长理想子序列不以s[i]结尾的情况
             */
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            /**
             * 当前最长理想子序列以s[i]结尾的情况，则倒数第二个字符不小于s[i]-k且不大于s[i]+k
             */
            int min = Math.max(index - k, 0);
            int max = Math.min(index + k, 25);

            for (int j = min; j <= max; j++) {
                dp[i][index] = Math.max(dp[i][index], dp[i - 1][j] + 1);
            }
            result = Math.max(result, dp[i][index]);
        }
        return result;
    }
}