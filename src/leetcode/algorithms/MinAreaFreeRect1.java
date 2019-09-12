package leetcode.algorithms;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 963. Minimum Area Rectangle II
 *
 * @author Baltan
 * @date 2019-09-12 11:04
 */
public class MinAreaFreeRect1 {
    public static void main(String[] args) {
        int[][] points1 = {{1, 2}, {2, 1}, {1, 0}, {0, 1}};
        System.out.println(minAreaFreeRect(points1));

        int[][] points2 = {{0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0}};
        System.out.println(minAreaFreeRect(points2));

        int[][] points3 = {{0, 3}, {1, 2}, {3, 1}, {1, 3}, {2, 1}};
        System.out.println(minAreaFreeRect(points3));

        int[][] points4 = {{3, 1}, {1, 1}, {0, 1}, {2, 1}, {3, 3}, {3, 2}, {0, 2}, {2, 3}};
        System.out.println(minAreaFreeRect(points4));

        int[][] points5 =
                {{21080, 11854}, {9564, 5536}, {10136, 13399}, {9116, 8517}, {12178, 11167}, {14465, 11539},
                        {5816, 13867}, {9572, 18733}, {11317, 9594}, {20555, 22879}, {6500, 5440},
                        {2192, 8839}, {8719, 319}, {5888, 16550}, {9637, 5506}, {16100, 15840}, {9636, 13457},
                        {7020, 4960}, {21013, 13498}, {11244, 9624}, {14908, 22600}, {569, 5989},
                        {14264, 9177}, {848, 5863}, {12212, 16493}, {4399, 787}, {16620, 15360},
                        {11020, 4887}, {13940, 22564}, {10297, 7989}, {7957, 7702}, {13824, 12609},
                        {8676, 11949}, {1913, 8965}, {3887, 12660}, {6996, 15697}, {11993, 7448},
                        {9265, 7209}, {8108, 16125}, {12052, 5667}};
        System.out.println(minAreaFreeRect(points5));
    }

    public static double minAreaFreeRect(int[][] points) {
        double result = Double.MAX_VALUE;
        int length = points.length;
        Point[] pointArray = new Point[length];
        final double THRESHOLD = 0.00001;
        Set<Point> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            pointArray[i] = p;
            set.add(p);
        }
        /**
         * 任选不同的三点产生三条直线，如果有两条直线相互垂直，并且查找到能构成矩形的第四点存在，则计算面积
         */
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    Point p1 = pointArray[i];
                    Point p2 = pointArray[j];
                    Point p3 = pointArray[k];

                    double k12 = getGradient(p1, p2);
                    double k13 = getGradient(p1, p3);
                    double k23 = getGradient(p2, p3);

                    if (isPerpendicular(k12, k13, THRESHOLD)) {
                        Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);

                        if (set.contains(p4)) {
                            double area = p1.distance(p2) * p1.distance(p3);
                            result = Math.min(result, area);
                        }
                    } else if (isPerpendicular(k12, k23, THRESHOLD)) {
                        Point p4 = new Point(p1.x + p3.x - p2.x, p1.y + p3.y - p2.y);

                        if (set.contains(p4)) {
                            double area = p2.distance(p1) * p2.distance(p3);
                            result = Math.min(result, area);
                        }
                    } else if (isPerpendicular(k13, k23, THRESHOLD)) {
                        Point p4 = new Point(p1.x + p2.x - p3.x, p1.y + p2.y - p3.y);

                        if (set.contains(p4)) {
                            double area = p3.distance(p1) * p3.distance(p2);
                            result = Math.min(result, area);
                        }
                    }
                }
            }
        }
        return result == Double.MAX_VALUE ? 0 : result;
    }

    /**
     * 判断两个斜率的直线是否互相垂直，考虑小数精度问题，设置一个精度阈值threshold
     *
     * @param k1
     * @param k2
     * @param threshold
     * @return
     */
    public static boolean isPerpendicular(double k1, double k2, double threshold) {
        return (k1 == Double.POSITIVE_INFINITY && k2 == 0) ||
                (k1 == 0 && k2 == Double.POSITIVE_INFINITY) ||
                Math.abs(k1 * k2 + 1) < threshold;
    }

    /**
     * 计算两点连线的斜率，当两点连线垂直X轴时，斜率为正无穷，返回Double.POSITIVE_INFINITY
     *
     * @param p1
     * @param p2
     * @return
     */
    public static double getGradient(Point p1, Point p2) {
        if (p1.x == p2.x) {
            return Double.POSITIVE_INFINITY;
        } else {
            return (p2.y - p1.y) * 1.0 / (p2.x - p1.x);
        }
    }
}
