package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 973. K Closest Points to Origin
 *
 * @author Baltan
 * @date 2019-03-19 15:42
 */
public class KClosest {
    public static void main(String[] args) {
        int[][] points1 = {{1, 3}, {-2, 2}};
        OutputUtils.print2DIntegerArray(kClosest(points1, 1));

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        OutputUtils.print2DIntegerArray(kClosest(points2, 2));

        int[][] points3 = {{0, 1}, {1, 0}};
        OutputUtils.print2DIntegerArray(kClosest(points3, 2));
    }

    public static int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        int length = points.length;
        int[] distanceArray = new int[length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            int[] point = points[i];
            distanceArray[i] = point[0] * point[0] + point[1] * point[1];
        }

        Arrays.sort(distanceArray);

        int KthDistance = distanceArray[K - 1];

        for (int i = 0; i < length; i++) {
            int[] point = points[i];
            int distance = point[0] * point[0] + point[1] * point[1];

            if (distance <= KthDistance) {
                result[index++] = point;
            }
        }
        return result;
    }
}
