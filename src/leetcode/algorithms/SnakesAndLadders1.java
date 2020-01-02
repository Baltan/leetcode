package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 909. Snakes and Ladders
 *
 * @author Baltan
 * @date 2020-01-02 11:19
 */
public class SnakesAndLadders1 {
    public static void main(String[] args) {
        int[][] board1 = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        System.out.println(snakesAndLadders(board1));

        int[][] board2 = {{-1, -1}, {-1, 4}};
        System.out.println(snakesAndLadders(board2));

        int[][] board3 = {{1, 1, -1}, {1, 1, 1}, {-1, 1, 1}};
        System.out.println(snakesAndLadders(board3));

        int[][] board4 =
                {{-1, 42, 12, -1, 1, -1, -1}, {-1, -1, 5, -1, -1, 46, 44}, {18, 22, 6, 39, -1, -1, -1},
                        {-1, -1, 40, -1, -1, -1, 37}, {49, 38, 24, -1, 14, 29, -1},
                        {-1, -1, 6, -1, -1, -1, 20}, {-1, -1, 12, 10, -1, 5, 26}};
        System.out.println(snakesAndLadders(board4));

        int[][] board5 = {{-1, -1, -1, -1}, {-1, -1, -1, 1}, {-1, -1, -1, -1}, {-1, 11, -1, -1}};
        System.out.println(snakesAndLadders(board5));

        int[][] board6 =
                {{-1, -1, -1, -1, 48, 5, -1}, {12, 29, 13, 9, -1, 2, 32}, {-1, -1, 21, 7, -1, 12, 49},
                        {42, 37, 21, 40, -1, 22, 12}, {42, -1, 2, -1, -1, -1, 6},
                        {39, -1, 35, -1, -1, 39, -1}, {-1, 36, -1, -1, -1, -1, 5}};
        System.out.println(snakesAndLadders(board6));

        int[][] board7 = {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, 41, 43, -1, -1, -1, -1, -1, -1, -1, 107}, {99,
                82, -1, 113, 72, -1, -1, -1, -1, 136, -1, 92},
                {-1, -1, -1, 86, -1, -1, -1, 60, 49, 105, -1, -1},
                {-1, -1, 23, 40, -1, -1, -1, -1, -1, 140, -1, -1},
                {-1, -1, 79, -1, 7, 57, 117, 35, -1, -1, -1, 125},
                {-1, 98, -1, 2, -1, -1, -1, -1, -1, -1, 38, -1},
                {3, -1, -1, -1, -1, 8, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 1, -1, -1, 7, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 131, 75, 103, -1, 16, -1},
                {-1, -1, -1, -1, -1, 118, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 119, -1, -1, -1, -1, -1, -1, -1}};
        System.out.println(snakesAndLadders(board7));

        int[][] board8 = {{-1, -1, -1, 190, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 47, -1, -1, -1, -1, -1, -1, -1, -1, 117, -1},
                {-1, -1, -1, -1, -1, 154, 136, -1, -1, -1, -1, -1, -1, -1, -1},
                {215, 47, -1, -1, -1, -1, -1, 114, -1, -1, -1, -1, -1, -1, -1},
                {131, -1, -1, 15, 131, -1, -1, 175, 153, -1, -1, -1, -1, -1, -1},
                {206, -1, -1, -1, -1, -1, -1, 14, -1, 147, -1, 188, -1, 107, -1},
                {-1, 14, -1, -1, -1, -1, -1, -1, 119, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, 62, -1, -1, -1, -1, 141, -1, -1, -1, 149, -1, -1},
                {149, -1, -1, -1, -1, -1, -1, -1, -1, 117, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, 55, -1, -1, -1, -1, 183, -1, -1, -1, -1},
                {82, -1, -1, -1, 121, 55, 5, -1, -1, -1, -1, -1, -1, -1, -1},
                {85, -1, -1, 71, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 108},
                {-1, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {207, -1, -1, 111, -1, -1, -1, -1, 15, -1, -1, -1, -1, 199, 78},
                {-1, -1, -1, -1, -1, 134, -1, -1, 84, -1, -1, -1, 66, 71, -1}};
        System.out.println(snakesAndLadders(board8));
    }

    public static int snakesAndLadders(int[][] board) {
        int result = 0;
        int length = board.length;
        int arrayLength = board.length * board.length;
        /**
         * 将棋盘方格按照编号排成一列
         */
        int[] boardArray = new int[arrayLength];
        /**
         * isVisited[i]标记索引为i的方格是否到达过
         */
        boolean[] isVisited = new boolean[arrayLength];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        /**
         * 将棋盘方格按照编号排成一列
         */
        for (int i = 0; i < length; i++) {
            int row = length - i - 1;

            for (int j = 0; j < length; j++) {
                /**
                 * 如果i为偶数，就是从棋盘的左边向右边走，否则就是从棋盘的右边向左边走
                 */
                boardArray[i * length + j] = (i & 1) == 0 ? board[row][j] : board[row][length - 1 - j];
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int start = queue.poll();
                isVisited[start] = true;
                /**
                 * 如果当前从出发的方格即为终点方格，直接返回步数result
                 */
                if (start == arrayLength - 1) {
                    return result;
                }
                /**
                 * 将从索引为start的方格出发可以一步到达并且还没有到达过的方格的索引加入队列
                 */
                for (int j = 1; j <= 6; j++) {
                    if (start + j < arrayLength) {
                        /**
                         * 从索引为start的方格出发可以一步到达的方格的索引
                         */
                        int end = boardArray[start + j] == -1 ? start + j : boardArray[start + j] - 1;
                        /**
                         * 判断索引为end的方格是否到达过
                         */
                        if (!isVisited[end]) {
                            queue.offer(end);
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
