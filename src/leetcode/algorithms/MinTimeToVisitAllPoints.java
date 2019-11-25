package leetcode.algorithms;

/**
 * Description: 1266. Minimum Time Visiting All Points
 *
 * @author Baltan
 * @date 2019-11-25 09:06
 */
public class MinTimeToVisitAllPoints {
    public static void main(String[] args) {
        int[][] points1 = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points1));

        int[][] points2 = {{3, 2}, {-2, 2}};
        System.out.println(minTimeToVisitAllPoints(points2));

        int[][] points3 = {{3, 2}, {-2, 100}, {34, 98}, {28, 31}, {900, 566}, {767, -19}};
        System.out.println(minTimeToVisitAllPoints(points3));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        int length = points.length;

        for (int i = 1; i < length; i++) {
            int[] p1 = points[i - 1];
            int[] p2 = points[i];
            /**
             * 前后两点在x轴方向上的距离
             */
            int distanceX = Math.abs(p1[0] - p2[0]);
            /**
             * 前后两点在y轴方向上的距离
             */
            int distanceY = Math.abs(p1[1] - p2[1]);
            /**
             * 前后两点的距离为x轴方向上和y轴方向上距离的较大值，因为较小的那段距离可以通过走对角线省略
             */
            result += Math.max(distanceX, distanceY);
        }
        return result;
    }
}
