package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: Number of Enclaves
 *
 * @author Baltan
 * @date 2019-04-27 18:17
 */
public class NumEnclaves {
    public static void main(String[] args) {
        int[][] A1 = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(numEnclaves(A1));

        int[][] A2 = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(numEnclaves(A2));
    }

    public static int numEnclaves(int[][] A) {
        int result = 0;
        int rows = A.length;
        int cols = A[0].length;
        boolean[][] book = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1 && !book[i][j]) {
                    queue.offer(new int[]{i, j});
                }
                int num = 0;
                boolean flag = false;
                while (!queue.isEmpty()) {
                    int[] coordinate = queue.poll();
                    int x = coordinate[0];
                    int y = coordinate[1];
                    if (!book[x][y]) {
                        if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) {
                            flag = true;
                        }
                        num++;
                        book[x][y] = true;
                        for (int k = 0; k < directions.length; k++) {
                            int newX = x + directions[k][0];
                            int newY = y + directions[k][1];
                            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !book[newX][newY] &&
                                    A[newX][newY] == 1) {
                                queue.offer(new int[]{newX, newY});
                            }
                        }
                    }
                }
                if (!flag) {
                    result += num;
                }
            }
        }
        return result;
    }
}
