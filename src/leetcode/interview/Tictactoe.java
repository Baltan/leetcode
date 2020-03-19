package leetcode.interview;

/**
 * Description: 面试题 16.04. 井字游戏
 *
 * @author Baltan
 * @date 2020-03-19 18:20
 * @see leetcode.algorithms.Tictactoe
 * @see leetcode.algorithms.ValidTicTacToe
 */
public class Tictactoe {
    public static void main(String[] args) {
        String[] board1 = {"O X", " XO", "X O"};
        System.out.println(tictactoe(board1));

        String[] board2 = {"OOX", "XXO", "OXO"};
        System.out.println(tictactoe(board2));

        String[] board3 = {"OOX", "XXO", "OX "};
        System.out.println(tictactoe(board3));

        String[] board4 = {"   O", "X OX", " O  ", "O  X"};
        System.out.println(tictactoe(board4));
    }

    public static String tictactoe(String[] board) {
        int length = board.length;
        /**
         * 棋盘上剩余的空位数
         */
        int leftPositions = length * length;
        int[][] grid = new int[length][length];

        for (int i = 0; i < length; i++) {
            String s = board[i];

            for (int j = 0; j < length; j++) {
                char c = s.charAt(j);
                /**
                 * 放字符"O"时，在grid对应位置填1；放字符"X"时，在grid对应位置填-1
                 */
                if (c == 'O') {
                    grid[i][j] = 1;
                    leftPositions--;
                } else if (c == 'X') {
                    grid[i][j] = -1;
                    leftPositions--;
                }
            }
        }
        return judge(grid, leftPositions);
    }

    public static String judge(int[][] grid, int leftPositions) {
        int length = grid.length;

        for (int i = 0; i < length; i++) {
            /**
             * 当前行所有元素的和
             */
            int rowSum = 0;
            /**
             * 当前列所有元素的和
             */
            int colSum = 0;

            for (int j = 0; j < length; j++) {
                rowSum += grid[i][j];
                colSum += grid[j][i];
            }
            /**
             * 如果当前行或当前列所有元素的和为length，说明该行或该列放的都是"O"，返回"O"
             */
            if (rowSum == length || colSum == length) {
                return "O";
            }
            /**
             * 如果当前行或当前列所有元素的和为-length，说明该行或该列放的都是"X"，返回"X"
             */
            if (rowSum == -length || colSum == -length) {
                return "X";
            }
        }
        /**
         * 主对角线所有元素的和
         */
        int diagonalSum1 = 0;
        /**
         * 副对角线所有元素的和
         */
        int diagonalSum2 = 0;

        for (int i = 0; i < length; i++) {
            diagonalSum1 += grid[i][i];
            diagonalSum2 += grid[i][length - 1 - i];
        }
        /**
         * 如果某条对角线所有元素的和为length，说明该对角线放的都是"O"，返回"O"
         */
        if (diagonalSum1 == length || diagonalSum2 == length) {
            return "O";
        }
        /**
         * 如果某条对角线所有元素的和为length，说明该对角线放的都是"X"，返回"X"
         */
        if (diagonalSum1 == -length || diagonalSum2 == -length) {
            return "X";
        }
        /**
         * 如果棋盘上还有剩余的空位，游戏未结束，返回"Pending"，否则返回"Draw"
         */
        return leftPositions == 0 ? "Draw" : "Pending";
    }
}
