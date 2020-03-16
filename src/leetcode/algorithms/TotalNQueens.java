package leetcode.algorithms;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 52. N-Queens II
 *
 * @author Baltan
 * @date 2020-01-03 13:31
 * @see SolveNQueens
 * @see leetcode.interview.SolveNQueens
 */
public class TotalNQueens {
    public static int result;

    public static void main(String[] args) {
        System.out.println(totalNQueens(1));
        System.out.println(totalNQueens(2));
        System.out.println(totalNQueens(3));
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(5));
        System.out.println(totalNQueens(6));
        System.out.println(totalNQueens(7));
        System.out.println(totalNQueens(8));
        System.out.println(totalNQueens(9));
        System.out.println(totalNQueens(10));
        System.out.println(totalNQueens(11));
        System.out.println(totalNQueens(12));
    }

    public static int totalNQueens(int n) {
        /**
         * 因为result设置为了static变量，所以每次计算时需要初始化为0
         */
        result = 0;
        int[][] board = new int[n][n];
        /**
         * 已经放在棋盘上的皇后的坐标集合
         */
        Set<Point> queenCoordinates = new HashSet<>();
        dfs(board, queenCoordinates, n, 0);
        return result;
    }

    /**
     * 在索引为row的行放皇后
     *
     * @param board
     * @param queenCoordinates
     * @param n
     * @param row
     */
    public static void dfs(int[][] board, Set<Point> queenCoordinates, int n,
                           int row) {
        /**
         * 如果当前要放置索引为row行的皇后，说明棋盘上已经按要求放了row行的皇后，已满足题目要求，将
         * result加1
         */
        if (row == n) {
            result++;
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
                dfs(board, queenCoordinates, n, row + 1);
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
