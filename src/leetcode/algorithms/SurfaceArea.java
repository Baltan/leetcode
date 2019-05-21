package leetcode.algorithms;

/**
 * Description: 892. Surface Area of 3D Shapes
 *
 * @author Baltan
 * @date 2018/8/28 10:31
 */
public class SurfaceArea {
    public static void main(String[] args) {
        int[][] grid1 = {{2}};
        System.out.println(surfaceArea(grid1));
        int[][] grid2 = {{1, 2}, {3, 4}};
        System.out.println(surfaceArea(grid2));
        int[][] grid3 = {{1, 0}, {0, 2}};
        System.out.println(surfaceArea(grid3));
        int[][] grid4 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(surfaceArea(grid4));
        int[][] grid5 = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(surfaceArea(grid5));
    }

    public static int surfaceArea(int[][] grid) {
        int totalArea = 0;
        int length = grid.length;
        int width = grid[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] > 0) {
                    totalArea += 2;
                }
                if (i == 0) {
                    totalArea += grid[i][j];
                } else {
                    totalArea += Math.max(grid[i][j] - grid[i - 1][j], 0);
                }
                if (i == length - 1) {
                    totalArea += grid[i][j];
                } else {
                    totalArea += Math.max(grid[i][j] - grid[i + 1][j], 0);
                }
                if (j == 0) {
                    totalArea += grid[i][j];
                } else {
                    totalArea += Math.max(grid[i][j] - grid[i][j - 1], 0);
                }
                if (j == width - 1) {
                    totalArea += grid[i][j];
                } else {
                    totalArea += Math.max(grid[i][j] - grid[i][j + 1], 0);
                }
            }
        }
        return totalArea;
    }
}
