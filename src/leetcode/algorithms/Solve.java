package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 130. Surrounded Regions
 *
 * @author Baltan
 * @date 2019-05-27 13:53
 */
public class Solve {
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
         * 记录所有最终不会变为"X"的"O"的位置，即所有边界上的"O"或与边界上的"O"相连的且不在边界上的"O"的位置
         */
        boolean[][] book = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        /**
         * 查找上边界和下边界上的"O"
         */
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
            }

            if (board[rows - 1][i] == 'O') {
                queue.add(new int[]{rows - 1, i});
            }
        }
        /**
         * 查找左边界和右边界上的"O"
         */
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
            }

            if (board[i][cols - 1] == 'O') {
                queue.add(new int[]{i, cols - 1});
            }
        }
        /**
         * 广度优先搜索所有不在边界上且可以与边界上的"O"相连的"O"
         */
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();

            for (int[] direction : directions) {
                int x = coordinate[0] + direction[0];
                int y = coordinate[1] + direction[1];

                if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O' && !book[x][y]) {
                    book[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
        /**
         * 将剩余的不在book中的"O"变为"X"
         */
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == 'O' && !book[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
