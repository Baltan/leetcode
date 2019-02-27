package leetcode.algorithms;

import leetcode.entity.IslandCoordinate;

import java.util.LinkedList;

/**
 * Description: Max Area of Island
 *
 * @author Baltan
 * @date 2018/8/7 09:07
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid1));

        int[][] grid2 = {{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid2));

        int[][] grid3 = {{1}};
        System.out.println(maxAreaOfIsland(grid3));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        LinkedList<IslandCoordinate> list;
        int[][] book = new int[rows][cols];
        int area;
        int maxArea = 0;
        int[][] nextStep = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int nextX;
        int nextY;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && book[i][j] == 0) {
                    area = 1;
                    list = new LinkedList<>();

                    IslandCoordinate coordinate = new IslandCoordinate(i, j);
                    list.addLast(coordinate);
                    book[i][j] = 1;
                    maxArea = area > maxArea ? area : maxArea;

                    while (!list.isEmpty()) {
                        for (int k = 0; k < nextStep.length; k++) {
                            nextX = list.getFirst().getX() + nextStep[k][0];
                            nextY = list.getFirst().getY() + nextStep[k][1];

                            if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols) {
                                continue;
                            }

                            if (grid[nextX][nextY] == 1 && book[nextX][nextY] == 0) {
                                area++;
                                book[nextX][nextY] = 1;
                                IslandCoordinate nextStepCoordinate = new IslandCoordinate(nextX, nextY);
                                list.addLast(nextStepCoordinate);
                            }
                            maxArea = area > maxArea ? area : maxArea;
                        }
                        list.poll();
                    }
                }
            }
        }
        return maxArea;
    }
}
