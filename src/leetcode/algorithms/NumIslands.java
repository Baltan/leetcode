package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 200. Number of Islands
 *
 * @author Baltan
 * @date 2019-06-06 09:56
 */
public class NumIslands {
    public static void main(String[] args) {
        char[][] grid1 =
                {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0'
                        , '0', '0', '0', '0'}};
        System.out.println(numIslands(grid1));

        char[][] grid2 =
                {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0'
                        , '0', '0', '1', '1'}};
        System.out.println(numIslands(grid2));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] book = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !book[i][j]) {
                    result++;
                    queue.offer(new int[]{i, j});
                    book[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] coordinate = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = coordinate[0] + directions[k][0];
                            int y = coordinate[1] + directions[k][1];

                            if (x >= 0 && x < rows && y >= 0 && y < cols && !book[x][y] &&
                                    grid[x][y] == '1') {
                                queue.offer(new int[]{x, y});
                                book[x][y] = true;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
