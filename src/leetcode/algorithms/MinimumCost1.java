package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2662. Minimum Cost of a Path With Special Roads
 *
 * @author Baltan
 * @date 2023/5/1 12:33
 */
public class MinimumCost1 {
    public static void main(String[] args) {
        int[] start1 = {1, 1};
        int[] target1 = {4, 5};
        int[][] specialRoads1 = {{1, 2, 3, 3, 2}, {3, 4, 4, 5, 1}};
        System.out.println(minimumCost(start1, target1, specialRoads1));

        int[] start2 = {3, 2};
        int[] target2 = {5, 7};
        int[][] specialRoads2 = {{3, 2, 3, 4, 4}, {3, 3, 5, 5, 5}, {3, 4, 5, 6, 6}};
        System.out.println(minimumCost(start2, target2, specialRoads2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-cost-of-a-path-with-special-roads/description/"></a>
     *
     * @param start
     * @param target
     * @param specialRoads
     * @return
     */
    public static int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        /**
         * 假设从起点到终点不沿着任何特殊路径走
         */
        int result = getDistance(start[0], start[1], target[0], target[1]);
        int length = specialRoads.length;
        /**
         * distances[i]表示从起点start到第i条特殊路径的终点的最小代价
         */
        int[] distances = new int[length];
        /**
         * 保存所有特殊路径的索引，并且按照起点start到特殊路径终点的最小代价升序排列
         */
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> distances[x]));

        for (int i = 0; i < length; i++) {
            /**
             * 从起点start直接到特殊路径specialRoads[i]的终点，不沿着该特殊路径走的代价
             */
            int distance1 = getDistance(start[0], start[1], specialRoads[i][2], specialRoads[i][3]);
            /**
             * 从起点start沿着特殊路径specialRoads[i]走到该特殊路径终点的代价
             */
            int distance2 = getDistance(start[0], start[1], specialRoads[i][0], specialRoads[i][1]) + specialRoads[i][4];
            distances[i] = Math.min(distance1, distance2);
            pq.offer(i);
        }
        /**
         * Dijkstra算法
         */
        while (!pq.isEmpty()) {
            int i = pq.poll();

            for (int j = 0; j < length; j++) {
                /**
                 * 从起点start途径特殊路径specialRoads[i]的终点，再到特殊路径specialRoads[j]的终点，且不沿着该特殊路径走的代价
                 */
                int distance1 = distances[i] + getDistance(specialRoads[i][2], specialRoads[i][3], specialRoads[j][2], specialRoads[j][3]);
                /**
                 * 从起点start途径特殊路径specialRoads[i]的终点，再沿着特殊路径specialRoads[j]走到该特殊路径终点的代价
                 */
                int distance2 = distances[i] + getDistance(specialRoads[i][2], specialRoads[i][3], specialRoads[j][0], specialRoads[j][1]) + specialRoads[j][4];
                int min = Math.min(distance1, distance2);
                /**
                 * 从起点start到特殊路径specialRoads[j]的终点的代价被缩小了
                 */
                if (min < distances[j]) {
                    distances[j] = min;
                    pq.offer(j);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            /**
             * 从起点start先到特殊路径specialRoads[i]的终点，再到终点target的代价
             */
            int distance = distances[i] + getDistance(specialRoads[i][2], specialRoads[i][3], target[0], target[1]);
            result = Math.min(result, distance);
        }
        return result;
    }

    /**
     * 计算坐标(startX,startY)到坐标(targetX,targetY)的曼哈顿距离
     *
     * @param startX
     * @param startY
     * @param targetX
     * @param targetY
     * @return
     */
    public static int getDistance(int startX, int startY, int targetX, int targetY) {
        return Math.abs(startX - targetX) + Math.abs(startY - targetY);
    }
}
