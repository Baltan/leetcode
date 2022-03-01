package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: LCP 45. 自行车炫技赛场
 *
 * @author Baltan
 * @date 2022/3/1 11:09
 */
public class BicycleYard {
    public static void main(String[] args) {
        int[] position1 = {0, 0};
        int[][] terrain1 = {{0, 0}, {0, 0}};
        int[][] obstacle1 = {{0, 0}, {0, 0}};
        OutputUtils.print2DIntegerArray(bicycleYard(position1, terrain1, obstacle1));

        System.out.println("----------------------------");

        int[] position2 = {1, 1};
        int[][] terrain2 = {{5, 0}, {0, 6}};
        int[][] obstacle2 = {{0, 6}, {7, 0}};
        OutputUtils.print2DIntegerArray(bicycleYard(position2, terrain2, obstacle2));

        System.out.println("----------------------------");

        int[] position3 = {0, 1};
        int[][] terrain3 = {{63, 91, 53, 6, 70, 29, 1, 86, 31}, {0, 42, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 74, 77, 94, 8}, {55, 57, 59, 0, 0, 0, 11, 33, 23},
                {58, 27, 51, 0, 0, 56, 10, 24, 7}, {82, 49, 74, 0, 0, 79, 96, 68, 25},
                {72, 51, 67, 0, 58, 59, 81, 52, 64}, {95, 30, 35, 0, 45, 79, 71, 15, 74}};
        int[][] obstacle3 = {{21, 7, 31, 16, 33, 39, 25, 12, 4}, {0, 42, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 19, 14, 43, 30}, {50, 8, 37, 0, 0, 0, 44, 33, 17},
                {5, 12, 29, 0, 0, 30, 2, 33, 40}, {40, 18, 14, 0, 0, 24, 15, 6, 19},
                {10, 3, 40, 0, 39, 38, 16, 44, 48}, {48, 27, 26, 0, 42, 13, 9, 25, 31}};
        OutputUtils.print2DIntegerArray(bicycleYard(position3, terrain3, obstacle3));
    }

    public static int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        List<int[]> result = new LinkedList<>();
        int rows = terrain.length;
        int cols = terrain[0].length;
        /**
         * 可以向上下左右四个方向移动
         */
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        /**
         * 标记已经被以某些速度到达过的位置，形式为"横坐标-纵坐标-到达速度"
         */
        Set<String> isVisited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        /**
         * 出发位置
         */
        queue.offer(new int[]{position[0], position[1], 1});
        isVisited.add(position[0] + "-" + position[1] + "-" + 1);

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            /**
             * 当前横坐标
             */
            int x = arr[0];
            /**
             * 当前纵坐标
             */
            int y = arr[1];
            /**
             * 当前速度
             */
            int speed = arr[2];

            if (speed == 1 && (x != position[0] || y != position[1])) {
                result.add(new int[]{x, y});
            }

            for (int[] direction : directions) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                /**
                 * 超出场地范围
                 */
                if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols) {
                    continue;
                }
                /**
                 * 到达下一位置的速度
                 */
                int nextSpeed = speed + terrain[x][y] - terrain[nextX][nextY] - obstacle[nextX][nextY];
                /**
                 * 已经以速度nextSpeed到达过位置[nextX,nextY]，不重复计算
                 */
                if (isVisited.contains(nextX + "-" + nextY + "-" + nextSpeed)) {
                    continue;
                }
                /**
                 * 当速度大于0时，才可以骑行到下一位置
                 */
                if (nextSpeed >= 1) {
                    queue.offer(new int[]{nextX, nextY, nextSpeed});
                    isVisited.add(nextX + "-" + nextY + "-" + nextSpeed);
                }
            }
        }
        /**
         * 将所有可以到达的位置，先按照横坐标，再按照纵坐标进行升序排列
         */
        Collections.sort(result, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        return result.toArray(new int[0][0]);
    }
}
