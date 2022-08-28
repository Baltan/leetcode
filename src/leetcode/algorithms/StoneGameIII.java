package leetcode.algorithms;

/**
 * Description: 1406. Stone Game III
 *
 * @author Baltan
 * @date 2020-04-18 11:46
 * @see PredictTheWinner1
 * @see StoneGame
 * @see StoneGameII
 * @see StoneGameIX
 * @see StoneGameVII
 */
public class StoneGameIII {
    public static void main(String[] args) {
        System.out.println(stoneGameIII(new int[]{1, 2, 3, 7}));
        System.out.println(stoneGameIII(new int[]{1, 2, 3, -9}));
        System.out.println(stoneGameIII(new int[]{1, 2, 3, 6}));
        System.out.println(stoneGameIII(new int[]{1, 2, 3, -1, -2, -3, 7}));
        System.out.println(stoneGameIII(new int[]{-1, -2, -3}));
        System.out.println(stoneGameIII(new int[]{-2}));
        System.out.println(stoneGameIII(new int[]{1, 3}));
        System.out.println(stoneGameIII(new int[]{1, -3}));
    }

    public static String stoneGameIII(int[] stoneValue) {
        int length = stoneValue.length;
        /**
         * 如果只有一堆石头，先手Alice必须把这堆石头拿走
         */
        if (length == 1) {
            if (stoneValue[0] > 0) {
                return "Alice";
            } else if (stoneValue[0] < 0) {
                return "Bob";
            } else {
                return "Tie";
            }
        }
        /**
         * 如果只有两堆石头，先手Alice可以只拿前一堆石头，则后手Bob必须拿走剩下的一堆石头，或者先手
         * Alice可以把两堆石头都拿走，两种情况取较大值
         */
        if (length == 2) {
            int result = Math.max(stoneValue[0] + stoneValue[1], stoneValue[0] - stoneValue[1]);

            if (result > 0) {
                return "Alice";
            } else if (result < 0) {
                return "Bob";
            } else {
                return "Tie";
            }
        }

        /**
         * dp[i][0]表示剩余石头从第i堆开始，先手拿走前一堆石头时，先手获得的总和与后手获得的总和
         * 之差；dp[i][1]表示剩余石头从第i堆开始，先手拿走前两堆石头时，先手获得的总和与后手获得的
         * 总和之差；dp[i][2]表示剩余石头从第i堆开始，先手拿走前三堆石头时，先手获得的总和与后手获
         * 得的总和之差
         */
        int[][] dp = new int[length][3];
        /**
         * 如果只剩下最后一堆石头，先手Alice取前一堆石头可以获得的最好结果
         */
        dp[length - 1][0] = stoneValue[length - 1];
        /**
         * 如果只剩下最后一堆石头，先手Alice取前两堆石头（其实只能取一堆）可以获得的最好结果
         */
        dp[length - 1][1] = stoneValue[length - 1];
        /**
         * 如果只剩下最后一堆石头，先手Alice取前三堆石头（其实只能取一堆）可以获得的最好结果
         */
        dp[length - 1][2] = stoneValue[length - 1];
        /**
         * 如果只剩下最后两堆石头，先手Alice取前一堆石头可以获得的最好结果
         */
        dp[length - 2][0] = stoneValue[length - 2] - stoneValue[length - 1];
        /**
         * 如果只剩下最后两堆石头，先手Alice取前两堆石头可以获得的最好结果
         */
        dp[length - 2][1] = stoneValue[length - 2] + stoneValue[length - 1];
        /**
         * 如果只剩下最后两堆石头，先手Alice取前三堆石头（其实只能取两堆）可以获得的最好结果
         */
        dp[length - 2][2] = stoneValue[length - 2] + stoneValue[length - 1];
        /**
         * 如果只剩下最后三堆石头，先手Alice取前一堆石头可以获得的最好结果
         */
        dp[length - 3][0] = stoneValue[length - 3] - Math.max(dp[length - 2][0], dp[length - 2][1]);
        /**
         * 如果只剩下最后三堆石头，先手Alice取前两堆石头可以获得的最好结果
         */
        dp[length - 3][1] = stoneValue[length - 3] + stoneValue[length - 2] - stoneValue[length - 1];
        /**
         * 如果只剩下最后三堆石头，先手Alice取前三堆石头可以获得的最好结果
         */
        dp[length - 3][2] = stoneValue[length - 3] + stoneValue[length - 2] + stoneValue[length - 1];

        for (int i = length - 4; i >= 0; i--) {
            /**
             * 如果只剩下最后length-i堆石头，先手Alice取前一堆石头可以获得的最好结果
             */
            dp[i][0] = stoneValue[i] - max(dp[i + 1][0], dp[i + 1][1], dp[i + 1][2]);
            /**
             * 如果只剩下最后length-i堆石头，先手Alice取前两堆石头可以获得的最好结果
             */
            dp[i][1] = stoneValue[i] + stoneValue[i + 1] - max(dp[i + 2][0], dp[i + 2][1], dp[i + 2][2]);
            /**
             * 如果只剩下最后length-i堆石头，先手Alice取前三堆石头可以获得的最好结果
             */
            dp[i][2] = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - max(dp[i + 3][0], dp[i + 3][1],
                    dp[i + 3][2]);
        }
        /**
         * 先手Alice采取最优策略，可以比后手Bob最多领先的分数
         */
        int result = max(dp[0][0], dp[0][1], dp[0][2]);

        if (result > 0) {
            return "Alice";
        } else if (result < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    /**
     * 获得x、y、z三个数中的最大值
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static int max(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}
