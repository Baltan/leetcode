package leetcode.algorithms;

/**
 * Description: 807. Max Increase to Keep City Skyline
 *
 * @author Baltan
 * @date 2018/8/11 12:35
 */
public class MaxIncreaseKeepingSkyline {
    public static void main(String[] args) {
        int[][] grid1 = {{}};
        System.out.println(maxIncreaseKeepingSkyline(grid1));

        int[][] grid2 = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(grid2));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int increaseNum = 0;
        int[] rowMaxArray = new int[rows];
        int[] colMaxArray = new int[cols];
        for (int i = 0; i < rows; i++) {
            int rowMax = Integer.MIN_VALUE;
            for (int j = 0; j < cols; j++) {
                rowMax = rowMax >= grid[i][j] ? rowMax : grid[i][j];
            }
            rowMaxArray[i] = rowMax;
        }
        for (int i = 0; i < cols; i++) {
            int colMax = Integer.MIN_VALUE;
            for (int j = 0; j < rows; j++) {
                colMax = colMax >= grid[j][i] ? colMax : grid[j][i];
            }
            colMaxArray[i] = colMax;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] < Math.min(rowMaxArray[i], colMaxArray[j])) {
                    increaseNum += (Math.min(rowMaxArray[i], colMaxArray[j]) - grid[i][j]);
                }
            }
        }
        return increaseNum;
    }
}
