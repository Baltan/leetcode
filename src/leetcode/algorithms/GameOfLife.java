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
                        board[i][j] = 2;
                    } else if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                        board[i][j] = 3;
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 2) {
                        board[i][j] = 1;
                    } else if (board[i][j] == 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static boolean isLive(int[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        return board[i][j] == 1 || board[i][j] == 3;
    }
}
