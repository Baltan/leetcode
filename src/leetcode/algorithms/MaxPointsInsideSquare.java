package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 3143. Maximum Points Inside the Square
 *
 * @author baltan
 * @date 2024/5/13 09:09
 * @see MaxPointsInsideSquare1
 */
public class MaxPointsInsideSquare {
    public static void main(String[] args) {
        System.out.println(maxPointsInsideSquare(new int[][]{{2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}}, "abdca"));
        System.out.println(maxPointsInsideSquare(new int[][]{{1, 1}, {-2, -2}, {-2, 2}}, "abb"));
        System.out.println(maxPointsInsideSquare(new int[][]{{1, 1}, {-1, -1}, {2, -2}}, "ccd"));
    }

    public static int maxPointsInsideSquare(int[][] points, String s) {
        int result = 0;
        /**
         * 数组points中所有点的索引值
         */
        Integer[] indexes = IntStream.range(0, points.length)
                .boxed()
                .toArray(Integer[]::new);
        /**
         * distances[i]表示能包含点points[i]的最小正方形的边长
         */
        int[] distances = Arrays.stream(points)
                .mapToInt(x -> 2 * Math.max(Math.abs(x[0]), Math.abs(x[1])))
                .toArray();
        /**
         * 将数组points中所有点的索引值按照能包含该点的最小正方形的边长升序排列
         */
        Arrays.sort(indexes, Comparator.comparingInt(x -> distances[x]));
        int minDistance = 0;
        /**
         * 能覆盖数组points中所有点的最小正方形边长
         */
        int maxDistance = distances[indexes[indexes.length - 1]];
        /**
         * isVisited[0]-isVisited[25]依次表示某个正方形包含的所有点中，是否包含标签为a-z的点
         */
        boolean[] isVisited = new boolean[26];
        /**
         * 二分查找包含的所有点中，不存在重复标签的最大正方形
         */
        outer:
        while (minDistance < maxDistance) {
            int midDistance = (minDistance + maxDistance + 1) / 2;
            int lo = 0;
            int hi = indexes.length - 1;
            Arrays.fill(isVisited, false);
            /**
             * 在数组indexes中二分查找位置在边长为midDistance的正方形内的最后一个点的索引值
             */
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;

                if (distances[indexes[mid]] > midDistance) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
            /**
             * 判断在边长为midDistance的正方形内的所有点的标签是否都不同
             */
            for (int i = 0; i <= lo; i++) {
                char tag = s.charAt(indexes[i]);

                if (isVisited[tag - 'a']) {
                    maxDistance = midDistance - 1;
                    continue outer;
                }
                isVisited[tag - 'a'] = true;
            }
            minDistance = midDistance;
        }
        /**
         * 计算边长为minDistance的正方形中包含的点的个数
         */
        for (int distance : distances) {
            if (distance <= minDistance) {
                result++;
            }
        }
        return result;
    }
}
