package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 1743. Restore the Array From Adjacent Pairs
 *
 * @author Baltan
 * @date 2022/7/28 16:34
 */
public class RestoreArray {
    public static void main(String[] args) {
        int[][] adjacentPairs1 = {{2, 1}, {3, 4}, {3, 2}};
        OutputUtils.print1DIntegerArray(restoreArray(adjacentPairs1));

        int[][] adjacentPairs2 = {{4, -2}, {1, 4}, {-3, 1}};
        OutputUtils.print1DIntegerArray(restoreArray(adjacentPairs2));

        int[][] adjacentPairs3 = {{100000, -100000}};
        OutputUtils.print1DIntegerArray(restoreArray(adjacentPairs3));
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        int[] result = new int[adjacentPairs.length + 1];
        int index = 0;
        /**
         * i -> i在adjacentPairs出现的次数，除了原数组中首尾两个元素各只出现了1次，其他元素都是出现2次
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        /**
         * i -> 原数组中和i相邻的两个元素
         */
        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
        /**
         * 原数组的第一个元素
         */
        int head = 0;

        for (int[] adjacentPair : adjacentPairs) {
            int x = adjacentPair[0];
            int y = adjacentPair[1];
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
            countMap.put(y, countMap.getOrDefault(y, 0) + 1);

            List<Integer> adjacentX = adjacentMap.computeIfAbsent(x, i -> new ArrayList<>());
            adjacentX.add(y);
            List<Integer> adjacentY = adjacentMap.computeIfAbsent(y, i -> new ArrayList<>());
            adjacentY.add(x);
        }
        /**
         * 查找原数组中的第0个元素
         */
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                head = entry.getKey();
                break;
            }
        }
        /**
         * 原数组的第0个元素
         */
        result[index++] = head;
        /**
         * 原数组的第1个元素
         */
        result[index++] = adjacentMap.get(head).get(0);
        /**
         * 每次循环，查找出原数组的第index个元素
         */
        while (index <= adjacentPairs.length) {
            /**
             * 和原数组的第index-1个元素相邻的元素
             */
            List<Integer> adjacentList = adjacentMap.get(result[index - 1]);

            for (int next : adjacentList) {
                /**
                 * 原数组的第k个元素一定不与原数组的第[k-2]个元素相同（k>=2）
                 */
                if (next != result[index - 2]) {
                    result[index++] = next;
                    break;
                }
            }
        }
        return result;
    }
}
