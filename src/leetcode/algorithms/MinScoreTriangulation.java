package leetcode.algorithms;

/**
 * Description: 1039. Minimum Score Triangulation of Polygon
 *
 * @author Baltan
 * @date 2020-06-11 23:04
 */
public class MinScoreTriangulation {
    public static void main(String[] args) {
        System.out.println(minScoreTriangulation(new int[]{1, 2, 3}));
        System.out.println(minScoreTriangulation(new int[]{3, 7, 4, 5}));
        System.out.println(minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-score-triangulation-of-polygon/solution/javaqu-jian-dpdian-xing-li-ti-by-im1gw0/"></a>
     *
     * @param A
     * @return
     */
    public static int minScoreTriangulation(int[] A) {
        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }

        int length = A.length;
        /**
         * dp[i][j]表示索引为i的顶点到索引为j的顶点构成的多边形进行三角剖分后可以得到的最低分
         */
        int[][] dp = new int[length][length];
        /**
         * intervalLength为区间长度，区间长度至少为3，才能构成三角形
         */
        for (int intervalLength = 3; intervalLength <= length; intervalLength++) {
            /**
             * left为最左边的顶点的索引
             */
            for (int left = 0; left <= length - intervalLength; left++) {
                /**
                 * 最右边的顶点的索引
                 */
                int right = left + intervalLength - 1;
                dp[left][right] = Integer.MAX_VALUE;
                /**
                 * mid为左顶点和右顶点中间的顶点
                 */
                for (int mid = left + 1; mid < right; mid++) {
                    dp[left][right] = Math.min(dp[left][right],
                            dp[left][mid] + dp[mid][right] + A[mid] * A[left] * A[right]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
