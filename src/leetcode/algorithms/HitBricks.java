package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 803. Bricks Falling When Hit
 *
 * @author Baltan
 * @date 2019-11-29 09:19
 */
public class HitBricks {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 0, 0, 0}, {1, 1, 1, 0}};
        int[][] hits1 = {{1, 0}};
        OutputUtils.print1DIntegerArray(hitBricks(grid1, hits1));

        int[][] grid2 = {{1, 0, 0, 0}, {1, 1, 0, 0}};
        int[][] hits2 = {{1, 1}, {1, 0}};
        OutputUtils.print1DIntegerArray(hitBricks(grid2, hits2));

        int[][] grid3 = {{1, 0, 1}, {1, 1, 1}};
        int[][] hits3 = {{0, 0}, {0, 2}, {1, 1}};
        OutputUtils.print1DIntegerArray(hitBricks(grid3, hits3));
    }

    public static int[] hitBricks(int[][] grid, int[][] hits) {
        int length = hits.length;
        int[] result = new int[length];
        int cols = grid[0].length;

        for (int i = 0; i < length; i++) {
            int[] hitPosition = hits[i];
            int x = hitPosition[0];
            int y = hitPosition[1];

            if (grid[x][y] == 0) {
                continue;
            } else {
                grid[x][y] = 0;
                List<int[]> notDroppedBricks = new LinkedList<>();

                for (int j = 0; j < cols; j++) {
                    if (grid[0][j] == 1) {
                        getNotDroppedBricks(grid, 0, j, notDroppedBricks);
                    }
                }

                result[i] = bricksDrop(grid);
                restoreBricks(grid, notDroppedBricks);
            }
        }
        return result;
    }

    public static void getNotDroppedBricks(int[][] grid, int startX, int startY,
                                           List<int[]> notDroppedBricks) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (startX < 0 || startX >= rows || startY < 0 || startY >= cols || grid[startX][startY] == 0) {
            return;
        }

        grid[startX][startY] = 0;
        notDroppedBricks.add(new int[]{startX, startY});
        getNotDroppedBricks(grid, startX - 1, startY, notDroppedBricks);
        getNotDroppedBricks(grid, startX + 1, startY, notDroppedBricks);
        getNotDroppedBricks(grid, startX, startY - 1, notDroppedBricks);
        getNotDroppedBricks(grid, startX, startY + 1, notDroppedBricks);
    }

    public static int bricksDrop(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    count++;
                }
            }
        }
        return count;
    }

    public static void restoreBricks(int[][] grid, List<int[]> notDroppedBricks) {
        for (int[] notDroppedBrick : notDroppedBricks) {
            int x = notDroppedBrick[0];
            int y = notDroppedBrick[1];
            grid[x][y] = 1;
        }
    }
}
