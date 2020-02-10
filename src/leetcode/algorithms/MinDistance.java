package leetcode.algorithms;

/**
 * Description: 583. Delete Operation for Two Strings
 *
 * @author Baltan
 * @date 2020-02-10 12:00
 */
public class MinDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }

    public static int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        /**
         * dp[i][j]表示对word1的前i个字母构成的子串和word2的前j个字母构成的子串进行删除操作，使
         * 两个子串相等的最小步数
         */
        int[][] dp = new int[length1 + 1][length2 + 1];
        /**
         * 对于所有的dp[i][0]，此时第二个子串为""，将第一个子串的所有字母一一删除即可，操作步数为
         * 第一个子串的字母个数
         */
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        /**
         * 对于所有的dp[0][i]，此时第一个子串为""，将第二个子串的所有字母一一删除即可，操作步数为第
         * 二个子串的字母个数
         */
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                /**
                 * 如果两个子串的最后一个字母相同，则两个子串的最后一个字母都可以不被删除，只要使两
                 * 个子串除去最后一个字母外前面部分的子串相等即可，即dp[i][j]=dp[i-1][j-1]；否则
                 * 两个子串中的至少有一个最后的字母将要被删除，如果word1最后的子母被删除，则需要使
                 * word1除去最后一个字母外前面部分的子串和word2相等，即dp[i][j]=dp[i-1][j]+1，
                 * 如果word2最后的字母被删除，则需要使word2除去最后一个字母外前面部分的子串和word1
                 * 相等，即dp[i][j]=dp[i][j-1]+1，两种情况取操作步数少的即可
                 */
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
