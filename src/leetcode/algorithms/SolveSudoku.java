package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 37. Sudoku Solver
 *
 * @author Baltan
 * @date 2020-02-26 12:14
 */
public class SolveSudoku {
    public static void main(String[] args) {
        char[][] board1 =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board1);
        System.out.println(Arrays.deepToString(board1));
    }

    /**
     * 标记是否已经完成数独
     */
    public static boolean isCompleted;

    public static void solveSudoku(char[][] board) {
        isCompleted = false;
        /**
         * 数独的维度，即横竖都有9个格子
         */
        int dimension = 9;
        /**
         * rowFlags[i][j]表示第i行是否有j这个值
         */
        boolean[][] rowFlags = new boolean[dimension][dimension + 1];
        /**
         * colFlags[i][j]表示第i列是否有j这个值
         */
        boolean[][] colFlags = new boolean[dimension][dimension + 1];
        /**
         * blockFlags[i][j]表示第i个3×3宫格中是否有j这个值
         */
        boolean[][] blockFlags = new boolean[dimension][dimension + 1];

        for (int rowIndex = 0; rowIndex < dimension; rowIndex++) {
            for (int colIndex = 0; colIndex < dimension; colIndex++) {
                if (board[rowIndex][colIndex] != '.') {
                    int value = board[rowIndex][colIndex] - '0';
                    /**
                     * 第rowIndex行colIndex列的格子所在的3×3宫格的索引
                     */
                    int blockIndex = rowIndex / 3 * 3 + colIndex / 3;
                    rowFlags[rowIndex][value] = true;
                    colFlags[colIndex][value] = true;
                    blockFlags[blockIndex][value] = true;
                }
            }
        }
        dfs(board, rowFlags, colFlags, blockFlags, 0, 0, dimension);
    }

    public static void dfs(char[][] board, boolean[][] rowFlags, boolean[][] colFlags, boolean[][] blockFlags,
                           int rowIndex, int colIndex, int dimension) {
        /**
         * 如果当前要填写第dimension行的格子，说明所有格子都已经被填完，数独已完成
         */
        if (rowIndex == dimension) {
            isCompleted = true;
            return;
        }
        /**
         * 如果当前格子已经有数字，继续填写下一个格子
         */
        if (Character.isDigit(board[rowIndex][colIndex])) {
            if (colIndex == dimension - 1) {
                colIndex = 0;
                rowIndex++;
            } else {
                colIndex++;
            }
            dfs(board, rowFlags, colFlags, blockFlags, rowIndex, colIndex, dimension);
        } else {
            /**
             * 尝试将1-9填到当前格子中
             */
            for (int i = 1; i <= dimension; i++) {
                /**
                 * 第rowIndex行colIndex列的格子所在的3×3宫格的索引
                 */
                int blockIndex = rowIndex / 3 * 3 + colIndex / 3;
                /**
                 * 只有当第rowIndex行，第colIndex列，第blockIndex个3×3宫格都没有当前值i的时
                 * 候，才尝试将i填到这个格子里
                 */
                if (!rowFlags[rowIndex][i] && !colFlags[colIndex][i] && !blockFlags[blockIndex][i]) {
                    board[rowIndex][colIndex] = (char) (i + '0');
                    /**
                     * 标记第rowIndex行已经有i这个值
                     */
                    rowFlags[rowIndex][i] = true;
                    /**
                     * 标记第colIndex列已经有i这个值
                     */
                    colFlags[colIndex][i] = true;
                    /**
                     * 标记第blockIndex个3×3宫格已经有i这个值
                     */
                    blockFlags[blockIndex][i] = true;
                    /**
                     * 下一个要尝试填写的格子的行索引
                     */
                    int nextRowIndex;
                    /**
                     * 下一个要尝试填写的格子的列索引
                     */
                    int nextColIndex;

                    if (colIndex == dimension - 1) {
                        nextRowIndex = rowIndex + 1;
                        nextColIndex = 0;
                    } else {
                        nextRowIndex = rowIndex;
                        nextColIndex = colIndex + 1;
                    }

                    dfs(board, rowFlags, colFlags, blockFlags, nextRowIndex, nextColIndex, dimension);
                    /**
                     * 如果数独已经完成了，就不再尝试其他情况了，直接返回
                     */
                    if (isCompleted) {
                        return;
                    }
                    /**
                     * 还原到第rowIndex行colIndex列的格子填入数字i前的状态，继续尝试下一个值
                     */
                    rowFlags[rowIndex][i] = false;
                    colFlags[colIndex][i] = false;
                    blockFlags[blockIndex][i] = false;
                    board[rowIndex][colIndex] = '.';
                }
            }
        }
    }
}
