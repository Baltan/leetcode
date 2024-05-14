package leetcode.algorithms;

/**
 * Description: 3142. Check if Grid Satisfies Conditions
 *
 * @author Baltan
 * @date 2024/5/14 22:18
 */
public class SatisfiesConditions {
    public static void main(String[] args) {
        System.out.println(satisfiesConditions(new int[][]{{1, 0, 2}, {1, 0, 2}}));
        System.out.println(satisfiesConditions(new int[][]{{1, 1, 1}, {0, 0, 0}}));
        System.out.println(satisfiesConditions(new int[][]{{1}, {2}, {3}}));
    }

    public static boolean satisfiesConditions(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * grid[i][j]如果和下面单元格的数字不同，则直接返回false
                 */
                if (i + 1 < rows && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                /**
                 * grid[i][j]如果和右边单元格的数字相同，则直接返回true
                 */
                if (j + 1 < cols && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
