package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3552. Grid Teleportation Traversal
 *
 * @author baltan
 * @date 2025/6/4 14:18
 */
public class MinMoves4 {
    public static void main(String[] args) {
        System.out.println(minMoves(new String[]{".A", "CA"}));
        System.out.println(minMoves(new String[]{".", "#"}));
        System.out.println(minMoves(new String[]{"."}));
        System.out.println(minMoves(new String[]{"A..", ".A.", "..."}));
        System.out.println(minMoves(new String[]{".#...", ".#.#.", ".#.#.", "...#."}));
    }

    public static int minMoves(String[] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length();
        if (rows == 1 && cols == 1) {
            return 0;
        }
        /**
         * 当前移动次数
         */
        int step = 0;
        /**
         * 每一步可以往当前单元格的上下左右四个方向移动
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        /**
         * isVisited[i][j]表示单元格matrix[i][j]是否访问过
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 保存所有到达的单元格的坐标
         */
        Queue<int[]> queue = new LinkedList<>();
        /**
         * teleportationPortals[0]-teleportationPortals[25]依次保存单元格中为字母A-Z的单元格的坐标集合
         */
        List<int[]>[] teleportationPortals = new List[26];
        Arrays.setAll(teleportationPortals, i -> new ArrayList<>());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Character.isUpperCase(matrix[i].charAt(j))) {
                    teleportationPortals[matrix[i].charAt(j) - 'A'].add(new int[]{i, j});
                }
            }
        }
        queue.offer(new int[]{0, 0});
        isVisited[0][0] = true;
        /**
         * 如果起始单元格中为大写字母，则相当于可以从所有包含相同大写字母的单元格中出发
         */
        if (Character.isUpperCase(matrix[0].charAt(0))) {
            for (int[] teleportationPortal : teleportationPortals[matrix[0].charAt(0) - 'A']) {
                int x = teleportationPortal[0];
                int y = teleportationPortal[1];
                /**
                 * 起始单元格和终点单元格可以通过传送门连通，相当于起始就位于终点处
                 */
                if (x == rows - 1 && y == cols - 1) {
                    return 0;
                }
                queue.offer(new int[]{x, y});
                isVisited[x][y] = true;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;

            for (int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();
                /**
                 * 计算下一步可能到达的单元格
                 */
                for (int[] direction : directions) {
                    int nextX = direction[0] + coordinate[0];
                    int nextY = direction[1] + coordinate[1];
                    /**
                     * 下一单元格如果出界，或者单元格中为障碍物，或者已被访问过，则不再重复访问
                     */
                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !isVisited[nextX][nextY] && matrix[nextX].charAt(nextY) != '#') {
                        if (nextX == rows - 1 && nextY == cols - 1) {
                            return step;
                        }
                        queue.offer(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                        /**
                         * 如果当前单元格中为大写字母，则相当于可以到达包含相同大写字母的所有单元格
                         */
                        if (Character.isUpperCase(matrix[nextX].charAt(nextY))) {
                            for (int[] teleportationPortal : teleportationPortals[matrix[nextX].charAt(nextY) - 'A']) {
                                int x = teleportationPortal[0];
                                int y = teleportationPortal[1];

                                if (x == rows - 1 && y == cols - 1) {
                                    return step;
                                }

                                if (!isVisited[x][y]) {
                                    queue.offer(new int[]{x, y});
                                    isVisited[x][y] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
