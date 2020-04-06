package leetcode.algorithms;

/**
 * Description: 72. Edit Distance
 *
 * @author Baltan
 * @date 2020-04-06 00:10
 * @see MinDistance
 */
public class MinDistance1 {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("", ""));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-by-leetcode-solution/"></a>
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        /**
         * dp[i][j]表示对word1的前i个字母构成的子串和word2的前j个字母构成的子串进行编辑操作，使
         * 两个子串相等的最小操作数
         */
        int[][] dp = new int[length1 + 1][length2 + 1];
        /**
         * 对于所有的dp[i][0]，此时第二个子串为""，将第一个子串的所有字母一一删除即可，操作数为
         * 第一个子串的字母个数
         */
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        /**
         * 对于所有的dp[0][i]，此时第一个子串为""，将第二个子串的所有字母一一删除即可，操作数为
         * 第二个子串的字母个数
         */
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                /**
                 * 如果两个子串的最后一个字母相同，则dp[i][j]可以由dp[i-1][j]在第一个子串最后
                 * 插入一个字母得到，也可以由dp[i][j-1]在第二个子串最后插入一个字母得到，也可以
                 * 直接在dp[i-1][j-1]不做任何操作的基础上得到，即在dp[i-1][j]+1、dp[i][j-1]
                 * +1、dp[i-1][j-1]三者中取最小值。如果两个子串的最后一个字母不同，则dp[i][j]
                 * 可以由dp[i-1][j]在第一个子串最后插入一个字母得到，也可以由dp[i][j-1]在第二
                 * 个子串最后插入一个字母得到，也可以在dp[i-1][j-1]的基础上将第一个子串的第i个
                 * 字母修改成和第二个子串的第j个字母一样得到，即在dp[i-1][j]+1、dp[i][j-1]+1、
                 * dp[i-1][j-1]+1三者中取最小值
                 */
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(1 + Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
