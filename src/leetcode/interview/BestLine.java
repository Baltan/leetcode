package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 面试题 16.14. 最佳直线
 *
 * @author Baltan
 * @date 2020-04-10 15:50
 * @see leetcode.algorithms.MaxPoints
 * @see leetcode.algorithms.MaxPoints1
 */
public class BestLine {
    public static void main(String[] args) {
        int[][] points1 = {{0, 0}, {1, 1}, {1, 0}, {2, 0}};
        OutputUtils.print1DIntegerArray(bestLine(points1));

        int[][] points2 =
                {{-24272, -29606}, {-37644, -4251}, {2691, -22513}, {-14592, -33765}, {-21858, 28550},
                        {-22264, 41303}, {-6960, 12785}, {-39133, -41833}, {25151, -26643}, {-19416, 28550},
                        {-17420, 22270}, {-8793, 16457}, {-4303, -25680}, {-14405, 26607}, {-49083, -26336},
                        {22629, 20544}, {-23939, -25038}, {-40441, -26962}, {-29484, -30503},
                        {-32927, -18287}, {-13312, -22513}, {15026, 12965}, {-16361, -23282}, {7296, -15750},
                        {-11690, -21723}, {-34850, -25928}, {-14933, -16169}, {23459, -9358},
                        {-45719, -13202}, {-26868, 28550}, {4627, 16457}, {-7296, -27760}, {-32230, 8174},
                        {-28233, -8627}, {-26520, 28550}, {5515, -26001}, {-16766, 28550}, {21888, -3740},
                        {1251, 28550}, {15333, -26322}, {-27677, -19790}, {20311, 7075}, {-10751, 16457},
                        {-47762, -44638}, {20991, 24942}, {-19056, -11105}, {-26639, 28550}, {-19862, 16457},
                        {-27506, -4251}, {-20172, -5440}, {-33757, -24717}, {-9411, -17379}, {12493, 29906},
                        {0, -21755}, {-36885, -16192}, {-38195, -40088}, {-40079, 7667}, {-29294, -34032},
                        {-55968, 23947}, {-22724, -22513}, {20362, -11530}, {-11817, -23957}, {-33742, 5259},
                        {-10350, -4251}, {-11690, -22513}, {-20241, -22513}};
        OutputUtils.print1DIntegerArray(bestLine(points2));
    }

    public static int[] bestLine(int[][] points) {
        int[] result = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int length = points.length;
        /**
         * 穿过最多点的直线穿过的点的个数
         */
        int maxCount = 0;
        /**
         * 点在points中的索引i -> [斜率gradient -> 和点points[i]相连斜率为gradient的所有点的索引集合]
         */
        Map<Integer, Map<Double, List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            /**
             * 斜率gradient -> 和点points[i]相连斜率为gradient的所有点的索引集合
             */
            Map<Double, List<Integer>> gradientMap = new HashMap<>();
            map.put(i, gradientMap);

            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }

                double gradient = points[j][0] == points[i][0] ? Double.POSITIVE_INFINITY :
                        1.0 * (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                /**
                 * 预先将points[i]加入集合中
                 */
                gradientMap.putIfAbsent(gradient, new ArrayList<>(Arrays.asList(i)));
                List<Integer> indexList = gradientMap.get(gradient);
                indexList.add(j);
                /**
                 * 更新穿过最多点的直线穿过的点的个数
                 */
                maxCount = Math.max(maxCount, indexList.size());
            }
        }

        for (Map<Double, List<Integer>> gradientMap : map.values()) {
            for (List<Integer> indexList : gradientMap.values()) {
                /**
                 * 找到所有点的数量为maxCount的集合
                 */
                if (indexList.size() == maxCount) {
                    /**
                     * 将集合中的元素按升序排列
                     */
                    Collections.sort(indexList);
                    /**
                     * 选择S[0]值较小的直线，S[0]相同则选择S[1]值较小的直线
                     */
                    if (indexList.get(0) < result[0]) {
                        result[0] = indexList.get(0);
                        result[1] = indexList.get(1);
                    } else if (indexList.get(0) == result[0] && indexList.get(1) < result[1]) {
                        result[1] = indexList.get(1);
                    }
                }
            }
        }
        return result;
    }
}
