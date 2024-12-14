package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 3380. Maximum Area Rectangle With Point Constraints I
 *
 * @author Baltan
 * @date 2024/12/14 22:30
 */
public class MaxRectangleArea {
    public static void main(String[] args) {
        System.out.println(maxRectangleArea(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}}));
        System.out.println(maxRectangleArea(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}));
        System.out.println(maxRectangleArea(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {1, 2}, {3, 2}}));
    }

    public static int maxRectangleArea(int[][] points) {
        int result = -1;
        /**
         * coordinates[i]保存points中所有横坐标为i的点的纵坐标
         */
        Set<Integer>[] coordinates = new Set[101];
        Arrays.setAll(coordinates, x -> new HashSet<>());

        for (int[] point : points) {
            coordinates[point[0]].add(point[1]);
        }
        /**
         * 判断能否以points[i]和points[j]作为对顶角的两个顶点构造出符合要求的矩形
         */
        for (int i = 0; i < points.length; i++) {
            loop:
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                /**
                 * (x1,y1)和(x2,y2)在同一水平线或垂直线上，不能作为矩形对顶角的两个顶点
                 */
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                /**
                 * 构成矩形的另外两个顶点(x1,y2)和(x2,y1)在points中不存在，无法构成一个矩形
                 */
                if (!coordinates[x1].contains(y2) || !coordinates[x2].contains(y1)) {
                    continue;
                }
                int minX = Math.min(x1, x2);
                int maxX = Math.max(x1, x2);
                int minY = Math.min(y1, y2);
                int maxY = Math.max(y1, y2);
                /**
                 * 判断points中是否存在其他点在(x1,y1)、(x2,y2)、(x1,y2)、(x2,y1)四个顶点构成的矩形范围内
                 */
                for (int[] point : points) {
                    /**
                     * 排除四个顶点
                     */
                    if ((point[0] == minX && point[1] == minY) ||
                            (point[0] == minX && point[1] == maxY) ||
                            (point[0] == maxX && point[1] == minY) ||
                            (point[0] == maxX && point[1] == maxY)) {
                        continue;
                    }

                    if (point[0] >= minX && point[0] <= maxX && point[1] >= minY && point[1] <= maxY) {
                        continue loop;
                    }
                }
                /**
                 * 计算(x1,y1)、(x2,y2)、(x1,y2)、(x2,y1)四个顶点构成的矩形面积
                 */
                result = Math.max(result, (maxX - minX) * (maxY - minY));
            }
        }
        return result;
    }
}
