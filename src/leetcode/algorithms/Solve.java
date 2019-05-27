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
        if (board == null || board.length == 0) {
            return;
        }

        int length = board.length;
        int width = board[0].length;
        boolean[][] book = new boolean[length][width];
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < width; i++) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
            }

            if (board[length - 1][i] == 'O') {
                queue.add(new int[]{length - 1, i});
            }
        }

        for (int i = 1; i < length - 1; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
            }

            if (board[i][width - 1] == 'O') {
                queue.add(new int[]{i, width - 1});
            }
        }

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = coordinate[0] + direction[i][0];
                int y = coordinate[1] + direction[i][1];

                if (x >= 0 && x < length && y >= 0 && y < width && board[x][y] == 'O' && !book[x][y]) {
                    book[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }

        for (int i = 1; i < length - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (board[i][j] == 'O' && !book[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
