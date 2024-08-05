package leetcode.algorithms;

/**
 * Description: 3239. Minimum Number of Flips to Make Binary Grid Palindromic I
 *
 * @author baltan
 * @date 2024/8/5 09:08
 * @see MinFlips5
 */
public class MinFlips4 {
    public static void main(String[] args) {
        System.out.println(minFlips(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println(minFlips(new int[][]{{0, 1}, {0, 1}, {0, 0}}));
        System.out.println(minFlips(new int[][]{{1}, {0}}));
    }

    public static int minFlips(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 如果最终矩阵grid中每行都是回文的，需要的最小翻转次数
         */
        int rowCount = 0;
        /**
         * 如果最终矩阵grid中每列都是回文的，需要的最小翻转次数
         */
        int colCount = 0;
        /**
         * 令矩阵grid中每行都成为回文的
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                rowCount += grid[i][j] == grid[i][cols - 1 - j] ? 0 : 1;
            }
        }
        /**
         * 令矩阵grid中每列都成为回文的
         */
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows / 2; j++) {
                colCount += grid[j][i] == grid[rows - 1 - j][i] ? 0 : 1;
            }
        }
        return Math.min(rowCount, colCount);
    }
}
