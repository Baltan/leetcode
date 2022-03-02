package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1926. Nearest Exit from Entrance in Maze
 *
 * @author Baltan
 * @date 2022/3/1 21:39
 */
public class NearestExit {
    public static void main(String[] args) {
        char[][] maze1 = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance1 = {1, 2};
        System.out.println(nearestExit(maze1, entrance1));

        char[][] maze2 = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance2 = {1, 0};
        System.out.println(nearestExit(maze2, entrance2));

        char[][] maze3 = {{'.', '+'}};
        int[] entrance3 = {0, 0};
        System.out.println(nearestExit(maze3, entrance3));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int result = 0;
        int rows = maze.length;
        int cols = maze[0].length;
        /**
         * 已经到达过的位置
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 可以向上下左右四个方向移动
         */
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        /**
         * 将起点位置将入队列并标记起点位置已被访问过
         */
        queue.offer(entrance);
        isVisited[entrance[0]][entrance[1]] = true;
        /**
         * 宽度优先搜索逐层向外扩张
         */
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];
                /**
                 * 找到非起点位置的出口
                 */
                if ((x != entrance[0] || y != entrance[1]) &&
                        (x == 0 || x + 1 == rows || y == 0 || y + 1 == cols)) {
                    return result;
                }

                for (int[] direction : directions) {
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];

                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols &&
                            !isVisited[nextX][nextY] && maze[nextX][nextY] == '.') {
                        queue.offer(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
