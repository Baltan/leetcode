package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Description: 850. Rectangle Area II
 *
 * @author baltan
 * @date 2024/8/8 09:50
 */
public class RectangleArea {
    public static void main(String[] args) {
        int[][] rectangles1 = {{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}};
        System.out.println(rectangleArea(rectangles1));

        int[][] rectangles2 = {{0, 0, 1000000000, 1000000000}};
        System.out.println(rectangleArea(rectangles2));

        int[][] rectangles3 = {{0, 0, 1, 1}, {2, 2, 3, 3}};
        System.out.println(rectangleArea(rectangles3));

        int[][] rectangles4 = {{25, 20, 70, 27}, {68, 80, 79, 100}, {37, 41, 66, 76}};
        System.out.println(rectangleArea(rectangles4));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/rectangle-area-ii/solutions/1826992/gong-shui-san-xie-by-ac_oier-9r36/"></a>
     *
     * @param rectangles
     * @return
     */
    public static int rectangleArea(int[][] rectangles) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 保存所有矩形顶点的x坐标
         */
        List<Integer> xList = new ArrayList<>();

        for (int[] info : rectangles) {
            xList.add(info[0]);
            xList.add(info[2]);
        }
        Collections.sort(xList);
        /**
         * 遍历x轴上的每一段区间
         */
        for (int i = 1; i < xList.size(); i++) {
            int leftX = xList.get(i - 1);
            int rightX = xList.get(i);
            /**
             * x轴上区间内的长度
             */
            int xLength = rightX - leftX;

            if (xLength == 0) {
                continue;
            }
            /**
             * 保存x轴上[leftX,rightX]区间内的矩形在y轴方向上的线段，所有线段优先按照起点升序排列，起点相同时按照终点升序排列
             */
            TreeSet<int[]> ySegments = new TreeSet<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

            for (int[] rectangle : rectangles) {
                /**
                 * 只有某个矩形的左边顶点x坐标不大于leftX，并且右边顶点x坐标不小于rightX，这个矩形在x轴上[leftX,rightX]区间内才有面积
                 * 覆盖
                 */
                if (rectangle[0] <= leftX && rectangle[2] >= rightX) {
                    ySegments.add(new int[]{rectangle[1], rectangle[3]});
                }
            }
            /**
             * 说明在x轴上[leftX,rightX]区间内没有矩形面积覆盖
             */
            if (ySegments.isEmpty()) {
                continue;
            }
            /**
             * y轴方向上的总长度（所有线段的并集）
             */
            long yLength = 0L;
            int[] prevSegment = ySegments.pollFirst();

            while (!ySegments.isEmpty()) {
                int[] currSegment = ySegments.pollFirst();
                if (currSegment[0] > prevSegment[1]) {
                    /**
                     * 两条线段的关系为
                     * <pre>
                     *         |
                     *         |
                     *
                     *     |
                     *     |
                     * </pre>
                     * 将第一条线段的长度计入y轴方向上的总长度中
                     */
                    yLength += prevSegment[1] - prevSegment[0];
                    prevSegment = currSegment;
                } else {
                    /**
                     * 两条线段的关系为
                     * <pre>
                     *         |
                     *     |   |
                     *     |
                     * </pre>
                     * 或
                     * <pre>
                     *     |
                     *     |   |
                     *     |
                     * </pre>
                     * 两条线段取并集后，起点仍为第一条线段的起点，终点为两线段终点的较大值
                     */
                    prevSegment[1] = Math.max(prevSegment[1], currSegment[1]);
                }
            }
            /**
             * 最后一部分线段取交集的总长度
             */
            yLength += prevSegment[1] - prevSegment[0];
            /**
             * x轴上区间内的总面积
             */
            result = (result + yLength * xLength) % mod;
        }
        return (int) result;
    }
}
