package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3218. Minimum Cost for Cutting Cake I
 *
 * @author baltan
 * @date 2024/7/17 13:53
 * @see MinimumCost8
 */
public class MinimumCost7 {
    public static void main(String[] args) {
        System.out.println(minimumCost(6, 3, new int[]{2, 3, 2, 3, 1}, new int[]{1, 2}));
        System.out.println(minimumCost(3, 2, new int[]{1, 3}, new int[]{5}));
        System.out.println(minimumCost(2, 2, new int[]{7}, new int[]{4}));
    }

    public static int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int result = 0;
        /**
         * 蛋糕已被水平切割成的块数
         */
        int horizontalPart = 1;
        /**
         * 蛋糕已被垂直切割成的块数
         */
        int verticalPart = 1;
        int horizontalIndex = horizontalCut.length - 1;
        int verticalIndex = verticalCut.length - 1;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        /**
         * 每一次水平切割后，会导致剩余每条垂直线的切割次数加1；每一次垂直切割后，会导致剩余每条水平线的切割次数加1。为了使得切割的总开销最小，
         * 开销越大的切割线被操作的次数应该尽可能少，所以总是选择剩余所有切割线中开销最大的先切割
         */
        while (horizontalIndex >= 0 || verticalIndex >= 0) {
            if (horizontalIndex >= 0 && verticalIndex >= 0) {
                if (horizontalCut[horizontalIndex] >= verticalCut[verticalIndex]) {
                    result += horizontalCut[horizontalIndex--] * verticalPart;
                    horizontalPart++;
                } else {
                    result += verticalCut[verticalIndex--] * horizontalPart;
                    verticalPart++;
                }
            } else if (horizontalIndex >= 0) {
                result += horizontalCut[horizontalIndex--] * verticalPart;
                horizontalPart++;
            } else {
                result += verticalCut[verticalIndex--] * horizontalPart;
                verticalPart++;
            }
        }
        return result;
    }
}
