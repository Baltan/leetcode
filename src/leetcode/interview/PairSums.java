package leetcode.interview;

import java.util.*;

/**
 * Description: 面试题 16.24. 数对和
 *
 * @author Baltan
 * @date 2020-04-11 18:00
 * @see PairSums1
 */
public class PairSums {
    public static void main(String[] args) {
        System.out.println(pairSums(new int[]{5, 6, 5}, 11));
        System.out.println(pairSums(new int[]{5, 6, 5, 6}, 11));
        System.out.println(pairSums(new int[]{5}, 1));
        System.out.println(pairSums(new int[]{-2, -1, 0, 3, 5, 6, 7, 9, 13, 14}, 12));
    }

    public static List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        /**
         * 数字num -> num在数组nums中出现的次数
         */
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value1 = entry.getKey();
            int count1 = entry.getValue();
            int value2 = target - value1;
            int count2 = map.getOrDefault(value2, 0);
            /**
             * 如果value1和value2相等，则value1和value2至多可以构成count1/2个整数对，否则value1和value2
             * 至多可以构成Math.min(count1,count2)个整数对
             */
            int min = value1 == value2 ? count1 / 2 : Math.min(count1, count2);
            /**
             * 将value1和value2使用过的次数扣除
             */
            if (value1 == value2) {
                map.put(value1, count1 - min * 2);
            } else {
                map.put(value1, count1 - min);
                /**
                 * 如果value2在数组nums中存在才更新value2的出现次数，否则会抛出
                 * ConcurrentModificationException异常
                 */
                if (map.containsKey(value2)) {
                    map.put(value2, count2 - min);
                }
            }
            /**
             * 将value1和value2构成的整数对加到result中
             */
            for (int i = 0; i < min; i++) {
                result.add(Arrays.asList(value1, value2));
            }
        }
        return result;
    }
}
