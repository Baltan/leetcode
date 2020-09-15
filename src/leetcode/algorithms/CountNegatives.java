package leetcode.algorithms;

/**
 * Description: 1351. Count Negative Numbers in a Sorted Matrix
 *
 * @author Baltan
 * @date 2020-09-15 17:25
 */
public class CountNegatives {
    public static void main(String[] args) {
        int[][] grid1 = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(countNegatives(grid1));

        int[][] grid2 = {{3, 2}, {1, 0}};
        System.out.println(countNegatives(grid2));

        int[][] grid3 = {{1, -1}, {-1, -1}};
        System.out.println(countNegatives(grid3));

        int[][] grid4 = {{-1}};
        System.out.println(countNegatives(grid4));
    }

    public static int countNegatives(int[][] grid) {
        int result = 0;

        for (int[] row : grid) {
            for (int value : row) {
                if (value < 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
