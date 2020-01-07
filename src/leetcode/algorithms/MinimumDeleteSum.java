package leetcode.algorithms;

/**
 * Description: 712. Minimum ASCII Delete Sum for Two Strings
 *
 * @author Baltan
 * @date 2020-01-06 13:00
 */
public class MinimumDeleteSum {
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("sea", "eat"));
        System.out.println(minimumDeleteSum("delete", "leet"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/solution/liang-ge-zi-fu-chuan-de-zui-xiao-asciishan-chu-he-/"></a>
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int minimumDeleteSum(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        /**
         * dp[i][j]表示使s1.substring(i)和s2.substring(j)这两个子串相等所需删除字符的ASCII值的最小和
         */
        int[][] dp = new int[length1 + 1][length2 + 1];
        /**
         * dp[length1][length2]为0，因为此时两个子串s1.substring(length1)和s2.substring(length2)
         * 都是""
         */
        dp[length1][length2] = 0;
        /**
         * dp[i][length2]为s1.substring(i)的所有字符的和，因为此时s2的子串s2.substring(length2)为""
         */
        for (int i = length1 - 1; i >= 0; i--) {
            dp[i][length2] = dp[i + 1][length2] + s1.charAt(i);
        }
        /**
         * dp[length1][i]为s2.substring(i)的所有字符的和，因为此时s1的子串s1.substring(length1)为""
         */
        for (int i = length2 - 1; i >= 0; i--) {
            dp[length1][i] = dp[length1][i + 1] + s2.charAt(i);
        }
        /**
         * 对于dp[i][j]，如果s1.charAt(i)和s2.charAt(j)相同，则dp[i][j]就是dp[i+1][j+1]，否则就应该
         * 在dp[i+1][j]+s1.charAt(i)和dp[i][j+1]+s2.charAt(j)中选择较小值。所以应该从二维矩阵dp的右
         * 下角向左上方动态计算每个dp[i][j]的值，最终所求即为dp[0][0]
         */
        for (int indexSum = length1 + length2 - 2; indexSum >= 0; indexSum--) {
            /**
             * indexSum为同一副对角线上的元素的行索引和列索引的和，Math.min(length2-1,indexSum)表示当
             * 前副对角线上元素的最大列索引，Math.max(0,indexSum-(length1-1))表示当前副对角线上元素的
             * 最小列索引
             */
            for (int i = Math.min(length2 - 1, indexSum), j = Math.max(0, indexSum - (length1 - 1)); i >= j;
                 i--) {
                dp[indexSum - i][i] = s1.charAt(indexSum - i) == s2.charAt(i) ? dp[indexSum - i + 1][i + 1] :
                        Math.min(dp[indexSum - i][i + 1] + s2.charAt(i),
                                dp[indexSum - i + 1][i] + s1.charAt(indexSum - i));
            }
        }
        return dp[0][0];
    }
}
