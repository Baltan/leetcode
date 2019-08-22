package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 1042. Flower Planting With No Adjacent
 *
 * @author Baltan
 * @date 2019-08-22 10:29
 */
public class GardenNoAdj {
    public static void main(String[] args) {
        int[][] paths1 = {{1, 2}, {2, 3}, {3, 1}};
        OutputUtils.print1DIntegerArray(gardenNoAdj(3, paths1));

        int[][] paths2 = {{1, 2}, {3, 4}};
        OutputUtils.print1DIntegerArray(gardenNoAdj(4, paths2));

        int[][] paths3 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}};
        OutputUtils.print1DIntegerArray(gardenNoAdj(4, paths3));
    }

    public static int[] gardenNoAdj(int N, int[][] paths) {
        int[] result = new int[N];
        result[0] = 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> follows = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        /**
         * 对于每个花园，统计编号小于该花园且与该花园相连的花园编号
         */
        for (int[] path : paths) {
            int from = Math.min(path[0], path[1]);
            int to = Math.max(path[0], path[1]);
            map.putIfAbsent(to, new ArrayList<>());
            map.get(to).add(from);
        }
        /**
         * 依次为2-N花园种花，对于每种花园，只考虑编号更小的花园，因为只有编号更小的花园已经种花了
         */
        for (int i = 2; i <= N; i++) {
            List<Integer> followList = new LinkedList<>(follows);
            List<Integer> fromList = map.get(i);
            /**
             * 如果当前花园没有与编号更小的花园相连，将当前花园种第1种花
             */
            if (fromList == null) {
                result[i - 1] = 1;
                continue;
            }
            /**
             * 排除当前花园相连的编号更小的花园已种的花，剩下的花的种类中，选择一种（可以选择花的编号最小的那种）种在当前花园
             */
            for (int j = 0; j < fromList.size(); j++) {
                int from = fromList.get(j);
                followList.remove(new Integer(result[from - 1]));
            }
            result[i - 1] = followList.get(0);
        }
        return result;
    }
}
