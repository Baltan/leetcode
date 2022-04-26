package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 2250. Count Number of Rectangles Containing Each Point
 *
 * @author Baltan
 * @date 2022/4/25 21:51
 */
public class CountRectangles {
    public static void main(String[] args) {
        int[][] rectangles1 = {{1, 2}, {2, 3}, {2, 5}};
        int[][] points1 = {{2, 1}, {1, 4}};
        OutputUtils.print1DIntegerArray(countRectangles(rectangles1, points1));

        int[][] rectangles2 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] points2 = {{1, 3}, {1, 1}};
        OutputUtils.print1DIntegerArray(countRectangles(rectangles2, points2));

        int[][] rectangles3 = {{7, 1}, {2, 6}, {1, 4}, {5, 2}, {10, 3}, {2, 4}, {5, 9}};
        int[][] points3 = {{10, 3}, {8, 10}, {2, 3}, {5, 4}, {8, 5}, {7, 10}, {6, 6}, {3, 6}};
        OutputUtils.print1DIntegerArray(countRectangles(rectangles3, points3));

        int[][] rectangles4 = {{6, 4}, {10, 2}, {5, 5}, {1, 6}, {3, 2}, {9, 5}, {7, 6}};
        int[][] points4 = {{2, 1}, {2, 8}, {8, 4}, {10, 8}, {5, 6}, {1, 4}, {2, 4}, {2, 2}, {6, 10}};
        OutputUtils.print1DIntegerArray(countRectangles(rectangles4, points4));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/count-number-of-rectangles-containing-each-point/solution/pai-xu-pai-xu-pai-xu-pythonjavacgo-by-en-ou4k/">方法二：按横坐标排序</a>
     *
     * @param rectangles
     * @param points
     * @return
     */
    public static int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] result = new int[points.length];
        int pointCount = points.length;
        int rectangleIndex = 0;
        /**
         * 所有点的索引数组[0,1,2,……,pointCount-1]
         */
        Integer[] pointIndexes = IntStream.range(0, pointCount).boxed().toArray(Integer[]::new);
        /**
         * rectangleCountSameHeight[i]表示高度为i（即纵坐标为i）的矩形的个数，依据题意，所有矩形的高度范围为[1,100]
         */
        int[] rectangleCountSameY = new int[101];
        /**
         * 将所有矩形按照长（即横坐标的值）的大小倒序排列
         */
        Arrays.sort(rectangles, (x, y) -> y[0] - x[0]);
        /**
         * 将每个点在数组points的索引按照点的横坐标值倒序排列
         */
        Arrays.sort(pointIndexes, (i, j) -> points[j][0] - points[i][0]);

        for (int pointIndex : pointIndexes) {
            int[] point = points[pointIndex];
            /**
             * 对于当前判断的点points[pointIndex]，查找所有横坐标大于等于该点的矩形，将它们按照纵坐标值进行分组计数
             */
            while (rectangleIndex < rectangles.length && rectangles[rectangleIndex][0] >= point[0]) {
                int height = rectangles[rectangleIndex][1];
                rectangleCountSameY[height]++;
                rectangleIndex++;
            }
            /**
             * 以上矩形中，纵坐标值也大于等于points纵坐标值的矩阵符合题目要求，即矩阵纵坐标值的范围为[point[1],100]，将这部分
             * 矩阵的个数累加即可
             */
            for (int i = point[1]; i < rectangleCountSameY.length; i++) {
                result[pointIndex] += rectangleCountSameY[i];
            }
        }
        return result;
    }
}
