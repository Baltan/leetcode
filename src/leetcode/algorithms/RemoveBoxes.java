package leetcode.algorithms;

/**
 * Description: 546. Remove Boxes
 *
 * @author Baltan
 * @date 2020-08-15 21:37
 */
public class RemoveBoxes {
    public static void main(String[] args) {
        System.out.println(removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/remove-boxes/solution/fei-di-gui-ban-qu-jian-dp-by-acw_weian/"></a>
     *
     * @param boxes
     * @return
     */
    public static int removeBoxes(int[] boxes) {
        /**
         * dp[i][j][k]表示从[i,j]中移除盒子，并且j右边有k个和boxes[j]颜色相同的盒子
         */
        int[][][] dp = new int[105][105][105];
        int length = boxes.length;
        /**
         * len表示移除盒子区间[start,end]的长度
         */
        for (int len = 1; len <= length; len++) {
            /**
             * start表示移除盒子区间的第一个盒子的索引
             */
            for (int start = 0; start + len - 1 < length; start++) {
                /**
                 * end表示移除盒子区间的最后一个盒子的索引
                 */
                int end = start + len - 1;

                for (int k = 0; k < length; k++) {
                    /**
                     * 方案1：先移除右边的颜色相同的k+1个盒子得到(k+1)*(k+1)分, 再移除[start,end-1]中的盒子
                     */
                    dp[start][end][k] =
                            Math.max(dp[start][end][k],
                                    (end <= start ? 0 : dp[start][end - 1][0]) + (k + 1) * (k + 1));
                    /**
                     * 方案2：先移除[mid+1,end-1]中的盒子，再将剩下的[start,mid]和end及其右边k个颜色相同的盒
                     * 子连到一起后移除，此时，最后k+1个盒子的颜色是相同的
                     */
                    for (int mid = start; mid < end; mid++) {
                        if (boxes[mid] == boxes[end]) {
                            dp[start][end][k] = Math.max(dp[start][end][k],
                                    (end <= mid + 1 ? 0 : dp[mid + 1][end - 1][0]) +
                                            dp[start][mid][k + 1]);
                        }
                    }
                }
            }
        }
        return dp[0][length - 1][0];
    }
}
