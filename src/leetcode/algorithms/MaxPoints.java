package leetcode.algorithms;

import leetcode.entity.Point;

/**
 * Description: 149. Max Points on a Line
 *
 * @author Baltan
 * @date 2018/8/28 12:03
 * @see leetcode.interview.BestLine
 * @see MaxPoints1
 */
public class MaxPoints {
    public static void main(String[] args) {
        Point[] points1 = {new Point(1, 1), new Point(2, 2), new Point(3, 3)};
        System.out.println(maxPoints(points1));

        Point[] points2 =
                {new Point(1, 1), new Point(3, 2), new Point(5, 3), new Point(4, 1), new Point(2, 3), new
                        Point(1, 4)};
        System.out.println(maxPoints(points2));

        Point[] points3 = {new Point(1, 1), new Point(1, 1), new Point(2, 3)};
        System.out.println(maxPoints(points3));

        Point[] points4 = {new Point(1, 1), new Point(1, 2), new Point(1, 3)};
        System.out.println(maxPoints(points4));

        Point[] points5 = {new Point(1, 1), new Point(1, 2)};
        System.out.println(maxPoints(points5));

        Point[] points6 = {new Point(1, 1), new Point(1, 1)};
        System.out.println(maxPoints(points6));

        Point[] points7 = {new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2)};
        System.out.println(maxPoints(points7));

        Point[] points8 = {new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2), new Point(3,
                3), new Point(3, 3), new Point(3, 3)};
        System.out.println(maxPoints(points8));

        Point[] points9 = {new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2), new Point(1,
                3), new Point(1, 3), new Point(1, 3)};
        System.out.println(maxPoints(points9));

        Point[] points10 = {new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151)};
        System.out.println(maxPoints(points10));
    }

    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }

        int maxNum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Point pi = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point pj = points[j];
                int num = 2;
                if (pi.x == pj.x && pi.y == pj.y) {
                    for (int k = 0; k < points.length; k++) {
                        if (k != i && k != j) {
                            Point pk = points[k];
                            if (pk.x == pi.x && pk.y == pi.y) {
                                num++;
                            }
                        }
                    }
                } else {
                    double gradient1 =
                            pj.x - pi.x == 0 ? Double.POSITIVE_INFINITY :
                                    (pj.y - pi.y) / Double.valueOf(pj.x - pi.x);
                    for (int k = 0; k < points.length; k++) {
                        if (k != i && k != j) {
                            Point pk = points[k];
                            if (pk.x == pi.x && pk.y == pi.y) {
                                num += 1;
                                continue;
                            }
                            if (pk.x == pj.x && pk.y == pj.y) {
                                num += 1;
                                continue;
                            }
                            double gradient2 =
                                    pk.x - pj.x == 0 ? Double.POSITIVE_INFINITY :
                                            (pk.y - pj.y) / Double.valueOf(pk.x - pj.x);
                            if (gradient1 == gradient2) {
                                num += 1;
                            }
                        }
                    }
                }
                maxNum = Math.max(maxNum, num);
            }
        }
        return maxNum;
    }
}
