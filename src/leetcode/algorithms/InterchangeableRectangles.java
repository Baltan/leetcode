package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2001. Number of Pairs of Interchangeable Rectangles
 *
 * @author Baltan
 * @date 2021/12/9 23:12
 */
public class InterchangeableRectangles {
    public static void main(String[] args) {
        int[][] rectangles1 = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        System.out.println(interchangeableRectangles(rectangles1));

        int[][] rectangles2 = {{4, 5}, {7, 8}};
        System.out.println(interchangeableRectangles(rectangles2));

        int[][] rectangles3 = {{4, 2}, {1, 3}, {4, 1}, {4, 2}, {2, 4}, {1, 1}, {1, 1}};
        System.out.println(interchangeableRectangles(rectangles3));
    }

    public static long interchangeableRectangles(int[][] rectangles) {
        long result = 0;
        /**
         * 约分后width -> [ 约分后height -> 宽高比为约分后width/约分后height的矩形的数量 ]
         */
        Map<Integer, Map<Integer, Long>> ratioMap = new HashMap<>();

        for (int[] rectangle : rectangles) {
            int width = rectangle[0];
            int height = rectangle[1];
            /**
             * 宽和高的最大公约数
             */
            int gcd = gcd(width, height);
            /**
             * 约分后width
             */
            width /= gcd;
            /**
             * 约分后height
             */
            height /= gcd;
            Map<Integer, Long> innerMap = ratioMap.computeIfAbsent(width, i -> new HashMap<>());
            innerMap.put(height, innerMap.getOrDefault(height, 0L) + 1);
        }

        for (Map.Entry<Integer, Map<Integer, Long>> entry : ratioMap.entrySet()) {
            Map<Integer, Long> innerMap = entry.getValue();

            for (long count : innerMap.values()) {
                /**
                 * 如果宽高比为约分后width/约分后height的矩形的数量大于1，说明存在可互换矩形
                 */
                if (count >= 2) {
                    result += count * (count - 1) / 2;
                }
            }
        }
        return result;
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
