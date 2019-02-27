package leetcode.algorithms;

/**
 * Description: Max Area of Island
 *
 * @author Baltan
 * @date 2018/8/7 15:11
 */
public class MaxAreaOfIsland1 {

    public static void main(String[] args) {
        int[][] grid1 = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid1));

        int[][] grid2 = {{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid2));

        int[][] grid3 = {{1}};
        System.out.println(maxAreaOfIsland(grid3));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int area;
        int maxArea = 0;
        int[][] book = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && book[i][j] == 0) {
                    book[i][j] = 1;
                    area = dfs(grid, i, j, 1, book);
                    maxArea = area > maxArea ? area : maxArea;
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] grid, int x, int y, int area, int[][] book) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] nextStep = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int nextX;
        int nextY;

        for (int i = 0; i < nextStep.length; i++) {
            nextX = x + nextStep[i][0];
            nextY = y + nextStep[i][1];

            if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols) {
                continue;
            }

            if (grid[nextX][nextY] == 1 && book[nextX][nextY] == 0) {
                area++;
                book[nextX][nextY] = 1;
                area = dfs(grid, nextX, nextY, area, book);
            }
        }
        return area;
    }
}
