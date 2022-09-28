package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 1637. Widest Vertical Area Between Two Points Containing No Points
 *
 * @author Baltan
 * @date 2022/9/21 09:10
 */
public class MaxWidthOfVerticalArea {
    public static void main(String[] args) {
        int[][] points1 = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};
        System.out.println(maxWidthOfVerticalArea(points1));

        int[][] points2 = {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};
        System.out.println(maxWidthOfVerticalArea(points2));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        int result = 0;
        int length = points.length;
        /**
         * 将所有点按照x坐标升序排列
         */
        Arrays.sort(points, Comparator.comparingInt(x -> x[0]));

        for (int i = 1; i < length; i++) {
            /**
             * 相邻两个点x轴方向上的距离差
             */
            int width = points[i][0] - points[i - 1][0];

            if (width > result) {
                result = width;
            }
        }
        return result;
    }
}
