package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 3143. Maximum Points Inside the Square
 *
 * @author baltan
 * @date 2024/5/13 09:09
 * @see MaxPointsInsideSquare
 */
public class MaxPointsInsideSquare1 {
    public static void main(String[] args) {
        System.out.println(maxPointsInsideSquare(new int[][]{{-1, -4}, {16, -8}, {13, -3}, {-12, 0}}, "abda"));
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
        /**
         * isVisited[0]-isVisited[25]依次表示某个正方形包含的所有点中，是否包含标签为a-z的点
         */
        boolean[] isVisited = new boolean[26];
        /**
         * 当前正方形的边长，初始化-1作为哨兵
         */
        int edge = -1;
        /**
         * 正方形边长增大后多包含的点数
         */
        int pointCount = 0;
        /**
         * 正方形边长增大后多包含的点是否有效
         */
        boolean adding = true;

        for (int index : indexes) {
            char tag = s.charAt(index);

            if (distances[index] == edge) {
                if (isVisited[tag - 'a']) {
                    adding = false;
                    break;
                } else {
                    isVisited[tag - 'a'] = true;
                    pointCount++;
                }
            } else {
                /**
                 * 上一个较小正方形中的所有点都可以被包含
                 */
                result += pointCount;
                /**
                 * 考虑边长为distances[index]的更大的正方形可以包含的点数
                 */
                edge = distances[index];

                if (isVisited[tag - 'a']) {
                    adding = false;
                    break;
                } else {
                    isVisited[tag - 'a'] = true;
                    pointCount = 1;
                }
            }
        }
        return result + (adding ? pointCount : 0);
    }
}
