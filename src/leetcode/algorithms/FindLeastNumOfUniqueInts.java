package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1481. Least Number of Unique Integers after K Removals
 *
 * @author Baltan
 * @date 2020-06-17 20:37
 */
public class FindLeastNumOfUniqueInts {
    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        /**
         * 数字i -> 数字i在数组arr中出现的次数
         */
        Map<Integer, Integer> map1 = new HashMap<>();

        for (int value : arr) {
            map1.put(value, map1.getOrDefault(value, 0) + 1);
        }
        /**
         * 数组arr中不同数字的个数
         */
        int total = map1.size();
        /**
         * 数字在数组arr中出现的次数i -> 在数组arr中出现i次的数字的列表
         */
        Map<Integer, List<Integer>> map2 = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            map2.putIfAbsent(entry.getValue(), new ArrayList<>());
            map2.get(entry.getValue()).add(entry.getKey());
        }
        /**
         * 因为要求不同整数的个数尽可能少，所以要优先移除出现次数少的元素
         */
        for (Map.Entry<Integer, List<Integer>> entry : map2.entrySet()) {
            /**
             * 数字在数组arr中出现次数
             */
            int frequency = entry.getKey();
            /**
             * 数组arr中出现frequency次的数字的个数
             */
            int size = entry.getValue().size();

            if (size * frequency >= k) {
                /**
                 * 可以将k/frequency个不同数字完全移除
                 */
                total -= k / frequency;
                return total;
            } else {
                /**
                 * 将size个不同数组完全移除
                 */
                k -= size * frequency;
                total -= size;
            }
        }
        return total;
    }
}
