package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix
 *
 * @author Baltan
 * @date 2023/2/27 17:10
 */
public class MinFlips3 {
    public static void main(String[] args) {
        System.out.println(minFlips(new int[][]{{1}}));
        System.out.println(minFlips(new int[][]{{0, 0}, {0, 1}}));
        System.out.println(minFlips(new int[][]{{0}}));
        System.out.println(minFlips(new int[][]{{1, 0, 0}, {1, 0, 0}}));
    }

    private static int result;

    public static int minFlips(int[][] mat) {
        result = Integer.MAX_VALUE;
        int rows = mat.length;
        int cols = mat[0].length;
        /**
         * 最终需要达到的全零矩阵状态
         */
        int[][] standard = new int[rows][cols];
        /**
         * isVisited[i][j]表示格子mat[i][j]是否被翻转过
         */
        boolean[][] isVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(mat, standard, isVisited, rows, cols, i, j, 0);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 回溯计算每次翻转的格子
     *
     * @param mat
     * @param standard
     * @param isVisited
     * @param rows
     * @param cols
     * @param x
     * @param y
     * @param count     已经反转的次数
     */
    public static void dfs(int[][] mat, int[][] standard, boolean[][] isVisited, int rows, int cols, int x, int y, int count) {
        /**
         * 矩阵mat已变成全零矩阵
         */
        if (Arrays.deepEquals(mat, standard)) {
            result = Math.min(result, count);
        }

        if (isVisited[x][y]) {
            return;
        }
        isVisited[x][y] = true;
        /**
         * 翻转格子mat[x][y]
         */
        convert(mat, rows, cols, x, y);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(mat, standard, isVisited, rows, cols, i, j, count + 1);
            }
        }
        /**
         * 恢复格子mat[x][y]
         */
        convert(mat, rows, cols, x, y);
        isVisited[x][y] = false;
    }

    /**
     * 翻转格子mat[x][y]
     *
     * @param mat
     * @param rows
     * @param cols
     * @param x
     * @param y
     */
    public static void convert(int[][] mat, int rows, int cols, int x, int y) {
        mat[x][y] = 1 - mat[x][y];

        if (x - 1 >= 0) {
            mat[x - 1][y] = 1 - mat[x - 1][y];
        }

        if (x + 1 < rows) {
            mat[x + 1][y] = 1 - mat[x + 1][y];
        }

        if (y - 1 >= 0) {
            mat[x][y - 1] = 1 - mat[x][y - 1];
        }

        if (y + 1 < cols) {
            mat[x][y + 1] = 1 - mat[x][y + 1];
        }
    }
}
