package leetcode.algorithms;

/**
 * Description: 84. Largest Rectangle in Histogram
 *
 * @author Baltan
 * @date 2019-09-29 09:08
 * @see LargestRectangleArea
 */
public class LargestRectangleArea1 {
    public static void main(String[] args) {
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights1));

        int[] heights2 = {5};
        System.out.println(largestRectangleArea(heights2));

        int[] heights3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(largestRectangleArea(heights3));

        int[] heights4 = {};
        System.out.println(largestRectangleArea(heights4));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/"></a>
     * 柱状图中面积最大的矩形，可能在以下三种情况中出现：
     * 1、定了最矮柱子以后，矩形的宽尽可能往两边延伸；
     * 2、在最矮柱子左边的最大面积矩形（子问题）；
     * 3、在最矮柱子右边的最大面积矩形（子问题）。
     * 三者取最大值即可。
     *
     * @param heights
     * @param start
     * @param end
     * @return
     */
    public static int largestRectangleArea(int[] heights, int start, int end) {
        int result = 0;

        if (start == end) {
            return heights[start];
        } else {
            int minHeight = heights[start];
            int minHeightIndex = start;
            /**
             * 查找start和end两个柱子间的最短的矩形高度
             */
            for (int i = start + 1; i <= end; i++) {
                if (heights[i] < minHeight) {
                    minHeight = heights[i];
                    minHeightIndex = i;
                }
            }
            /**
             * 定了最矮柱子以后，矩形的宽尽可能往两边延伸得到的矩形的最大面积
             */
            result = Math.max(result, (end - start + 1) * minHeight);
            /**
             * 如果最矮的柱子左边还有柱子，计算最矮柱子左边的最大矩形面积
             */
            if (start < minHeightIndex) {
                result = Math.max(result, largestRectangleArea(heights, start, minHeightIndex - 1));
            }
            /**
             * 如果最矮的柱子右边还有柱子，计算最矮柱子右边的最大矩形面积
             */
            if (minHeightIndex < end) {
                result = Math.max(result, largestRectangleArea(heights, minHeightIndex + 1, end));
            }
            return result;
        }
    }
}
