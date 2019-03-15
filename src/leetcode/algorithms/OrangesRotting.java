package leetcode.algorithms;

/**
 * Description: Rotting Oranges
 *
 * @author Baltan
 * @date 2019-03-15 15:49
 */
public class OrangesRotting {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid1));

        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(grid2));

        int[][] grid3 = {{0, 2}};
        System.out.println(orangesRotting(grid3));
    }

    public static int orangesRotting(int[][] grid) {
        int time = 0;
        int length = grid.length;
        int width = grid[0].length;

        while (true) {
            boolean turnRotten = false;

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (grid[i][j] == 2) {
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 3;
                            turnRotten = true;
                        }
                        if (i + 1 < length && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 3;
                            turnRotten = true;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 3;
                            turnRotten = true;
                        }
                        if (j + 1 < width && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 3;
                            turnRotten = true;
                        }
                    }
                }
            }
            if (turnRotten) {
                time++;
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < width; j++) {
                        if (grid[i][j] == 3) {
                            grid[i][j] = 2;
                        }
                    }
                }
            } else {
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < width; j++) {
                        if (grid[i][j] == 1) {
                            return -1;
                        }
                    }
                }
                return time;
            }
        }
    }
}
