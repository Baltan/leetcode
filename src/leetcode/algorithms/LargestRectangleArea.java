package leetcode.algorithms;

/**
 * Description: 84. Largest Rectangle in Histogram
 *
 * @author Baltan
 * @date 2019-09-29 09:08
 * @see LargestRectangleArea1
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights1));

        int[] heights2 = {5};
        System.out.println(largestRectangleArea(heights2));

        int[] heights3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(largestRectangleArea(heights3));
    }

    public static int largestRectangleArea(int[] heights) {
        int result = 0;
        int count = heights.length;
        /**
         * 逐一判断每两个柱子间的矩形面积
         */
        for (int i = 0; i < count; i++) {
            /**
             * 保存两个柱子间的最短的矩形高度
             */
            int minHeight = heights[i];
            /**
             * 固定矩形的左边为heights[i]后，逐一计算右边为heights[j]时，两边和x轴所能围成的最
             * 大矩形的面积
             */
            for (int j = i; j < count; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                result = Math.max(result, (j - i + 1) * minHeight);
            }
        }
        return result;
    }
}
