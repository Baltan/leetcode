package leetcode.algorithms;

/**
 * Description: 2370. Longest Ideal Subsequence
 *
 * @author Baltan
 * @date 2023/1/11 09:29
 * @see LongestIdealString
 */
public class LongestIdealString1 {
    public static void main(String[] args) {
        System.out.println(longestIdealString("a", 1));
        System.out.println(longestIdealString("acfgbd", 2));
        System.out.println(longestIdealString("abcd", 3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/longest-ideal-subsequence/solutions/1728730/by-endlesscheng-t7zf/"></a>
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestIdealString(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }
        int result = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * dp[i]表示遍历字符串s的过程中，以字符'a'+i结尾的最长理想子序列的长度
         */
        int[] dp = new int[26];
        dp[charArray[0] - 'a'] = 1;

        for (int i = 1; i < length; i++) {
            int index = charArray[i] - 'a';
            /**
             * 如果当前子串的最长理想子序列以s[i]结尾，则倒数第二个字符不小于s[i]-k且不大于s[i]+k
             */
            int min = Math.max(index - k, 0);
            int max = Math.min(index + k, 25);

            for (int j = min; j <= max; j++) {
                dp[index] = Math.max(dp[index], dp[j]);
            }
            /**
             * 加上当前字符后，最长理想子序列的长度加1
             */
            dp[index]++;
            result = Math.max(result, dp[index]);
        }
        return result;
    }
}