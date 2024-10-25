package leetcode.algorithms;

/**
 * Description: 1987. Number of Unique Good Subsequences
 *
 * @author Baltan
 * @date 2024/10/18 00:18
 */
public class NumberOfUniqueGoodSubsequences {
    public static void main(String[] args) {
        System.out.println(numberOfUniqueGoodSubsequences("001"));
        System.out.println(numberOfUniqueGoodSubsequences("11"));
        System.out.println(numberOfUniqueGoodSubsequences("101"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/number-of-unique-good-subsequences/solutions/965005/dong-tai-gui-hua-jing-dian-ti-mu-de-bian-n4h3/"></a>
     *
     * @param binary
     * @return
     */
    public static int numberOfUniqueGoodSubsequences(String binary) {
        int mod = 1000000007;
        int length = binary.length();
        /**
         * dp[i][0]表示子串binary.substring(i-1)中以"0"开头的子序列的数量，dp[i][1]表示子串binary.substring(i-1)中以"1"开头的子序
         * 列的数量
         */
        long[][] dp = new long[length + 1][2];
        /**
         * 字符串binary中是否包含字符"0"
         */
        boolean containsZero = false;

        for (int i = length - 1; i >= 0; i--) {
            if (binary.charAt(i) == '0') {
                /**
                 * 以"0"开头的子序列可以由：
                 * 1、之前所有子序列头部追加当前字符"0"得到，数量为dp[i+1][0]+dp[i+1][1]
                 * 2、当前字符"0"单独作为一个子序列得到，数量为1
                 * 3、舍弃当前字符"0"，之前所有以"0"开头的子序列，但是这部分子序列和情况1中是重复的，不计数
                 */
                dp[i][0] = (dp[i + 1][0] + dp[i + 1][1] + 1) % mod;
                dp[i][1] = dp[i + 1][1];
                containsZero = true;
            } else {
                dp[i][0] = dp[i + 1][0];
                /**
                 * 以"1"开头的子序列可以由：
                 * 1、之前所有子序列头部追加当前字符"1"得到，数量为dp[i+1][0]+dp[i+1][1]
                 * 2、当前字符"1"单独作为一个子序列得到，数量为1
                 * 3、舍弃当前字符"1"，之前所有以"1"开头的子序列，但是这部分子序列和情况1中是重复的，不计数
                 */
                dp[i][1] = (dp[i + 1][0] + dp[i + 1][1] + 1) % mod;
            }
        }
        /**
         * 所有以"1"开头的子序列的数量为dp[0][1]，如果字符串binary中是否包含字符"0"，则还要加上子序列"0"
         */
        return (int) (dp[0][1] + (containsZero ? 1 : 0)) % mod;
    }
}
