package leetcode.algorithms;

/**
 * Description: 812. Largest Triangle Area
 *
 * @author Baltan
 * @date 2018/7/31 17:04
 */
public class LargestTriangleArea {
    public static void main(String[] args) {
        int[][] points1 = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(largestTriangleArea(points1));
        int[][] points2 = {{1, 0}, {0, 0}, {0, 1}};
        System.out.println(largestTriangleArea(points2));
    }

    public static double largestTriangleArea(int[][] points) {
        double area = 0;

        for (int[] pointA : points) {
            for (int[] pointB : points) {
                for (int[] pointC : points) {
                    double s;
                    s = Math.abs(pointA[0] * (pointB[1] - pointC[1]) * 1.0 + pointB[0] * (pointC[1] -
                            pointA[1]) * 1.0 + pointC[0] * (pointA[1] - pointB[1]) * 1.0) / 2;
                    area = Math.max(area, s);
                }
            }
        }
        return area;
    }
}
