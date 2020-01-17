package leetcode.algorithms;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 939. Minimum Area Rectangle
 *
 * @author Baltan
 * @date 2020-01-15 14:28
 */
public class MinAreaRect {
    public static void main(String[] args) {
        int[][] points1 = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
        System.out.println(minAreaRect(points1));

        int[][] points2 = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}};
        System.out.println(minAreaRect(points2));
    }

    public static int minAreaRect(int[][] points) {
        int result = Integer.MAX_VALUE;
        Set<Point> set = new HashSet<>();
        /**
         * 将所有点的坐标加入集合set中
         */
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            set.add(new Point(x, y));
        }
        /**
         * 先确定矩形的左下顶点和右上顶点，这两个顶点可以唯一确定左上顶点和右下顶点的位置，如果左上顶
         * 点和右下顶点在集合set中存在，则能形成一个矩形，从所有矩形中选择面积最小的
         */
        for (int[] leftBottomPoint : points) {
            int leftBottomX = leftBottomPoint[0];
            int leftBottomY = leftBottomPoint[1];

            for (int[] rightTopPoint : points) {
                int rightTopX = rightTopPoint[0];
                int rightTopY = rightTopPoint[1];

                if (rightTopX > leftBottomX && rightTopY > leftBottomY &&
                        set.contains(new Point(leftBottomX, rightTopY)) &&
                        set.contains(new Point(rightTopX, leftBottomY))) {
                    int area = (rightTopX - leftBottomX) * (rightTopY - leftBottomY);
                    result = Math.min(result, area);
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
