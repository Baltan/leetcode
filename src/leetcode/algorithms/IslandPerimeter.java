package leetcode.algorithms;

/**
 * Description: 463. Island Perimeter
 *
 * @author Baltan
 * @date 2018/7/31 11:18
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] arr1 = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(arr1));
        int[][] arr2 = {{}, {}};
        System.out.println(islandPerimeter(arr2));
    }

    public static int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalPerimeter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalPerimeter += 4;
                    if (i < rows - 1) {
                        if (grid[i + 1][j] == 1) {
                            totalPerimeter -= 2;
                        }
                    }
                    if (j < cols - 1) {
                        if (grid[i][j + 1] == 1) {
                            totalPerimeter -= 2;
                        }
                    }
                }
            }
        }
        return totalPerimeter;
    }
}
