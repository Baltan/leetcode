package leetcode.algorithms;

/**
 * Description: 3332. Maximum Points Tourist Can Earn
 *
 * @author Baltan
 * @date 2024/10/27 16:50
 */
public class MaxScore8 {
    public static void main(String[] args) {
        System.out.println(maxScore(2, 1, new int[][]{{2, 3}}, new int[][]{{0, 2}, {1, 0}}));
        System.out.println(maxScore(3, 2, new int[][]{{3, 4, 2}, {2, 1, 2}}, new int[][]{{0, 2, 1}, {2, 0, 4}, {3, 2, 0}}));
    }

    public static int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int result = Integer.MIN_VALUE;
        /**
         * dp[i][j]表示第i天位于城市j时的最大得分
         */
        int[][] dp = new int[k + 1][n];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                /**
                 * 第i天和第i+1天都位于城市j的情况
                 */
                dp[i + 1][j] = dp[i][j] + stayScore[i][j];
                /**
                 * 第i天位于城市l，第i+1天位于城市j的情况
                 */
                for (int l = 0; l < n; l++) {
                    if (j != l) {
                        dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][l] + travelScore[l][j]);
                    }
                }
            }
        }
        /**
         * 选择第k天位于各个城市中的最大得分
         */
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[k][i]);
        }
        return result;
    }
}
