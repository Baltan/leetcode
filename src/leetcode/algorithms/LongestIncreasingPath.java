package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 329. Longest Increasing Path in a Matrix
 *
 * @author Baltan
 * @date 2019-06-22 10:18
 */
public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix1 = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(matrix1));

        int[][] matrix2 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(longestIncreasingPath(matrix2));

        int[][] matrix3 = {{1}};
        System.out.println(longestIncreasingPath(matrix3));

        int[][] matrix4 = {{1, 4, 3}};
        System.out.println(longestIncreasingPath(matrix4));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int result = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] longestPathLength = new int[rows][cols];
        /**
         * 每个数组为[x-index,y-index,value]，按value降序排列
         */
        Queue<int[]> valueQueue = new PriorityQueue<>((arr1, arr2) -> arr2[2] - arr1[2]);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                valueQueue.offer(new int[]{i, j, matrix[i][j]});
            }
        }

        while (!valueQueue.isEmpty()) {
            int[] coordinate = valueQueue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            int value = coordinate[2];
            longestPathLength[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int[] direction = directions[i];
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && matrix[newX][newY] > value) {
                    longestPathLength[x][y] = Math.max(longestPathLength[x][y],
                            1 + longestPathLength[newX][newY]);
                    result = Math.max(result, longestPathLength[x][y]);
                }
            }
        }
        return result;
    }
}
