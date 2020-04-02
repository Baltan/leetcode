package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 289. Game of Life
 *
 * @author Baltan
 * @date 2019-06-16 11:53
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board1 = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board1);
        OutputUtils.print2DIntegerArray(board1);
    }

    public static void gameOfLife(int[][] board) {
        if (board != null && board.length > 0 && board[0].length > 0) {
            int rows = board.length;
            int cols = board[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int liveCount = 0;

                    liveCount = isLive(board, i - 1, j - 1) ? liveCount + 1 :
                            liveCount;
                    liveCount = isLive(board, i - 1, j) ? liveCount + 1 :
                            liveCount;
                    liveCount = isLive(board, i - 1, j + 1) ? liveCount + 1 :
                            liveCount;
                    liveCount = isLive(board, i, j - 1) ? liveCount + 1 :
                            liveCount;
                    liveCount = isLive(board, i, j + 1) ? liveCount + 1 :
                            liveCount;
                    liveCount = isLive(board, i + 1, j - 1) ? liveCount + 1 :
                            liveCount;
                    liveCount = isLive(board, i + 1, j) ? liveCount + 1 :
                            liveCount;
                    liveCount = isLive(board, i + 1, j + 1) ? liveCount + 1 :
                            liveCount;

                    if (board[i][j] == 0 && liveCount == 3) {
                        /**
                         * 如果死细胞周围有3个活细胞，则死细胞会复活，将要复活的死细胞用2表示
                         */
                        board[i][j] = 2;
                    } else if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                        /**
                         * 如果活细胞周围的活细胞不足2个或多于3个，则活细胞会死亡，将要死亡的活细胞
                         * 用3表示
                         */
                        board[i][j] = 3;
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 2) {
                        /**
                         * 将复活的死细胞用1表示
                         */
                        board[i][j] = 1;
                    } else if (board[i][j] == 3) {
                        /**
                         * 将死亡的活细胞用0表示
                         */
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    /**
     * 判断某个格子的细胞开始时是否是活着的
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    public static boolean isLive(int[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        /**
         * 如果值为1，说明这个细胞仍活着；如果值为3，说明这个细胞开始时是活着的
         */
        return board[i][j] == 1 || board[i][j] == 3;
    }
}
