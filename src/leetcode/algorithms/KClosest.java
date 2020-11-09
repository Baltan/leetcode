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

        System.out.println("------------------------------");

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        OutputUtils.print2DIntegerArray(kClosest(points2, 2));

        int[][] points3 = {{0, 1}, {1, 0}};
        OutputUtils.print2DIntegerArray(kClosest(points3, 2));
    }

    public static int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        int length = points.length;
        /**
         * 保存points中所有点到原点的距离
         */
        int[] sortedDistances = new int[length];
        /**
         * distances[i]保存points[i]到原点的距离
         */
        int[] distances = new int[length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            int[] point = points[i];
            int distance = point[0] * point[0] + point[1] * point[1];
            sortedDistances[i] = distance;
            distances[i] = distance;
        }
        /**
         * 将points中所有点到原点的距离按照升序排列
         */
        Arrays.sort(sortedDistances);
        /**
         * points中距离原点第K远的点到原点的距离
         */
        int KthDistance = sortedDistances[K - 1];

        for (int i = 0; i < length; i++) {
            int[] point = points[i];
            int distance = distances[i];

            if (distance <= KthDistance) {
                result[index++] = point;
                /**
                 * 已经找到K个符合要求的点，退出循环
                 */
                if (index == K) {
                    break;
                }
            }
        }
        return result;
    }
}
