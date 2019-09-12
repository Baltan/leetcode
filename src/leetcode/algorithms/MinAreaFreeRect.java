package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 963. Minimum Area Rectangle II
 *
 * @author Baltan
 * @date 2019-09-12 11:04
 */
public class MinAreaFreeRect {
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
        final double THRESHOLD = 0.00001;
        Set<String> set = new HashSet<>();

        for (int[] point : points) {
            set.add(point[0] + "," + point[1]);
        }
        /**
         * 任选不同的三点产生三条直线，如果有两条直线相互垂直，并且查找到能构成矩形的第四点存在，则计算面积
         */
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];

                    double k12 = getGradient(p1, p2);
                    double k13 = getGradient(p1, p3);
                    double k23 = getGradient(p2, p3);

                    if (isPerpendicular(k12, k13, THRESHOLD)) {
                        int[] p4 = {p2[0] + p3[0] - p1[0], p2[1] + p3[1] - p1[1]};

                        if (set.contains(p4[0] + "," + p4[1])) {
                            double area = 2 * getArea(p1, p2, p3);
                            result = Math.min(result, area);
                        }
                    } else if (isPerpendicular(k12, k23, THRESHOLD)) {
                        int[] p4 = {p1[0] + p3[0] - p2[0], p1[1] + p3[1] - p2[1]};

                        if (set.contains(p4[0] + "," + p4[1])) {
                            double area = 2 * getArea(p1, p2, p3);
                            result = Math.min(result, area);
                        }
                    } else if (isPerpendicular(k13, k23, THRESHOLD)) {
                        int[] p4 = {p1[0] + p2[0] - p3[0], p1[1] + p2[1] - p3[1]};

                        if (set.contains(p4[0] + "," + p4[1])) {
                            double area = 2 * getArea(p1, p2, p3);
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
    public static double getGradient(int[] p1, int[] p2) {
        if (p1[0] == p2[0]) {
            return Double.POSITIVE_INFINITY;
        } else {
            return (p2[1] - p1[1]) * 1.0 / (p2[0] - p1[0]);
        }
    }

    /**
     * 海伦公式计算三角形面积，若三角形三边长分别为a，b，c，令p=(a+b+c)/2，则S=Math.sqrt(p*(p-a)*(p-b)*(p-c))
     *
     * @param p1
     * @param p2
     * @param p3
     * @return
     */
    public static double getArea(int[] p1, int[] p2, int[] p3) {
        double l12 = Math.sqrt(Math.pow((p2[1] - p1[1]), 2) + Math.pow((p2[0] - p1[0]), 2));
        double l13 = Math.sqrt(Math.pow((p3[1] - p1[1]), 2) + Math.pow((p3[0] - p1[0]), 2));
        double l23 = Math.sqrt(Math.pow((p3[1] - p2[1]), 2) + Math.pow((p3[0] - p2[0]), 2));
        double p = (l12 + l13 + l23) / 2;
        return Math.sqrt(p * (p - l12) * (p - l13) * (p - l23));
    }
}
