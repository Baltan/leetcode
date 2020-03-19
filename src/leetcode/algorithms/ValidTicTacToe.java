package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 794. Valid Tic-Tac-Toe State
 *
 * @author Baltan
 * @date 2019-10-12 09:26
 * @see leetcode.interview.Tictactoe
 * @see Tictactoe
 */
public class ValidTicTacToe {
    public static void main(String[] args) {
        System.out.println(validTicTacToe(new String[]{"O  ", "   ", "   "}));
        System.out.println(validTicTacToe(new String[]{"XOX", " X ", "   "}));
        System.out.println(validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        System.out.println(validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
        System.out.println(validTicTacToe(new String[]{"XXX", "XOO", "OO "}));
        System.out.println(validTicTacToe(new String[]{"OXX", "XOX", "OXO"}));
    }

    public static boolean validTicTacToe(String[] board) {
        /**
         * 假设游戏版的9个位置编号如下：
         * 1   2   3
         * 4   5   6
         * 7   8   9
         * 相同（且非空）的字符填充任何行、列或对角线时的八种情况
         */
        int[][] oneLineArray =
                {{1, 2, 3}, {1, 4, 7}, {1, 5, 9}, {2, 5, 8}, {3, 5, 7}, {3, 6, 9}, {4, 5, 6}, {7, 8, 9}};
        /**
         * 字符'O'填充的所有位置
         */
        Set<Integer> oPositions = new HashSet<>();
        /**
         * 字符'X'填充的所有位置
         */
        Set<Integer> xPositions = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            char[] charArray = board[i].toCharArray();

            for (int j = 0; j < 3; j++) {
                int position = i * 3 + j + 1;

                if (charArray[j] == 'O') {
                    oPositions.add(position);
                } else if (charArray[j] == 'X') {
                    xPositions.add(position);
                }
            }
        }
        /**
         * 以下几种情况无法实现：
         * 1、字符'X'的数量小于字符'O'
         * 2、字符'X'的数量至少比字符'O'多2个
         * 3、字符'X'和字符'O'都填充某一行、列或对角线
         * 4、字符'X'填充某一行、列或对角线，并且字符'O'的数量和字符'X'相等
         * 5、字符'O'填充某一行、列或对角线，并且字符'O'的数量小于字符'X'
         */
        if (xPositions.size() < oPositions.size() || xPositions.size() - oPositions.size() > 1) {
            return false;
        } else {
            boolean oHasOneLine = hasOneLine(oneLineArray, oPositions);
            boolean xHasOneLine = hasOneLine(oneLineArray, xPositions);

            if (oHasOneLine && xHasOneLine) {
                return false;
            } else if (xHasOneLine && oPositions.size() == xPositions.size()) {
                return false;
            } else if (oHasOneLine && oPositions.size() < xPositions.size()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断相同（且非空）的字符是否填充某一行、列或对角线
     *
     * @param oneLineArray
     * @param positions
     * @return
     */
    public static boolean hasOneLine(int[][] oneLineArray, Set<Integer> positions) {
        for (int[] array : oneLineArray) {
            if (positions.contains(array[0]) && positions.contains(array[1]) &&
                    positions.contains(array[2])) {
                return true;
            }
        }
        return false;
    }
}
