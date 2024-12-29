package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3394. Check if Grid can be Cut into Sections
 *
 * @author Baltan
 * @date 2024/12/29 13:04
 */
public class CheckValidCuts {
    public static void main(String[] args) {
        System.out.println(checkValidCuts(5, new int[][]{{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}}));
        System.out.println(checkValidCuts(4, new int[][]{{0, 0, 1, 1}, {2, 0, 3, 4}, {0, 2, 2, 3}, {3, 0, 4, 3}}));
        System.out.println(checkValidCuts(4, new int[][]{{0, 2, 2, 4}, {1, 0, 3, 2}, {2, 2, 3, 4}, {3, 0, 4, 2}, {3, 2, 4, 4}}));
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        /**
         * 将所有矩形按照左下角的x坐标升序排列，如果相等时，则按照右上角的x坐标降序排列
         */
        Arrays.sort(rectangles, (x, y) -> x[0] == y[0] ? y[2] - x[2] : x[0] - y[0]);
        /**
         * 是否已经找到一条切割线
         */
        boolean findOne = false;
        /**
         * 从左向右已遍历过的所有矩形右上角的x坐标的最大值，第一根切割线不可能位于第一个矩形右上角的的左侧，所以从rectangles[0][2]开始判断
         */
        int rightIndex = rectangles[0][2];

        for (int i = 1; i < rectangles.length; i++) {
            /**
             * 从矩形rectangles[i]开始，后面的所有矩形都在直线x=rightIndex的右侧（含），所以x=rightIndex是一根符合要求的切割线
             */
            if (rectangles[i][0] >= rightIndex) {
                if (findOne) {
                    /**
                     * 已找到第二根符合要求的切割线
                     */
                    return true;
                } else {
                    findOne = true;
                }
            }
            /**
             * 更新已遍历过的所有矩形右上角的x坐标的最大值
             */
            rightIndex = Math.max(rightIndex, rectangles[i][2]);
        }
        /**
         * 将所有矩形按照左下角的y坐标升序排列，如果相等时，则按照右上角的y坐标降序排列
         */
        Arrays.sort(rectangles, (x, y) -> x[1] == y[1] ? y[3] - x[3] : x[1] - y[1]);
        findOne = false;
        /**
         * 从下向上已遍历过的所有矩形右上角的y坐标的最大值，第一根切割线不可能位于第一个矩形右上角的的下方，所以从rectangles[0][3]开始判断
         */
        int topIndex = rectangles[0][3];

        for (int i = 1; i < rectangles.length; i++) {
            /**
             * 从矩形rectangles[i]开始，后面的所有矩形都在直线y=topIndex的上方（含），所以y=topIndex是一根符合要求的切割线
             */
            if (rectangles[i][1] >= topIndex) {
                if (findOne) {
                    /**
                     * 已找到第二根符合要求的切割线
                     */
                    return true;
                } else {
                    findOne = true;
                }
            }
            /**
             * 更新已遍历过的所有矩形右上角的y坐标的最大值
             */
            topIndex = Math.max(topIndex, rectangles[i][3]);
        }
        return false;
    }
}
