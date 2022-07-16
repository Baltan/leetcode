package leetcode.algorithms;

/**
 * Description: 1779. Find Nearest Point That Has the Same X or Y Coordinate
 *
 * @author Baltan
 * @date 2022/7/14 17:22
 */
public class NearestValidPoint {
    public static void main(String[] args) {
        System.out.println(nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}));
        System.out.println(nearestValidPoint(3, 4, new int[][]{{3, 4}}));
        System.out.println(nearestValidPoint(3, 4, new int[][]{{2, 3}}));
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        int result = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            if (point[0] == x || point[1] == y) {
                int distance = Math.abs(point[0] - x) + Math.abs(point[1] - y);

                if (distance < minDistance) {
                    minDistance = distance;
                    result = i;
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : result;
    }
}
