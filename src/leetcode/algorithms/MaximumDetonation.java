package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2101. Detonate the Maximum Bombs
 *
 * @author Baltan
 * @date 2021/12/15 09:04
 */
public class MaximumDetonation {
    public static void main(String[] args) {
        int[][] bombs1 = {{2, 1, 3}, {6, 1, 4}};
        System.out.println(maximumDetonation(bombs1));

        int[][] bombs2 = {{1, 1, 5}, {10, 10, 5}};
        System.out.println(maximumDetonation(bombs2));

        int[][] bombs3 = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
        System.out.println(maximumDetonation(bombs3));

        int[][] bombs4 = {{1, 1, 1}};
        System.out.println(maximumDetonation(bombs4));

        int[][] bombs5 =
                {{56, 80, 2}, {55, 9, 10}, {32, 75, 2}, {87, 89, 1}, {61, 94, 3}, {43, 82, 9}, {17, 100, 6},
                        {50, 6, 7}, {9, 66, 7}, {98, 3, 6}, {67, 50, 2}, {79, 39, 5}, {92, 60, 10},
                        {49, 9, 9}, {42, 32, 10}};
        System.out.println(maximumDetonation(bombs5));

        int[][] bombs6 =
                {{848, 9996, 2538}, {5815, 2089, 5593}, {2797, 4604, 6471}, {7941, 7778, 1038},
                        {5615, 5851, 3959}, {9707, 4596, 1091}, {5850, 8410, 6708}, {9751, 8460, 654},
                        {2415, 632, 7311}, {7151, 7568, 2581}, {1536, 437, 6566}, {2646, 5538, 6490},
                        {5292, 2344, 2480}, {833, 235, 7897}, {9906, 3798, 2243}, {5945, 1083, 3824},
                        {683, 4808, 9405}, {8473, 6108, 6170}, {1284, 2199, 2158}, {1083, 7707, 3459},
                        {4302, 9736, 3480}, {8967, 2076, 9546}, {6750, 6135, 3404}, {7023, 4773, 1467},
                        {7982, 5814, 3776}, {6208, 4763, 5567}, {6874, 8877, 5310}, {279, 4586, 9268},
                        {3298, 5366, 121}, {8966, 7886, 4878}, {8239, 9442, 2982}, {3055, 746, 6722},
                        {4479, 1550, 7101}, {3717, 5391, 356}, {3104, 9472, 4409}, {8985, 8879, 3634},
                        {8814, 1880, 1337}, {8523, 317, 8626}, {6427, 9500, 5972}, {4549, 9792, 6245},
                        {97, 7897, 3070}, {7604, 5368, 364}, {7569, 4841, 9398}, {2643, 2327, 4913},
                        {7236, 1655, 8592}, {8807, 1086, 6020}, {402, 6802, 9981}, {3522, 9641, 4632},
                        {3808, 732, 6966}, {4863, 5138, 6387}, {3516, 6454, 7207}, {9575, 2748, 4530},
                        {3933, 2958, 9189}, {6099, 2502, 4242}, {2030, 2938, 7929}, {2439, 5492, 2018},
                        {9434, 7197, 1482}, {5450, 3651, 1474}, {4322, 6277, 3761}, {1085, 3390, 5254},
                        {6329, 4227, 4834}, {8870, 9076, 2404}, {17, 6594, 3948}, {3236, 9319, 8381},
                        {214, 7066, 9765}, {7047, 9386, 4768}, {8161, 9810, 8658}, {432, 2774, 7252},
                        {486, 2483, 4042}, {8783, 9247, 5459}, {9421, 8397, 2558}, {7485, 4960, 1393},
                        {7088, 9769, 2865}, {61, 1432, 7859}, {1443, 4679, 3004}, {1311, 8572, 929},
                        {2883, 7046, 9921}, {1689, 610, 9803}, {1019, 3429, 1662}, {1398, 8116, 3149},
                        {1253, 71, 8957}, {835, 4573, 6361}, {3729, 9518, 6579}, {6894, 277, 7968},
                        {1682, 8115, 5086}, {4440, 6722, 304}, {9494, 1155, 2192}, {1825, 4376, 6062},
                        {1075, 5078, 3124}, {6954, 6535, 3417}, {3656, 9632, 4900}, {9154, 5514, 7632},
                        {6786, 484, 3183}, {6304, 2125, 6729}, {6803, 3756, 8907}, {3141, 6138, 2838},
                        {8891, 3173, 3311}, {4219, 6318, 9726}, {1718, 1626, 2360}, {4104, 3047, 5886}};
        System.out.println(maximumDetonation(bombs6));
    }

    public static int maximumDetonation(int[][] bombs) {
        int result = 0;
        int length = bombs.length;
        /**
         * i -> [j -> distance] 表示bombs[i]和bombs[j]根据勾股定理计算的距离
         */
        Map<Integer, Map<Integer, Double>> distanceMap = new HashMap<>();
        /**
         * 将bombs按照爆炸半径从大到小排序，因为爆炸半径大的可能比爆炸半径小的能引爆更多的炸弹，所以优先判断
         */
        Arrays.sort(bombs, (x, y) -> y[2] - x[2]);
        /**
         * isVisited[i]表示bombs[i]是否被引爆过，避免重复计算
         */
        boolean[] isVisited = new boolean[length];
        /**
         * 计算任意两个炸弹之间的距离
         */
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                double distance =
                        Math.sqrt(Math.pow(bombs[i][0] - bombs[j][0], 2) +
                                Math.pow(bombs[i][1] - bombs[j][1], 2));
                Map<Integer, Double> innerMap1 = distanceMap.computeIfAbsent(i, x -> new HashMap<>());
                innerMap1.put(j, distance);
                Map<Integer, Double> innerMap2 = distanceMap.computeIfAbsent(j, x -> new HashMap<>());
                innerMap2.put(i, distance);
            }
        }

        for (int i = 0; i < length; i++) {
            if (isVisited[i]) {
                continue;
            }
            /**
             * 开始引爆bombs[i]，isDetonated[x]表示bombs[x]最终被引爆
             */
            boolean[] isDetonated = new boolean[length];
            detonateBombs(isVisited, isDetonated, distanceMap, bombs, Arrays.asList(i));
            int count = 0;

            for (boolean bool : isDetonated) {
                if (bool) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }

    /**
     * 递归计算bombs中索引位置的炸弹被引爆后，可以继续引爆的所有炸弹
     *
     * @param isVisited
     * @param isDetonated
     * @param distanceMap
     * @param bombs
     * @param startBombs
     * @return
     */
    public static void detonateBombs(boolean[] isVisited, boolean[] isDetonated,
                                     Map<Integer, Map<Integer, Double>> distanceMap, int[][] bombs,
                                     List<Integer> startBombs) {
        for (int startBomb : startBombs) {
            /**
             * 保存bombs[startBomb]爆炸后，可以直接引爆的炸弹的索引
             */
            List<Integer> nextBombs = new ArrayList<>();
            isDetonated[startBomb] = true;
            isVisited[startBomb] = true;
            /**
             * 当只有一个炸弹时可能会存在这种情况
             */
            if (!distanceMap.containsKey(startBomb)) {
                continue;
            }

            for (Map.Entry<Integer, Double> entry : distanceMap.get(startBomb).entrySet()) {
                int otherBomb = entry.getKey();
                double distance = entry.getValue();
                /**
                 * 当另一个炸弹和当前炸弹圆心的距离不大于当前炸弹的爆炸半径时，另一个炸弹会被引爆
                 */
                if (!isDetonated[otherBomb] && distance <= bombs[startBomb][2]) {
                    nextBombs.add(otherBomb);
                }
            }
            /**
             * 递归计算
             */
            detonateBombs(isVisited, isDetonated, distanceMap, bombs, nextBombs);
        }
    }
}
