package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2013. Detect Squares
 *
 * @author Baltan
 * @date 2021/12/3 11:30
 */
public class DetectSquares {
    public static void main(String[] args) {
        DetectSquares detectSquares1 = new DetectSquares();
        detectSquares1.add(new int[]{3, 10});
        detectSquares1.add(new int[]{11, 2});
        detectSquares1.add(new int[]{3, 2});
        System.out.println(detectSquares1.count(new int[]{11, 10}));
        System.out.println(detectSquares1.count(new int[]{14, 8}));
        detectSquares1.add(new int[]{11, 2});
        System.out.println(detectSquares1.count(new int[]{11, 10}));

        System.out.println("----------------------------");

        DetectSquares detectSquares2 = new DetectSquares();
        detectSquares2.add(new int[]{419, 351});
        detectSquares2.add(new int[]{798, 351});
        detectSquares2.add(new int[]{798, 730});
        System.out.println(detectSquares2.count(new int[]{419, 730}));

        System.out.println("----------------------------");

        DetectSquares detectSquares3 = new DetectSquares();
        detectSquares3.add(new int[]{5, 10});
        detectSquares3.add(new int[]{10, 5});
        detectSquares3.add(new int[]{10, 10});
        System.out.println(detectSquares3.count(new int[]{5, 5}));
        detectSquares3.add(new int[]{3, 0});
        detectSquares3.add(new int[]{8, 0});
        detectSquares3.add(new int[]{8, 5});
        System.out.println(detectSquares3.count(new int[]{3, 5}));
        detectSquares3.add(new int[]{});
        detectSquares3.add(new int[]{});
        detectSquares3.add(new int[]{});
        System.out.println(detectSquares3.count(new int[]{}));
        detectSquares3.add(new int[]{});
        detectSquares3.add(new int[]{});
        detectSquares3.add(new int[]{});
        System.out.println(detectSquares3.count(new int[]{}));
        detectSquares3.add(new int[]{});
        detectSquares3.add(new int[]{});
        detectSquares3.add(new int[]{});
        System.out.println(detectSquares3.count(new int[]{}));
        detectSquares3.add(new int[]{});
        detectSquares3.add(new int[]{});
        detectSquares3.add(new int[]{});
        System.out.println(detectSquares3.count(new int[]{}));
    }

    /**
     * 横坐标 -> [纵坐标 -> (x,y)坐标点的数量]
     */
    private Map<Integer, Map<Integer, Integer>> pointXMap;

    public DetectSquares() {
        pointXMap = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        if (pointXMap.containsKey(x)) {
            Map<Integer, Integer> pointXYMap = pointXMap.get(x);
            pointXYMap.put(y, pointXYMap.getOrDefault(y, 0) + 1);
        } else {
            Map<Integer, Integer> pointXYMap = new HashMap<>();
            pointXYMap.put(y, 1);
            pointXMap.put(x, pointXYMap);
        }
    }

    public int count(int[] point) {
        int result = 0;
        /**
         * 逐一判断已经存在的点能否和point构成对角线
         */
        for (Map.Entry<Integer, Map<Integer, Integer>> xEntry : pointXMap.entrySet()) {
            int x = xEntry.getKey();
            /**
             * 和point横坐标相同的点不能和point构成对角线
             */
            if (x == point[0]) {
                continue;
            }

            for (Map.Entry<Integer, Integer> yEntry : xEntry.getValue().entrySet()) {
                int y = yEntry.getKey();
                /**
                 * 和point纵坐标相同的点不能和point构成对角线
                 */
                if (y == point[1]) {
                    continue;
                }
                /**
                 * 和point横坐标上距离和纵坐标上距离不相同的点不能和point构成正方形
                 */
                if (Math.abs(x - point[0]) != Math.abs(y - point[1])) {
                    continue;
                }
                /**
                 * 对角线顶点的数量
                 */
                int diagonalPointCount = yEntry.getValue();
                /**
                 * 相邻点的数量
                 */
                int adjacentPointCount1 =
                        pointXMap.getOrDefault(point[0], new HashMap<>()).getOrDefault(y, 0);
                /**
                 * 相邻点的数量
                 */
                int adjacentPointCount2 =
                        pointXMap.getOrDefault(x, new HashMap<>()).getOrDefault(point[1], 0);
                /**
                 * 可以构成的正方形的数量
                 */
                result += diagonalPointCount * adjacentPointCount1 * adjacentPointCount2;
            }
        }
        return result;
    }
}
