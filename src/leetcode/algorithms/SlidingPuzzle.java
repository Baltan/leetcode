package leetcode.algorithms;

import java.util.*;

/**
 * Description: 773. Sliding Puzzle
 *
 * @author Baltan
 * @date 2023/3/9 10:19
 */
public class SlidingPuzzle {
    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println(slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
    }

    public static int slidingPuzzle(int[][] board) {
        int result = 0;
        /**
         * 谜板行数
         */
        int rows = 2;
        /**
         * 谜板列数
         */
        int cols = 3;
        /**
         * 初始状态时数字0的所在行索引
         */
        int zeroRow = 0;
        /**
         * 初始状态时数字0的所在列索引
         */
        int zeroCol = 0;
        /**
         * 谜板最终需要达到的状态
         */
        int[][] standard = new int[][]{{1, 2, 3}, {4, 5, 0}};
        /**
         * 数字0可能和上下左右四个方向的数字交换
         */
        int[][] operations = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        /**
         * 谜板已经达到过的状态
         */
        Set<String> conditions = new HashSet<>();
        Queue<Condition> queue = new LinkedList<>();
        /**
         * 查找初始状态时数字0的索引
         */
        outer:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 0) {
                    zeroRow = i;
                    zeroCol = j;
                    break outer;
                }
            }
        }
        queue.offer(new Condition(board, zeroRow, zeroCol));
        conditions.add(toString(board, rows, cols));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Condition condition = queue.poll();
                /**
                 * 谜板已经为最终需要达到的状态，直接返回
                 */
                if (Arrays.deepEquals(condition.board, standard)) {
                    return result;
                }

                for (int[] operation : operations) {
                    /**
                     * 要交换的数字的行索引
                     */
                    int swapRow = condition.zeroRow + operation[0];
                    /**
                     * 要交换的数字的列索引
                     */
                    int swapCol = condition.zeroCol + operation[1];

                    if (swapRow < 0 || swapRow == rows || swapCol < 0 || swapCol == cols) {
                        continue;
                    }
                    int[][] swapBoard = copy(condition.board, rows, cols);
                    /**
                     * 交换谜板上的数字
                     */
                    swap(swapBoard, condition.zeroRow, condition.zeroCol, swapRow, swapCol);
                    String str = toString(swapBoard, rows, cols);
                    /**
                     * 将新得到的谜板状态加入队列
                     */
                    if (!conditions.contains(str)) {
                        queue.offer(new Condition(swapBoard, swapRow, swapCol));
                        conditions.add(str);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    /**
     * 拷贝二维数组board
     *
     * @param board
     * @param rows
     * @param cols
     * @return
     */
    public static int[][] copy(int[][] board, int rows, int cols) {
        int[][] copy = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    /**
     * 将二维数组board中的元素转换为字符串
     *
     * @param board
     * @param rows
     * @param cols
     * @return
     */
    public static String toString(int[][] board, int rows, int cols) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                builder.append(board[i][j]);
            }
        }
        return builder.toString();
    }

    /**
     * 交换谜板上的数字
     *
     * @param board
     * @param row
     * @param col
     * @param swapRow
     * @param swapCol
     */
    public static void swap(int[][] board, int row, int col, int swapRow, int swapCol) {
        int temp = board[row][col];
        board[row][col] = board[swapRow][swapCol];
        board[swapRow][swapCol] = temp;
    }

    /**
     * 谜板状态对象
     */
    private static class Condition {
        private int[][] board;
        /**
         * 数字0的所在行索引
         */
        private int zeroRow;
        /**
         * 数字0的所在列索引
         */
        private int zeroCol;

        public Condition(int[][] board, int zeroRow, int zeroCol) {
            this.board = board;
            this.zeroRow = zeroRow;
            this.zeroCol = zeroCol;
        }
    }
}
