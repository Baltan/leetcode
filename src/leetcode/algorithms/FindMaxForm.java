package leetcode.algorithms;

/**
 * Description: 474. Ones and Zeroes
 *
 * @author Baltan
 * @date 2020-01-30 13:10
 */
public class FindMaxForm {
    public static void main(String[] args) {
        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs1, 5, 3));

        String[] strs2 = {"10", "0", "1"};
        System.out.println(findMaxForm(strs2, 1, 1));

        String[] strs3 =
                {"0", "11", "1000", "01", "0", "101", "1", "1", "1", "0", "0", "0", "0", "1", "0", "0110101",
                        "0", "11", "01", "00", "01111", "0011", "1", "1000", "0", "11101", "1", "0", "10",
                        "0111"};
        System.out.println(findMaxForm(strs3, 9, 80));

        String[] strs4 =
                {"11", "11", "0", "0", "10", "1", "1", "0", "11", "1", "0", "111", "11111000", "0", "11",
                        "000", "1", "1", "0", "00", "1", "101", "001", "000", "0", "00", "0011", "0",
                        "10000"};
        System.out.println(findMaxForm(strs4, 90, 66));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/ones-and-zeroes/solution/dong-tai-gui-hua-zhuan-huan-wei-0-1-bei-bao-wen-ti/"></a>
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        /**
         * dp[i][j][k]表示用j个0和k个1可以在数组strs的前i个字符串中拼出的最大数量，所有的dp[0][j][k]
         * 都初始化为0，因为没有可以拼的字符串
         */
        int[][][] dp = new int[length + 1][m + 1][n + 1];

        for (int i = 1; i <= length; i++) {
            /**
             * 字符串strs[i-1]中0的个数
             */
            int count0 = 0;
            /**
             * 字符串strs[i-1]中1的个数
             */
            int count1 = 0;

            for (char c : strs[i - 1].toCharArray()) {
                if (c == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    /**
                     * 如果不拼字符串strs[i-1]，dp[i][j][k]的值和dp[i-1][j][k]相等
                     */
                    dp[i][j][k] = dp[i - 1][j][k];
                    /**
                     * 如果可以拼字符串strs[i-1]，拼了字符串strs[i-1]后，还剩j-count0个0和
                     * k-count1个1，dp[i][j][k]的值为1+dp[i-1][j-count0][k-count1]，在
                     * dp[i-1][j][k]和1+dp[i-1][j-count0][k-count1]中取较大值
                     */
                    if (j >= count0 && k >= count1) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - count0][k - count1] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }
}
