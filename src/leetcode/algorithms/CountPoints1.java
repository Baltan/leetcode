package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1828. Queries on Number of Points Inside a Circle
 *
 * @author Baltan
 * @date 2022/6/14 09:23
 */
public class CountPoints1 {
    public static void main(String[] args) {
        int[][] points1 = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries1 = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        OutputUtils.print1DIntegerArray(countPoints(points1, queries1));

        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queries2 = {{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}};
        OutputUtils.print1DIntegerArray(countPoints(points2, queries2));
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];

            for (int[] point : points) {
                int m = point[0];
                int n = point[1];
                /**
                 * 点point到queries[i]圆心的距离小于等于queries[i]的半径，则点point就在queries[i]内部
                 */
                if ((x - m) * (x - m) + (y - n) * (y - n) <= r * r) {
                    result[i]++;
                }
            }
        }
        return result;
    }
}
