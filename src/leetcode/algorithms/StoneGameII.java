package leetcode.algorithms;

/**
 * Description: 1140. Stone Game II
 *
 * @author Baltan
 * @date 2020-03-05 12:52
 * @see PredictTheWinner
 * @see PredictTheWinner1
 * @see StoneGame
 * @see StoneGameIII
 * @see StoneGameIX
 * @see StoneGameVI
 * @see StoneGameVII
 */
public class StoneGameII {
    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{2, 7, 9, 4, 4}));
        System.out.println(stoneGameII(
                new int[]{324, 4645, 242, 42, 1342, 4, 31, 31, 13, 242, 534, 42, 143, 543, 42, 41, 35, 42, 53,
                        2423, 63, 52, 41, 36}));
        System.out.println(stoneGameII(
                new int[]{3111, 4303, 2722, 2183, 6351, 5227, 8964, 7167, 9286, 6626, 2347, 1465, 5201,
                        7240,
                        5463, 8523, 8163, 9391, 8616, 5063, 7837, 7050, 1246, 9579, 7744, 6932, 7704, 9841,
                        6163, 4829, 7324, 6006, 4689, 8781, 621}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/stone-game-ii/solution/cji-bai-9699nei-cun-ji-bai-100-by-zyh518/"></a>
     *
     * @param piles
     * @return
     */
    public static int stoneGameII(int[] piles) {
        int length = piles.length;
        int total = 0;
        /**
         * dp[i][j]表示先手从第i（0-based）堆石头开始拿，M为j，即可以拿[1,2j]堆石头时，
         * 可以获得的最大石头数量
         */
        int[][] dp = new int[length][length + 1];

        for (int i = length - 1; i >= 0; i--) {
            /**
             * 剩余的石头总数
             */
            total += piles[i];

            for (int M = 1; M <= length; M++) {
                /**
                 * 此时可以把所有石头一次性拿光
                 */
                if (i + 2 * M >= length) {
                    dp[i][M] = total;
                } else {
                    /**
                     * 当先手拿掉j堆后，后手要从第i+j堆开始拿，并且M为Math.max(M,j)，所以
                     * 后手可以获得的最大石头数量为dp[i+j][Math.max(M,j)]，则先手可以获得
                     * 的石头数量为total-dp[i+j][Math.max(M,j)]
                     */
                    for (int j = 1; j <= Math.min(length - i, 2 * M); j++) {
                        dp[i][M] = Math.max(dp[i][M], total - dp[i + j][Math.max(M, j)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
