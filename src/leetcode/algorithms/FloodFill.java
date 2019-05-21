package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 733. Flood Fill
 *
 * @author Baltan
 * @date 2019-05-11 16:16
 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        OutputUtils.print2DIntegerArray(floodFill(image1, 1, 1, 2));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] newImage = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] book = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] grid = queue.poll();
            int row = grid[0];
            int col = grid[1];
            book[row][col] = true;
            newImage[row][col] = newColor;

            for (int i = 0; i < 4; i++) {
                int[] nextStep = directions[i];
                int nextRow = row + nextStep[0];
                int nextCol = col + nextStep[1];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols &&
                        !book[nextRow][nextCol] && image[nextRow][nextCol] == image[row][col]) {
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!book[i][j]) {
                    newImage[i][j] = image[i][j];
                }
            }
        }
        return newImage;
    }
}
