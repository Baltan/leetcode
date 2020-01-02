package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 909. Snakes and Ladders
 *
 * @author Baltan
 * @date 2020-01-02 11:19
 */
public class SnakesAndLadders {
    public static void main(String[] args) {
        int[][] board1 = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        System.out.println(snakesAndLadders(board1));

        int[][] board2 = {{-1, -1}, {-1, 4}};
        System.out.println(snakesAndLadders(board2));

        int[][] board3 = {{1, 1, -1}, {1, 1, 1}, {-1, 1, 1}};
        System.out.println(snakesAndLadders(board3));

        int[][] board4 =
                {{-1, 42, 12, -1, 1, -1, -1}, {-1, -1, 5, -1, -1, 46, 44}, {18, 22, 6, 39, -1, -1, -1},
                        {-1, -1, 40, -1, -1, -1, 37}, {49, 38, 24, -1, 14, 29, -1},
                        {-1, -1, 6, -1, -1, -1, 20}, {-1, -1, 12, 10, -1, 5, 26}};
        System.out.println(snakesAndLadders(board4));

        int[][] board5 = {{-1, -1, -1, -1}, {-1, -1, -1, 1}, {-1, -1, -1, -1}, {-1, 11, -1, -1}};
        System.out.println(snakesAndLadders(board5));

        int[][] board6 =
                {{-1, -1, -1, -1, 48, 5, -1}, {12, 29, 13, 9, -1, 2, 32}, {-1, -1, 21, 7, -1, 12, 49},
                        {42, 37, 21, 40, -1, 22, 12}, {42, -1, 2, -1, -1, -1, 6},
                        {39, -1, 35, -1, -1, 39, -1}, {-1, 36, -1, -1, -1, -1, 5}};
        System.out.println(snakesAndLadders(board6));

        int[][] board7 = {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, 41, 43, -1, -1, -1, -1, -1, -1, -1, 107}, {99,
                82, -1, 113, 72, -1, -1, -1, -1, 136, -1, 92},
                {-1, -1, -1, 86, -1, -1, -1, 60, 49, 105, -1, -1},
                {-1, -1, 23, 40, -1, -1, -1, -1, -1, 140, -1, -1},
                {-1, -1, 79, -1, 7, 57, 117, 35, -1, -1, -1, 125},
                {-1, 98, -1, 2, -1, -1, -1, -1, -1, -1, 38, -1},
                {3, -1, -1, -1, -1, 8, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 1, -1, -1, 7, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 131, 75, 103, -1, 16, -1},
                {-1, -1, -1, -1, -1, 118, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 119, -1, -1, -1, -1, -1, -1, -1}};
        System.out.println(snakesAndLadders(board7));
    }

    public static int snakesAndLadders(int[][] board) {
        int length = board.length;
        int arrayLength = board.length * board.length;
        /**
         * 将棋盘方格按照编号排成一列
         */
        int[] boardArray = new int[arrayLength];
        /**
         * dp[i]表示走到编号为i+1（索引为i）的方格最少需要的步数
         */
        int[] dp = new int[arrayLength];
        /**
         * 初始化走到所有方格需要的步数都为Integer.MAX_VALUE
         */
        Arrays.fill(dp, Integer.MAX_VALUE);
        /**
         * 从索引为0的方格出发，所以初始化dp[0]为0
         */
        dp[0] = 0;
        /**
         * 将棋盘方格按照编号排成一列
         */
        for (int i = 0; i < length; i++) {
            int row = length - i - 1;

            for (int j = 0; j < length; j++) {
                /**
                 * 如果i为偶数，就是从棋盘的左边向右边走，否则就是从棋盘的右边向左边走
                 */
                boardArray[i * length + j] = (i & 1) == 0 ? board[row][j] : board[row][length - 1 - j];
            }
        }
        /**
         * 可能需要对dp进行arrayLength次计算，因为在走到索引较大的方格后，可能重新回到索引较小的
         * 方格，从而使得索引较小的方格用更少的步数就能走到
         */
        for (int k = 0; k < arrayLength; k++) {
            for (int i = 0; i < arrayLength; i++) {
                for (int j = 1; j <= 6; j++) {
                    /**
                     * 如果索引为i的方格目前无法走到或者从索引为i的方格出发走j步出了棋盘，都不再
                     * 继续考虑从这个方格出发的情况
                     */
                    if (dp[i] == Integer.MAX_VALUE || i + j >= arrayLength) {
                        break;
                    }
                    /**
                     * 从索引为i的方格出发走j步到到达索引为s的方格
                     */
                    int s = boardArray[i + j] == -1 ? i + j : boardArray[i + j] - 1;
                    /**
                     * 更新走到索引为s的方格最少需要的步数
                     */
                    dp[s] = Math.min(dp[s], dp[i] + 1);
                }
            }
        }
        return dp[arrayLength - 1] == Integer.MAX_VALUE ? -1 : dp[arrayLength - 1];
    }
}
