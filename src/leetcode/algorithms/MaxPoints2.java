package leetcode.algorithms;

/**
 * Description: 1937. Maximum Number of Points with Cost
 *
 * @author Baltan
 * @date 2022/2/19 21:17
 */
public class MaxPoints2 {
    public static void main(String[] args) {
        int[][] points1 = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        System.out.println(maxPoints(points1));

        int[][] points2 = {{1, 5}, {2, 3}, {4, 2}};
        System.out.println(maxPoints(points2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/maximum-number-of-points-with-cost/solution/dp-you-hua-ji-qiao-chai-xiang-qian-hou-z-5vvc/"></a>
     *
     * @param points
     * @return
     */
    public static long maxPoints(int[][] points) {
        long result = Long.MIN_VALUE;
        int rows = points.length;
        int cols = points[0].length;
        /**
         * dp[i][j]表示选择从第0行开始到第i行为止，选择points[i][j]时，可以得到的最高分。
         * 则dp[i][j]=points[i][j]+Math.max{dp[i−1][k]−Math.abs(k−j)}
         * 当j>=k时，dp[i][j]=points[i][j]+Math.max{dp[i−1][k]−(j-k)}=points[i][j]-j+Math.max{dp[i−1][k]+k}
         * 当j<k时，dp[i][j]=points[i][j]+Math.max{dp[i−1][k]−(k-j)}=points[i][j]+j+Math.max{dp[i−1][k]-k}
         */
        long[][] dp = new long[rows][cols];
        /**
         * 初始化第0行的得分
         */
        for (int j = 0; j < cols; j++) {
            dp[0][j] = points[0][j];
        }

        for (int i = 1; i < rows; i++) {
            long max = Long.MIN_VALUE;
            /**
             * 计算第i行选中的格子在第i-1行选中的格子靠右侧的情况
             */
            for (int j = 0; j < cols; j++) {
                /**
                 * 计算上一行选择points[i-1][0]到points[i-1][j]时，dp[i-1][k]+k的最大值
                 */
                max = Math.max(max, dp[i - 1][j] + j);
                dp[i][j] = Math.max(dp[i][j], points[i][j] - j + max);
            }

            max = Long.MIN_VALUE;
            /**
             * 计算第i行选中的格子在第i-1行选中的格子靠左侧的情况
             */
            for (int j = cols - 1; j >= 0; j--) {
                /**
                 * 计算上一行选择points[i-1][cols-1]到points[i-1][j]时，dp[i-1][k]-k的最大值
                 */
                max = Math.max(max, dp[i - 1][j] - j);
                dp[i][j] = Math.max(dp[i][j], points[i][j] + j + max);
            }
        }

        for (int i = 0; i < cols; i++) {
            result = Math.max(result, dp[rows - 1][i]);
        }
        return result;
    }
}
