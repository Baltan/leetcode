package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1275. Find Winner on a Tic Tac Toe Game
 *
 * @author Baltan
 * @date 2019-12-02 11:55
 * @see leetcode.interview.Tictactoe
 * @see ValidTicTacToe
 */
public class Tictactoe {
    public static void main(String[] args) {
        int[][] moves1 = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        System.out.println(tictactoe(moves1));

        int[][] moves2 = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        System.out.println(tictactoe(moves2));

        int[][] moves3 = {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
        System.out.println(tictactoe(moves3));

        int[][] moves4 = {{0, 0}, {1, 1}};
        System.out.println(tictactoe(moves4));
    }

    public static String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        int length = moves.length;
        /**
         * 剩余的格子数
         */
        int leftPositions = 9;

        for (int i = 0; i < length; i++) {
            /**
             * 如果余数是0，这一步轮到A走，如果余数是1，这一步轮到B走
             */
            int remainder = i & 1;
            int[] position = moves[i];
            /**
             * A在格子中填1，B在格子中填-1
             */
            grid[position[0]][position[1]] = remainder == 0 ? 1 : -1;
            leftPositions--;
        }
        return judge(grid, leftPositions);
    }

    public static String judge(int[][] grid, int leftPositions) {
        Set<Integer> sums = new HashSet<>();

        sums.add(grid[0][0] + grid[0][1] + grid[0][2]);
        sums.add(grid[1][0] + grid[1][1] + grid[1][2]);
        sums.add(grid[2][0] + grid[2][1] + grid[2][2]);
        sums.add(grid[0][0] + grid[1][0] + grid[2][0]);
        sums.add(grid[0][1] + grid[1][1] + grid[2][1]);
        sums.add(grid[0][2] + grid[1][2] + grid[2][2]);
        sums.add(grid[0][0] + grid[1][1] + grid[2][2]);
        sums.add(grid[0][2] + grid[1][1] + grid[2][0]);
        /**
         * 如果某一直线的和为3，说明填了三个"1"，A胜；如果某一直线的和为-3，说明填了三个"-1"，B胜；除去上述两种
         * 情况，没有分出胜负，如果还有格子剩余，则游戏未结束，否则游戏以平局结束
         */
        if (sums.contains(3)) {
            return "A";
        } else if (sums.contains(-3)) {
            return "B";
        } else {
            return leftPositions == 0 ? "Draw" : "Pending";
        }
    }
}
