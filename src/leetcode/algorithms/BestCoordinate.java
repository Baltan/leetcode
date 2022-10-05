package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1620. Coordinate With Maximum Network Quality
 *
 * @author Baltan
 * @date 2022/10/3 14:10
 */
public class BestCoordinate {
    public static void main(String[] args) {
        int[][] towers1 = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        OutputUtils.print1DIntegerArray(bestCoordinate(towers1, 2));

        int[][] towers2 = {{23, 11, 21}};
        OutputUtils.print1DIntegerArray(bestCoordinate(towers2, 9));

        int[][] towers3 = {{1, 2, 13}, {2, 1, 7}, {0, 1, 9}};
        OutputUtils.print1DIntegerArray(bestCoordinate(towers3, 2));

        int[][] towers4 = {{42, 0, 0}};
        OutputUtils.print1DIntegerArray(bestCoordinate(towers4, 7));

        int[][] towers5 = {{45, 12, 4}, {13, 21, 27}, {31, 17, 40}, {25, 29, 45}, {37, 29, 25}, {16, 37,
                48},
                {4, 3, 31}};
        OutputUtils.print1DIntegerArray(bestCoordinate(towers5, 42));

        int[][] towers6 = {{13, 50, 45}, {0, 5, 31}, {47, 34, 24}, {37, 14, 9}, {45, 21, 40}};
        OutputUtils.print1DIntegerArray(bestCoordinate(towers6, 34));

        int[][] towers7 = {{31, 13, 33}, {24, 45, 38}, {28, 32, 23}, {7, 23, 22}, {41, 50, 33}, {47, 21, 3},
                {3, 33, 39}, {11, 38, 5}, {26, 20, 28}, {48, 39, 16}, {34, 29, 25}};
        OutputUtils.print1DIntegerArray(bestCoordinate(towers7, 21));
    }

    public static int[] bestCoordinate(int[][] towers, int radius) {
        int[] result = new int[2];
        int length = towers.length;
        int maxQuality = 0;
        /**
         * 根据题意，信号塔的x和y坐标范围为[0,50]，所以有信号的坐标点坐标范围不超过50+radius
         */
        int maxX = 50 + radius;
        int maxY = 50 + radius;
        int radiusPower = radius * radius;
        /**
         * 枚举计算所有可能会有信号覆盖的坐标的信号强度
         */
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                int totalQuality = 0;

                for (int k = 0; k < length; k++) {
                    int towerX = towers[k][0];
                    int towerY = towers[k][1];
                    int distancePower = (towerX - i) * (towerX - i) + (towerY - j) * (towerY - j);
                    /**
                     * 该点到信号塔towers[k]的距离小于radius
                     */
                    if (distancePower <= radiusPower) {
                        totalQuality += Math.floor(towers[k][2] / (1 + Math.sqrt(distancePower)));
                    }
                }

                if (totalQuality > maxQuality) {
                    maxQuality = totalQuality;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
