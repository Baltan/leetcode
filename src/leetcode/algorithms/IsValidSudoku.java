package leetcode.algorithms;

/**
 * Description: Valid Sudoku
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
        int rows = board.length;
        boolean[] array;

        for (int i = 0; i < rows; i++) {
            array = new boolean[9];
            for (int j = 0; j < rows; j++) {
                if (board[i][j] != '.' && array[board[i][j] - '1']) {
                    return false;
                }
                if (board[i][j] != '.') {
                    array[board[i][j] - '1'] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            array = new boolean[9];
            for (int j = 0; j < rows; j++) {
                if (board[j][i] != '.' && array[board[j][i] - '1']) {
                    return false;
                }
                if (board[j][i] != '.') {
                    array[board[j][i] - '1'] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            int rowIdxStart = i / 3 * 3;
            int colIdxStart = i % 3 * 3;
            array = new boolean[9];
            for (int j = rowIdxStart; j < rowIdxStart + 3; j++) {
                for (int k = colIdxStart; k < colIdxStart + 3; k++) {
                    if (board[j][k] != '.' && array[board[j][k] - '1']) {
                        return false;
                    }
                    if (board[j][k] != '.') {
                        array[board[j][k] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}
