package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 2812. Find the Safest Path in a Grid
 *
 * @author Baltan
 * @date 2023/8/13 13:17
 */
public class MaximumSafenessFactor {
    public static void main(String[] args) {
        System.out.println(maximumSafenessFactor(Arrays.asList(Arrays.asList(1, 0, 0), Arrays.asList(0, 0, 0), Arrays.asList(0, 0, 1))));
        System.out.println(maximumSafenessFactor(Arrays.asList(Arrays.asList(0, 0, 1), Arrays.asList(0, 0, 0), Arrays.asList(0, 0, 0))));
        System.out.println(maximumSafenessFactor(Arrays.asList(Arrays.asList(0, 0, 0, 1), Arrays.asList(0, 0, 0, 0), Arrays.asList(0, 0, 0, 0), Arrays.asList(1, 0, 0, 0))));
    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }
        int[][] factorMatrix = new int[n][n];
        Queue<int[]> factorQueue = new LinkedList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    factorMatrix[i][j] = 0;
                    factorQueue.offer(new int[]{i, j});
                } else {
                    factorMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!factorQueue.isEmpty()) {
            for (int i = 0; i < factorQueue.size(); i++) {
                int[] coordinate = factorQueue.poll();
                int currX = coordinate[0];
                int currY = coordinate[1];

                for (int[] direction : directions) {
                    int nextX = currX + direction[0];
                    int nextY = currY + direction[1];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && factorMatrix[currX][currY] + 1 < factorMatrix[nextX][nextY]) {
                        factorMatrix[nextX][nextY] = factorMatrix[currX][currY] + 1;
                        factorQueue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        int[][] safeness = new int[n][n];
        Queue<int[]> pathQueue = new LinkedList<>();
        pathQueue.offer(new int[]{0, 0});

        for (int[] row : safeness) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        safeness[0][0] = factorMatrix[0][0];

        while (!pathQueue.isEmpty()) {
            int[] coordinate = pathQueue.poll();
            int currX = coordinate[0];
            int currY = coordinate[1];

            for (int[] direction : directions) {
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    if (safeness[nextX][nextY] == Integer.MAX_VALUE || safeness[currX][currY] > safeness[nextX][nextY]) {
                        safeness[nextX][nextY] = Math.min(safeness[currX][currY], factorMatrix[nextX][nextY]);
                        pathQueue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return safeness[n - 1][n - 1];
    }
}
