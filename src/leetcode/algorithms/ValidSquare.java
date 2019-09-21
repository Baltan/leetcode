package leetcode.algorithms;

import java.awt.*;

/**
 * Description: 593. Valid Square
 *
 * @author Baltan
 * @date 2019-09-21 22:18
 */
public class ValidSquare {
    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
        System.out.println(validSquare(new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Point point1 = new Point(p1[0], p1[1]);
        Point point2 = new Point(p2[0], p2[1]);
        Point point3 = new Point(p3[0], p3[1]);
        Point point4 = new Point(p4[0], p4[1]);
        /**
         * 如果存在任意两点重合，则不能构成正方形
         */
        if (point1.distance(point2) == 0 || point1.distance(point3) == 0 || point1.distance(point4) == 0 ||
                point2.distance(point3) == 0 || point2.distance(point4) == 0 ||
                point3.distance(point4) == 0) {
            return false;
        }
        /**
         * 如果p1p2=p3p4,p1p3=p3p2=p2p4=p4p1，则四边形是p1p3p2p4构成正方形
         */
        if (point1.distance(point2) == point3.distance(point4) &&
                point1.distance(point3) == point3.distance(point2) &&
                point3.distance(point2) == point2.distance(point4) &&
                point2.distance(point4) == point4.distance(point1)) {
            return true;
        }
        /**
         * 如果p1p3=p2p4,p1p2=p2p3=p3p4=p4p1，则四边形是p1p2p3p4构成正方形
         */
        if (point1.distance(point3) == point2.distance(point4) &&
                point1.distance(point2) == point2.distance(point3) &&
                point2.distance(point3) == point3.distance(point4) &&
                point3.distance(point4) == point4.distance(point1)) {
            return true;
        }
        /**
         * 如果p1p4=p2p3,p1p2=p2p4=p4p3=p3p1，则四边形是p1p2p4p3构成正方形
         */
        if (point1.distance(point4) == point2.distance(point3) &&
                point1.distance(point2) == point2.distance(point4) &&
                point2.distance(point4) == point4.distance(point3) &&
                point4.distance(point3) == point3.distance(point1)) {
            return true;
        }
        /**
         * 如果以上三种情况都不是正方形，则不能构成正方形
         */
        return false;
    }
}
