package leetcode.interview;

import leetcode.algorithms.TotalNQueens;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Description: 面试题 08.12. 八皇后
 *
 * @author Baltan
 * @date 2020-01-03 11:54
 * @see TotalNQueens
 * @see leetcode.algorithms.SolveNQueens
 */
public class SolveNQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(8));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        int[][] board = new int[n][n];
        /**
         * 已经放在棋盘上的皇后的坐标集合
         */
        Set<Point> queenCoordinates = new HashSet<>();
        dfs(result, board, queenCoordinates, n, 0);
        return result;
    }

    /**
     * 在索引为row的行放皇后
     *
     * @param result
     * @param board
     * @param queenCoordinates
     * @param n
     * @param row
     */
    public static void dfs(List<List<String>> result, int[][] board, Set<Point> queenCoordinates, int n,
                           int row) {
        /**
         * 如果当前要放置索引为row行的皇后，说明棋盘上已经按要求放了row行的皇后，已满足题目要求，将当前
         * 的放法加入result
         */
        if (row == n) {
            List<String> list = new LinkedList<>();

            for (int[] values : board) {
                StringBuilder builder = new StringBuilder(n);

                for (int value : values) {
                    if (value == 0) {
                        builder.append('.');
                    } else {
                        builder.append('Q');
                    }
                }
                list.add(builder.toString());
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canPlace(queenCoordinates, row, i)) {
                /**
                 * 在坐标为(row,i)的位置放皇后
                 */
                board[row][i] = 1;
                queenCoordinates.add(new Point(row, i));
                /**
                 * 继续在索引为row+1的行放皇后
                 */
                dfs(result, board, queenCoordinates, n, row + 1);
                queenCoordinates.remove(new Point(row, i));
                /**
                 * 移除坐标为(row,i)的位置的皇后
                 */
                board[row][i] = 0;
            }
        }
    }

    /**
     * 判断在坐标为(row,col)的位置是否可以放皇后
     *
     * @param queenCoordinates
     * @param row
     * @param col
     * @return
     */
    public static boolean canPlace(Set<Point> queenCoordinates, int row, int col) {
        for (Point queenCoordinate : queenCoordinates) {
            int x = queenCoordinate.x;
            int y = queenCoordinate.y;
            /**
             * 如果在同一行、同一列、同一主对角线或同一副对角线已经放过皇后，则在该位置不能再放皇后
             */
            if (x == row || y == col || x + y == row + col || x - y == row - col) {
                return false;
            }
        }
        return true;
    }
}
