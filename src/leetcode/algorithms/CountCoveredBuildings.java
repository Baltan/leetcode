package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3531. Count Covered Buildings
 *
 * @author baltan
 * @date 2025/5/13 18:11
 */
public class CountCoveredBuildings {
    public static void main(String[] args) {
        System.out.println(countCoveredBuildings(3, new int[][]{{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}}));
        System.out.println(countCoveredBuildings(3, new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(countCoveredBuildings(5, new int[][]{{1, 3}, {3, 2}, {3, 3}, {3, 5}, {5, 3}}));
    }

    public static int countCoveredBuildings(int n, int[][] buildings) {
        int result = 0;
        /**
         * xMin[i]表示横坐标为i的建筑中纵坐标的最小值
         */
        int[] xMin = new int[n + 1];
        /**
         * xMax[i]表示横坐标为i的建筑中纵坐标的最大值
         */
        int[] xMax = new int[n + 1];
        /**
         * yMin[i]表示纵坐标为i的建筑中横坐标的最小值
         */
        int[] yMin = new int[n + 1];
        /**
         * yMax[i]表示纵坐标为i的建筑中横坐标的最大值
         */
        int[] yMax = new int[n + 1];
        Arrays.fill(xMin, Integer.MAX_VALUE);
        Arrays.fill(xMax, Integer.MIN_VALUE);
        Arrays.fill(yMin, Integer.MAX_VALUE);
        Arrays.fill(yMax, Integer.MIN_VALUE);

        for (int[] building : buildings) {
            xMin[building[0]] = Math.min(xMin[building[0]], building[1]);
            xMax[building[0]] = Math.max(xMax[building[0]], building[1]);
            yMin[building[1]] = Math.min(yMin[building[1]], building[0]);
            yMax[building[1]] = Math.max(yMax[building[1]], building[0]);
        }

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            /**
             * 判断坐标为(x,y)的建筑的上下左右是否有其他建筑
             */
            if (xMin[x] < y && xMax[x] > y && yMin[y] < x && yMax[y] > x) {
                result++;
            }
        }
        return result;
    }
}
