package leetcode.algorithms;

/**
 * Description: 463. Island Perimeter
 *
 * @author Baltan
 * @date 2018/7/31 11:18
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid1));

        int[][] grid2 = {{}, {}};
        System.out.println(islandPerimeter(grid2));
    }

    public static int islandPerimeter(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    /**
                     * 如果当前格子为陆地且下方格子也为陆地，则它们的交接的边要被减掉
                     */
                    if (i < rows - 1 && grid[i + 1][j] == 1) {
                        result -= 2;
                    }
                    /**
                     * 如果当前格子为陆地且右方格子也为陆地，则它们的交接的边要被减掉
                     */
                    if (j < cols - 1 && grid[i][j + 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}
