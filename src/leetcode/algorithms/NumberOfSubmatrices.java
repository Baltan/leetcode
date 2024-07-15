package leetcode.algorithms;

/**
 * Description: 3212. Count Submatrices With Equal Frequency of X and Y
 *
 * @author Baltan
 * @date 2024/7/14 18:37
 */
public class NumberOfSubmatrices {
    public static void main(String[] args) {
        char[][] grid1 = {
                {'X', 'Y', '.'},
                {'Y', '.', '.'}
        };
        System.out.println(numberOfSubmatrices(grid1));

        char[][] grid2 = {
                {'X', 'X'},
                {'X', 'Y'}
        };
        System.out.println(numberOfSubmatrices(grid2));

        char[][] grid3 = {
                {'.', '.'},
                {'.', '.'}
        };
        System.out.println(numberOfSubmatrices(grid3));
    }

    public static int numberOfSubmatrices(char[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j][0]、dp[i][j][1]分别表示左上角为grid[0][0]，右下角为grid[i-1][j-1]的这部分矩形中"X"、"Y"的数量
         */
        int[][][] dp = new int[rows + 1][cols + 1][2];

        for (int i = 0; i < rows; i++) {
            /**
             * grid[i]行前缀中"X"的个数
             */
            int countX = 0;
            /**
             * grid[i]行前缀中"Y"的个数
             */
            int countY = 0;

            for (int j = 0; j < cols; j++) {
                countX += grid[i][j] == 'X' ? 1 : 0;
                countY += grid[i][j] == 'Y' ? 1 : 0;
                /**
                 * 左上角为grid[0][0]，右下角为grid[i][j]的这部分矩形中"X"的数量为左上角为grid[0][0]，右下角为grid[i-1][j]的这部分
                 * 矩形中"X"的数量，加上grid[i]行前缀中"X"的数量
                 */
                dp[i + 1][j + 1][0] = dp[i][j + 1][0] + countX;
                /**
                 * 左上角为grid[0][0]，右下角为grid[i][j]的这部分矩形中"Y"的数量为左上角为grid[0][0]，右下角为grid[i-1][j]的这部分
                 * 矩形中"Y"的数量，加上grid[i]行前缀中"Y"的数量
                 */
                dp[i + 1][j + 1][1] = dp[i][j + 1][1] + countY;
                result += (dp[i + 1][j + 1][0] > 0 && dp[i + 1][j + 1][0] == dp[i + 1][j + 1][1]) ? 1 : 0;
            }
        }
        return result;
    }
}
