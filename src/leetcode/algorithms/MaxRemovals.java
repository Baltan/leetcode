package leetcode.algorithms;

/**
 * Description: 3316. Find Maximum Removals From Source String
 *
 * @author Baltan
 * @date 2024/10/18 23:47
 */
public class MaxRemovals {
    public static void main(String[] args) {
        System.out.println(maxRemovals("abbaa", "aba", new int[]{0, 1, 2}));
        System.out.println(maxRemovals("bcda", "d", new int[]{0, 3}));
        System.out.println(maxRemovals("dda", "dda", new int[]{0, 1, 2}));
        System.out.println(maxRemovals("yeyeykyded", "yeyyd", new int[]{0, 2, 3, 4}));
    }

    public static int maxRemovals(String source, String pattern, int[] targetIndices) {
        int sourceLength = source.length();
        int patternLength = pattern.length();
        /**
         * isTarget[i]表示字符source[i]是否可被删除
         */
        boolean[] isTarget = new boolean[sourceLength];
        /**
         * dp[i][j]表示如果pattern[0……j)是source[0……i)的子序列，则source[0……i)中最多可删除字符的个数
         */
        int[][] dp = new int[sourceLength + 1][patternLength + 1];

        for (int targetIndex : targetIndices) {
            isTarget[targetIndex] = true;
        }
        /**
         * 当pattern[0……j)不为空字符串时，先假设其不为source[0……i)的子序列，用dp[i][j]=-1表示
         */
        for (int i = 0; i <= sourceLength; i++) {
            for (int j = 1; j <= patternLength; j++) {
                dp[i][j] = -1;
            }
        }
        /**
         * 当pattern[0……j)为空字符串时，尽可能地将source[0……i)中的字符删除，每当遇到可以删除的字符，都能在source[0……i-1)的基础上多删除
         * 一个字符source[i-1]
         */
        for (int i = 1; i <= sourceLength; i++) {
            dp[i][0] = dp[i - 1][0] + (isTarget[i - 1] ? 1 : 0);
        }
        /**
         * 考虑pattern[0……j)不为空字符串时，source[0……i)最多可以删除字符的个数
         */
        for (int i = 1; i <= sourceLength; i++) {
            for (int j = 1; j <= i && j <= patternLength; j++) {
                /**
                 * 如果source[0……i-1)删除dp[i-1][j]个字符后仍然包含子序列pattern[0……j)，则source[0……i)也可以在删除dp[i-1][j]个字
                 * 符后仍然包含子序列pattern[0……j)，同时还有可能可以删除字符source[i-1]
                 */
                if (dp[i - 1][j] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + (isTarget[i - 1] ? 1 : 0));
                }
                /**
                 * 如果source[0……i-1)删除dp[i-1][j-1]个字符后包含子序列pattern[0……j-1)，并且字符则source[i-1]和pattern[j-1]，则
                 * source[0……i)也可以在删除dp[i-1][j-1]个字符后包含子序列pattern[0……j-1)
                 */
                if (dp[i - 1][j - 1] != -1 && source.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[sourceLength][patternLength];
    }
}
