package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2856. Minimum Array Length After Pair Removals
 *
 * @author Baltan
 * @date 2023/9/17 21:16
 */
public class MinLengthAfterRemovals {
    public static void main(String[] args) {
        System.out.println(minLengthAfterRemovals(Arrays.asList(1, 3, 4, 9)));
        System.out.println(minLengthAfterRemovals(Arrays.asList(2, 3, 6, 9)));
        System.out.println(minLengthAfterRemovals(Arrays.asList(1, 1, 2)));
    }

    public static int minLengthAfterRemovals(List<Integer> nums) {
        int result = 0;
        /**
         * 数字i -> 列表nums中数字i的频数
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        /**
         * pq保存列表nums中剩余的每个数字及其频数，并且按照每个数字的频数倒序排列
         */
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            pq.offer(entry);
        }
        /**
         * 如果列表nums中频数最大的数字不被尽快消耗，则最后这些相等的数字就会被留下，所以每次总是从队列pq中取出频数最大的两个数字配对删除
         */
        while (pq.size() >= 2) {
            Map.Entry<Integer, Integer> first = pq.poll();
            Map.Entry<Integer, Integer> second = pq.poll();
            /**
             * 如果列表nums中还剩余数字first.key，则重新入队
             */
            if (first.getValue() > 1) {
                first.setValue(first.getValue() - 1);
                pq.offer(first);
            }
            /**
             * 如果列表nums中还剩余数字second.key，则重新入队
             */
            if (second.getValue() > 1) {
                second.setValue(second.getValue() - 1);
                pq.offer(second);
            }
        }
        /**
         * 统计列表nums中剩余数字的个数
         */
        for (Map.Entry<Integer, Integer> entry : pq) {
            result += entry.getValue();
        }
        return result;
    }
}
