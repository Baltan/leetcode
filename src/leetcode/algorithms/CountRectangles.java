package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 2250. Count Number of Rectangles Containing Each Point
 *
 * @author Baltan
 * @date 2022/4/25 21:51
 */
public class CountRectangles {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int[][] rectangles1 = {{1, 2}, {2, 3}, {2, 5}};
        int[][] points1 = {{2, 1}, {1, 4}};
        OutputUtils.print1DIntegerArray(countRectangles(rectangles1, points1));

        int[][] rectangles2 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] points2 = {{1, 3}, {1, 1}};
        OutputUtils.print1DIntegerArray(countRectangles(rectangles2, points2));

        int[][] rectangles3 = {{7, 1}, {2, 6}, {1, 4}, {5, 2}, {10, 3}, {2, 4}, {5, 9}};
        int[][] points3 = {{10, 3}, {8, 10}, {2, 3}, {5, 4}, {8, 5}, {7, 10}, {6, 6}, {3, 6}};
        OutputUtils.print1DIntegerArray(countRectangles(rectangles3, points3));

        int[][] rectangles4 = {{6,4},{10,2},{5,5},{1,6},{3,2},{9,5},{7,6}};
        int[][] points4 = {{2,1},{2,8},{8,4},{10,8},{5,6},{1,4},{2,4},{2,2},{6,10}};
        OutputUtils.print1DIntegerArray(countRectangles(rectangles4, points4));
    }

    public static int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] result = new int[points.length];
        int rectangleCount = rectangles.length;
        Arrays.sort(rectangles, Comparator.comparingInt(rectangle -> rectangle[1]));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int lo = 0;
            int hi = rectangleCount - 1;

            if (rectangles[hi][1] < y) {
                continue;
            }

            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (rectangles[mid][1] < y) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            for (int j = lo; j < rectangleCount; j++) {
                if (rectangles[j][0] >= x) {
                    result[i]++;
                }
            }
        }
        return result;
    }
}
