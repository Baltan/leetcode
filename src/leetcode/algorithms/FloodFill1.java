package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 733. Flood Fill
 *
 * @author Baltan
 * @date 2020-03-16 16:45
 * @see FloodFill
 * @see leetcode.interview.FloodFill
 */
public class FloodFill1 {
    public static void main(String[] args) {
        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        OutputUtils.print2DIntegerArray(floodFill(image1, 1, 1, 2));

        int[][] image2 = {{0, 0, 0}, {0, 1, 1}};
        OutputUtils.print2DIntegerArray(floodFill(image2, 1, 1, 1));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor != image[sr][sc]) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    public static void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;
        dfs(image, row - 1, col, oldColor, newColor);
        dfs(image, row + 1, col, oldColor, newColor);
        dfs(image, row, col - 1, oldColor, newColor);
        dfs(image, row, col + 1, oldColor, newColor);
    }
}
