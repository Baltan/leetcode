package leetcode.algorithms;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 149. Max Points on a Line
 *
 * @author Baltan
 * @date 2020-04-10 16:40
 * @see MaxPoints
 * @see leetcode.interview.BestLine
 */
public class MaxPoints1 {
    public static void main(String[] args) {
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(maxPoints(points1));

        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(maxPoints(points2));

        int[][] points3 = {{1, 1}, {1, 1}, {2, 3}};
        System.out.println(maxPoints(points3));

        int[][] points4 = {{1, 1}, {1, 2}, {1, 3}};
        System.out.println(maxPoints(points4));

        int[][] points5 = {{1, 1}, {1, 2}};
        System.out.println(maxPoints(points5));

        int[][] points6 = {{1, 1}, {1, 1}};
        System.out.println(maxPoints(points6));

        int[][] points7 = {{1, 1}, {1, 1}, {2, 2}, {2, 2}};
        System.out.println(maxPoints(points7));

        int[][] points8 = {{1, 1}, {1, 1}, {2, 2}, {2, 2}, {3, 3}, {3, 3}, {3, 3}};
        System.out.println(maxPoints(points8));

        int[][] points9 = {{1, 1}, {1, 1}, {2, 2}, {2, 2}, {1, 3}, {1, 3}, {1, 3}};
        System.out.println(maxPoints(points9));

        int[][] points10 = {{0, 0}, {94911151, 94911150}, {94911152, 94911151}};
        System.out.println(maxPoints(points10));
    }

    public static int maxPoints(int[][] points) {
        int length = points.length;
        /**
         * 穿过最多点的直线穿过的点的个数
         */
        int maxCount = 0;

        for (int i = 0; i < length; i++) {
            /**
             * 斜率gradient -> 过点points[i]斜率为gradient的直线穿过的点的个数
             */
            Map<BigDecimal, Integer> gradientMap = new HashMap<>();
            /**
             * 和points[i]重叠的点的个数，包括points[i]
             */
            int overlappingCount = 0;
            /**
             * 过点points[i]和x轴垂直的直线穿过的点的个数，不包括和points[i]重叠的点
             */
            int verticalCount = 0;

            for (int j = 0; j < length; j++) {
                if (Arrays.equals(points[i], points[j])) {
                    overlappingCount++;
                    continue;
                }

                if (points[i][0] == points[j][0]) {
                    verticalCount++;
                    continue;
                }

                BigDecimal gradient = BigDecimal.valueOf(points[j][1] - points[i][1])
                        .divide(BigDecimal.valueOf(points[j][0] - points[i][0]), 20,
                                BigDecimal.ROUND_CEILING);
                gradientMap.put(gradient, gradientMap.getOrDefault(gradient, 0) + 1);
            }
            /**
             * 如果points中所有点都重合，则points中点的个数即为同一条直线上点的最多个数
             */
            maxCount = Math.max(maxCount, overlappingCount);
            /**
             * verticalCount+overlappingCount为过点points[i]和x轴垂直的直线穿过的点的总个数
             */
            maxCount = Math.max(maxCount, verticalCount + overlappingCount);

            for (int count : gradientMap.values()) {
                /**
                 * count+overlappingCount为过点points[i]斜率为gradient的直线穿过的点的总个数
                 */
                maxCount = Math.max(maxCount, count + overlappingCount);
            }
        }
        return maxCount;
    }
}
