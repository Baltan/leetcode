package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 452. Minimum Number of Arrows to Burst Balloons
 *
 * @author Baltan
 * @date 2019-07-26 09:28
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points1));

        int[][] points2 = {{1, 9}, {7, 16}, {2, 5}, {7, 12}, {9, 11}, {2, 10}, {9, 16}, {3, 9}, {1, 3}};
        System.out.println(findMinArrowShots(points2));

        int[][] points3 = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        System.out.println(findMinArrowShots(points3));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points == null) {
            return 0;
        }

        if (points.length <= 1) {
            return points.length;
        }

        int result = 1;
        int length = points.length;
        /**
         * 对所有气球进行排序，优先按照左端点递增排序，如果左端点的值相等，按照右端点递增排序
         */
        Arrays.sort(points, (m, n) -> {
            if (m[0] == n[0]) {
                return m[1] - n[1];
            } else {
                return m[0] - n[0];
            }
        });
        /**
         * 假设射穿第一个气球的箭的x坐标为第一个气球的右端点的值，
         * 因为箭的x坐标越靠右，越有可能射穿下一个气球，从而减少箭的使用数量
         */
        int x = points[0][1];

        for (int i = 1; i < length; i++) {
            /**
             * 如果当前气球的左端点大于上一支箭的x坐标，那么必须要新增一支箭来射穿当前的气球，
             * 这支箭的x坐标即为当前气球的右端点的值，
             * 因为箭的x坐标越靠右，越有可能射穿下一个气球，从而减少箭的使用数量
             *
             * 如果当前气球的左端点不大于上一支箭的x坐标，那么上一支箭可以射穿当前气球，但是需要调整上一直箭的位置
             * <pre>
             *     上一支箭的位置：
             *
             *     ------------|
             *         --------|------
             *
             *     如果当前气球的右端点的值不小于箭的x坐标，则不需要调整箭的x坐标
             *
             *     ------------|                    ------------|
             *         --------|------                  --------|------
             *            ---------                        -----------------
             *
             *     如果当前气球的右端点的值小于箭的x坐标，需要将箭的x坐标修改为当前气球的右端点的值
             *
             *     ------------|                    ----------|--
             *         --------|------    --->          ------|--------
             *            ---                              ---|
             * </pre>
             */
            if (points[i][0] > x) {
                result++;
                x = points[i][1];
            } else {
                x = Math.min(x, points[i][1]);
            }
        }
        return result;
    }
}
