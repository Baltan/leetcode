package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2146. K Highest Ranked Items Within a Price Range
 *
 * @author Baltan
 * @date 2022/1/25 10:20
 */
public class HighestRankedKItems {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2, 0, 1}, {1, 3, 0, 1}, {0, 2, 5, 1}};
        int[] pricing1 = {2, 5};
        int[] start1 = {0, 0};
        int k1 = 3;
        System.out.println(highestRankedKItems(grid1, pricing1, start1, k1));

        int[][] grid2 = {{1, 2, 0, 1}, {1, 3, 3, 1}, {0, 2, 5, 1}};
        int[] pricing2 = {2, 3};
        int[] start2 = {2, 3};
        int k2 = 2;
        System.out.println(highestRankedKItems(grid2, pricing2, start2, k2));

        int[][] grid3 = {{1, 1, 1}, {0, 0, 1}, {2, 3, 4}};
        int[] pricing3 = {2, 3};
        int[] start3 = {0, 0};
        int k3 = 3;
        System.out.println(highestRankedKItems(grid3, pricing3, start3, k3));

        int[][] grid4 = {{0, 2, 0}};
        int[] pricing4 = {2, 2};
        int[] start4 = {0, 1};
        int k4 = 1;
        System.out.println(highestRankedKItems(grid4, pricing4, start4, k4));

        int[][] grid5 = {{2, 0, 2}, {4, 5, 3}, {2, 0, 2}};
        int[] pricing5 = {2, 5};
        int[] start5 = {1, 1};
        int k5 = 9;
        System.out.println(highestRankedKItems(grid5, pricing5, start5, k5));
    }

    public static List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * isVisited[i][j]表示商店grid[i][j]已经拜访过
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 上下左右四个移动方向
         */
        int[][] directions = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start[0]][start[1]] = true;
        /**
         * 按照距离start由近到远遍历各个商店
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 下一步可能走到的商店集合
             */
            List<int[]> nextCoordinates = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                /**
                 * 当前所在商店
                 */
                int[] coordinate = queue.poll();
                int x = coordinate[0];
                int y = coordinate[1];
                /**
                 * 如果当前商店物品的价格在pricing范围内，则将当前商店加入result中
                 */
                if (pricing[0] <= grid[x][y] && pricing[1] >= grid[x][y]) {
                    result.add(Arrays.asList(x, y));
                }
                /**
                 * 如果已经找到了满足要求的前k个商店，就直接返回，不需要继续查找商店
                 */
                if (result.size() == k) {
                    return result;
                }
                /**
                 * 在上下左右四个方向上查找下一步可能走到的商店
                 */
                for (int[] direction : directions) {
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];

                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols &&
                            !isVisited[nextX][nextY] && grid[nextX][nextY] != 0) {
                        nextCoordinates.add(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
            /**
             * 将下一步可能走到的商店按照物品价格、横坐标、纵坐标排序
             */
            Collections.sort(nextCoordinates, (c1, c2) -> {
                if (grid[c1[0]][c1[1]] != grid[c2[0]][c2[1]]) {
                    return grid[c1[0]][c1[1]] - grid[c2[0]][c2[1]];
                } else if (c1[0] != c2[0]) {
                    return c1[0] - c2[0];
                } else {
                    return c1[1] - c2[1];
                }
            });

            for (int[] coordinate : nextCoordinates) {
                queue.offer(coordinate);
            }
        }
        return result;
    }
}
