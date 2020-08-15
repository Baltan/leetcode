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
        int[][][] dp = new int[105][105][105];
        int length = boxes.length;

        for (int len = 1; len <= length; len++) {
            for (int i = 0; i + len - 1 < length; i++) {
                int j = i + len - 1;

                for (int k = 0; k < length; k++) {
                    dp[i][j][k] =
                            Math.max(dp[i][j][k], (j - 1 < i ? 0 : dp[i][j - 1][0]) + (k + 1) * (k + 1));

                    for (int t = i; t <= j - 1; t++) {
                        if (boxes[t] == boxes[j]) {
                            dp[i][j][k] = Math.max(dp[i][j][k], (t + 1 > j - 1 ? 0 : dp[t + 1][j - 1][0]) +
                                    dp[i][t][k + 1]);
                        }
                    }
                }
            }
        }
        return dp[0][length - 1][0];
    }
}
