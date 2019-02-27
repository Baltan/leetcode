package leetcode.algorithms;

/**
 * Description: Projection Area of 3D Shapes
 *
 * @author Baltan
 * @date 2018/8/5 13:19
 */
public class ProjectionArea {
    public static void main(String[] args) {
        int[][] grid1 = {{2}};
        System.out.println(projectionArea(grid1));

        int[][] grid2 = {{1, 2}, {3, 4}};
        System.out.println(projectionArea(grid2));

        int[][] grid3 = {{1, 0}, {0, 2}};
        System.out.println(projectionArea(grid3));

        int[][] grid4 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(projectionArea(grid4));

        int[][] grid5 = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(projectionArea(grid5));

        int[][] grid6 = {{}};
        System.out.println(projectionArea(grid6));
    }

    public static int projectionArea(int[][] grid) {
        int totalArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] colMaxArray = new int[cols];
        for (int i = 0; i < rows; i++) {
            int rowMax = 0;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    totalArea++;
                }
                rowMax = Math.max(rowMax, grid[i][j]);
                colMaxArray[j] = Math.max(colMaxArray[j], grid[i][j]);
            }
            totalArea += rowMax;
        }
        for (int colMax : colMaxArray) {
            totalArea += colMax;
        }
        return totalArea;
    }
}
