package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2848. Points That Intersect With Cars
 *
 * @author baltan
 * @date 2023/9/11 09:29
 */
public class NumberOfPoints {
    public static void main(String[] args) {
        System.out.println(numberOfPoints(Arrays.asList(Arrays.asList(3, 6), Arrays.asList(1, 5), Arrays.asList(4, 7))));
        System.out.println(numberOfPoints(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(5, 8))));
    }

    public static int numberOfPoints(List<List<Integer>> nums) {
        int result = 0;
        /**
         * points[i]表示数轴上坐标为i的点上是否有车
         */
        boolean[] points = new boolean[101];

        for (List<Integer> num : nums) {
            for (int i = num.get(0); i <= num.get(1); i++) {
                points[i] = true;
            }
        }

        for (boolean point : points) {
            result += point ? 1 : 0;
        }
        return result;
    }
}
