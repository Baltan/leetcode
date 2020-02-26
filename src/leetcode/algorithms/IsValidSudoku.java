package leetcode.algorithms;

/**
 * Description: 36. Valid Sudoku
 *
 * @author Baltan
 * @date 2018/9/3 10:58
 */
public class IsValidSudoku {
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
        System.out.println(isValidSudoku(board1));

        char[][] board2 =
                {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board2));
    }

    public static boolean isValidSudoku(char[][] board) {
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
                if (board[rowIndex][colIndex] == '.') {
                    continue;
                }
                /**
                 * 第rowIndex行colIndex列的格子所在的3×3宫格的索引
                 */
                int blockIndex = rowIndex / 3 * 3 + colIndex / 3;
                int value = board[rowIndex][colIndex] - '0';
                /**
                 * 如果第rowIndex行或第colIndex列或第blockIndex个3×3宫格已经存在value了，
                 * 则这个数独就是无效的
                 */
                if (rowFlags[rowIndex][value] || colFlags[colIndex][value] || blockFlags[blockIndex][value]) {
                    return false;
                }
                /**
                 * 标记第rowIndex行已经有value这个值
                 */
                rowFlags[rowIndex][value] = true;
                /**
                 * 标记第colIndex列已经有value这个值
                 */
                colFlags[colIndex][value] = true;
                /**
                 * 标记第blockIndex个3×3宫格已经有value这个值
                 */
                blockFlags[blockIndex][value] = true;
            }
        }
        return true;
    }
}
