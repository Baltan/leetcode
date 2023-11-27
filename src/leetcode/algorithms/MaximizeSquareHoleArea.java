package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2943. Maximize Area of Square Hole in Grid
 *
 * @author Baltan
 * @date 2023/11/26 19:14
 */
public class MaximizeSquareHoleArea {
    public static void main(String[] args) {
        System.out.println(maximizeSquareHoleArea(2, 1, new int[]{2, 3}, new int[]{2}));
        System.out.println(maximizeSquareHoleArea(1, 1, new int[]{2}, new int[]{2}));
        System.out.println(maximizeSquareHoleArea(2, 3, new int[]{2, 3}, new int[]{2, 3, 4}));
    }

    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        /**
         * 水平方向可以连续移除的最大杆子数量
         */
        int hMaxCount = 0;
        /**
         * 垂直方向可以连续移除的最大杆子数量
         */
        int vMaxCount = 0;
        /**
         * 水平方向当前连续移除的杆子数量
         */
        int hCount = 0;
        /**
         * 垂直方向当前连续移除的杆子数量
         */
        int vCount = 0;
        /**
         * 水平方向上前一次移除的杆子的位置
         */
        int hPrev = -1;
        /**
         * 垂直方向上前一次移除的杆子的位置
         */
        int vPrev = -1;
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        for (int hBar : hBars) {
            if (hBar == hPrev + 1) {
                /**
                 * 当前移除的杆子和前一次移除的杆子位置相邻
                 */
                hCount++;
            } else {
                hCount = 1;
            }
            hPrev = hBar;
            hMaxCount = Math.max(hMaxCount, hCount);
        }

        for (int vBar : vBars) {
            if (vBar == vPrev + 1) {
                /**
                 * 当前移除的杆子和前一次移除的杆子位置相邻
                 */
                vCount++;
            } else {
                vCount = 1;
            }
            vPrev = vBar;
            vMaxCount = Math.max(vMaxCount, vCount);
        }
        /**
         * 连续移除的杆子数量+1即为最大正方形的边长
         */
        int maxLength = Math.min(hMaxCount, vMaxCount) + 1;
        return maxLength * maxLength;
    }
}
