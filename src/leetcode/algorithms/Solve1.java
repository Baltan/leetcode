package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 130. Surrounded Regions
 *
 * @author Baltan
 * @date 2020-08-12 07:51
 * @see Solve
 */
public class Solve1 {
    public static void main(String[] args) {
        char[][] board1 =
                {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board1);
        System.out.println(Arrays.deepToString(board1));

        char[][] board2 = {{'X'}};
        solve(board2);
        System.out.println(Arrays.deepToString(board2));
    }

    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        /**
         * 查找上边界和下边界上的"O"
         */
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, rows, cols, 0, i);
            }

            if (board[rows - 1][i] == 'O') {
                dfs(board, rows, cols, rows - 1, i);
            }
        }
        /**
         * 查找左边界和右边界上的"O"
         */
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, rows, cols, i, 0);
            }

            if (board[i][cols - 1] == 'O') {
                dfs(board, rows, cols, i, cols - 1);
            }
        }
        /**
         * 将剩余的"O"都变成"X"，将"T"变回为"O"
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 深度优先搜索，将所有和边界上的"O"相连的"O"都先变成"T"
     *
     * @param board
     * @param rows
     * @param cols
     * @param x
     * @param y
     */
    public static void dfs(char[][] board, int rows, int cols, int x, int y) {
        if (x < 0 || x == rows || y < 0 || y == cols || board[x][y] != 'O') {
            return;
        }

        board[x][y] = 'T';
        dfs(board, rows, cols, x - 1, y);
        dfs(board, rows, cols, x + 1, y);
        dfs(board, rows, cols, x, y - 1);
        dfs(board, rows, cols, x, y + 1);
    }
}
