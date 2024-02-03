package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1691. Maximum Height by Stacking Cuboids
 *
 * @author Baltan
 * @date 2024/2/2 23:50
 */
public class MaxHeight {
    public static void main(String[] args) {
        System.out.println(maxHeight(new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}}));
        System.out.println(maxHeight(new int[][]{{38, 25, 45}, {76, 35, 3}}));
        System.out.println(maxHeight(new int[][]{{7, 11, 17}, {7, 17, 11}, {11, 7, 17}, {11, 17, 7}, {17, 7, 11}, {17, 11, 7}}));
    }

    public static int maxHeight(int[][] cuboids) {
        /**
         * 将每个长方体各自的长宽高三个棱长按照升序排列
         */
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        /**
         * 将所有长方体按照最短边cuboid[0]升序排列，如果cuboid[0]相等，则按照次短边cuboid[1]升序排列，如果cuboid[1]也相等，则按照最长边
         * cuboid[2]升序排列
         */
        Arrays.sort(cuboids, (x, y) -> x[0] == y[0] ? (x[1] == y[1] ? x[2] - y[2] : x[1] - y[1]) : x[0] - y[0]);
        int result = 0;
        int length = cuboids.length;
        /**
         * dp[i]表示最下层为cuboids[i]时的最大高度
         */
        int[] dp = new int[length];
        dp[0] = cuboids[0][2];

        for (int i = 1; i < length; i++) {
            /**
             * 以cuboids[i]之前的所有长方体作为最下层的堆叠体中，可以叠在cuboids[i]上方的堆叠体的最大高度
             */
            int max = 0;
            /**
             * 因为cuboids[i]之后的长方体的长宽高中至少有一条棱大于等于cuboids[i]，所以不可能叠在cuboids[i]上方（除非长方体完全相同）
             */
            for (int j = i - 1; j >= 0; j--) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = cuboids[i][2] + max;
        }

        for (int height : dp) {
            result = Math.max(result, height);
        }
        return result;
    }
}
