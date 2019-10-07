package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1210. Minimum Moves to Reach Target with Rotations（5208. 穿过迷宫的最少移动次数）
 *
 * @author Baltan
 * @date 2019-10-02 10:53
 */
public class MinimumMoves {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 0, 0}};
        System.out.println(minimumMoves(grid1));

        int[][] grid2 = {{0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 1}, {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0, 1}, {1, 1, 1, 0, 0, 0}};
        System.out.println(minimumMoves(grid2));

        int[][] grid3 = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 0, 1, 0}, {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(minimumMoves(grid3));
    }

    public static int minimumMoves(int[][] grid) {
        /**
         * 移动次数
         */
        int result = -1;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Position> queue = new LinkedList<>();
        /**
         * 记录已经到达过的位置
         */
        Set<Position> isVisited = new HashSet<>();
        int[] startTail = {0, 0};
        int[] startHead = {0, 1};
        /**
         * 起点
         */
        Position startPosition = new Position(startTail, startHead);
        int[] endTail = {rows - 1, cols - 2};
        int[] endHead = {rows - 1, cols - 1};
        /**
         * 终点
         */
        Position endPosition = new Position(endTail, endHead);
        queue.offer(startPosition);
        isVisited.add(startPosition);

        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 将移动次数加1，如果起点和终点一致的话，移动次数就是0次
             */
            result++;

            for (int i = 0; i < size; i++) {
                Position position = queue.poll();
                /**
                 * 如果当前位置和终点一致，直接返回当前的移动次数
                 */
                if (position.equals(endPosition)) {
                    return result;
                }
                /**
                 * 当前头部的位置
                 */
                int[] currentHead = position.getHead();
                /**
                 * 当前尾部的位置
                 */
                int[] currentTail = position.getTail();
                /**
                 * 如果右移没有障碍物并且右移一次的位置没有到达过，将右移后的位置加入到queue中
                 */
                if (currentHead[1] + 1 < cols && currentTail[1] + 1 < cols &&
                        grid[currentHead[0]][currentHead[1] + 1] == 0 &&
                        grid[currentTail[0]][currentTail[1] + 1] == 0) {
                    int[] rightwardHead = {currentHead[0], currentHead[1] + 1};
                    int[] rightwardTail = {currentTail[0], currentTail[1] + 1};
                    Position rightwardPosition = new Position(rightwardTail, rightwardHead);

                    if (!isVisited.contains(rightwardPosition)) {
                        isVisited.add(rightwardPosition);
                        queue.offer(rightwardPosition);
                    }
                }
                /**
                 * 如果下移没有障碍物并且下移一次的位置没有到达过，将下移后的位置加入到queue中
                 */
                if (currentHead[0] + 1 < rows && currentTail[0] + 1 < rows &&
                        grid[currentHead[0] + 1][currentHead[1]] == 0 &&
                        grid[currentTail[0] + 1][currentTail[1]] == 0) {
                    int[] downwardHead = {currentHead[0] + 1, currentHead[1]};
                    int[] downwardTail = {currentTail[0] + 1, currentTail[1]};
                    Position downwardPosition = new Position(downwardTail, downwardHead);

                    if (!isVisited.contains(downwardPosition)) {
                        isVisited.add(downwardPosition);
                        queue.offer(downwardPosition);
                    }
                }
                /**
                 * 如果顺时针旋转没有障碍物并且顺时针旋转一次的位置没有到达过，将顺时针旋转后的
                 * 位置加入到queue中
                 */
                if (currentHead[0] == currentTail[0] && currentHead[1] - 1 == currentTail[1] &&
                        currentHead[0] + 1 < rows && currentHead[1] - 1 >= 0 &&
                        grid[currentHead[0] + 1][currentHead[1]] == 0 &&
                        grid[currentHead[0] + 1][currentHead[1] - 1] == 0) {
                    int[] clockwiseHead = {currentHead[0] + 1, currentHead[1] - 1};
                    int[] clockwiseTail = {currentTail[0], currentTail[1]};
                    Position clockwisePosition = new Position(clockwiseTail, clockwiseHead);

                    if (!isVisited.contains(clockwisePosition)) {
                        isVisited.add(clockwisePosition);
                        queue.offer(clockwisePosition);
                    }
                }
                /**
                 * 如果逆时针旋转没有障碍物并且逆时针旋转一次的位置没有到达过，将逆时针旋转后的
                 * 位置加入到queue中
                 */
                if (currentHead[0] - 1 == currentTail[0] && currentHead[1] == currentTail[1] &&
                        currentHead[1] + 1 < cols && currentHead[0] - 1 >= 0 &&
                        grid[currentHead[0]][currentHead[1] + 1] == 0 &&
                        grid[currentHead[0] - 1][currentHead[1] + 1] == 0) {
                    int[] anticlockwiseHead = {currentHead[0] - 1, currentHead[1] + 1};
                    int[] anticlockwiseTail = {currentTail[0], currentTail[1]};
                    Position anticlockwisePosition = new Position(anticlockwiseTail, anticlockwiseHead);

                    if (!isVisited.contains(anticlockwisePosition)) {
                        isVisited.add(anticlockwisePosition);
                        queue.offer(anticlockwisePosition);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 位置类，表示贪吃蛇的位置
     */
    private static class Position {
        private int[] tail;
        private int[] head;

        public Position(int[] tail, int[] head) {
            this.tail = tail;
            this.head = head;
        }

        public int[] getTail() {
            return tail;
        }

        public int[] getHead() {
            return head;
        }

        @Override
        public boolean equals(Object obj) {
            Position position = (Position) obj;
            return Arrays.equals(position.getHead(), head) && Arrays.equals(position.getTail(), tail);
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(tail);
            result = 31 * result + Arrays.hashCode(head);
            return result;
        }
    }
}
