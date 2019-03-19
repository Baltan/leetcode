package leetcode.algorithms;

/**
 * Description: Battleships in a Board
 *
 * @author Baltan
 * @date 2019-03-19 19:43
 */
public class CountBattleships {
    public static void main(String[] args) {
        char[][] board1 = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(countBattleships(board1));
    }

    public static int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }

        int length = board.length;
        int width = board[0].length;
        int shipNum = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'X') {
                    if (i - 1 >= 0 && board[i - 1][j] == 'X') {
                        continue;
                    } else if (j - 1 >= 0 && board[i][j - 1] == 'X') {
                        continue;
                    } else {
                        shipNum++;
                    }
                }
            }
        }
        return shipNum;
    }
}
