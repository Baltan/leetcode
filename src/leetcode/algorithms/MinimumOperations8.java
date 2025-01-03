package leetcode.algorithms;

/**
 * Description: 3402. Minimum Operations to Make Columns Strictly Increasing
 *
 * @author Baltan
 * @date 2025/1/3 23:53
 */
public class MinimumOperations8 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[][]{{3, 2}, {1, 3}, {3, 4}, {0, 1}}));
        System.out.println(minimumOperations(new int[][]{{3, 2, 1}, {2, 1, 0}, {1, 2, 3}}));
    }

    public static int minimumOperations(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                /**
                 * 如果要让grid[j][i]大于grid[j-1][i]，grid[j][i]至少要增加increment
                 */
                int increment = Math.max(grid[j - 1][i] + 1 - grid[j][i], 0);
                result += increment;
                grid[j][i] += increment;
            }
        }
        return result;
    }
}
