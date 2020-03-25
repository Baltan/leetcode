package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1387. Sort Integers by The Power Value
 *
 * @author Baltan
 * @date 2020-03-25 00:23
 */
public class GetKth {
    public static void main(String[] args) {
        System.out.println(getKth(12, 15, 2));
        System.out.println(getKth(1, 1, 1));
        System.out.println(getKth(7, 11, 4));
        System.out.println(getKth(10, 20, 5));
        System.out.println(getKth(1, 1000, 777));
    }

    public static int getKth(int lo, int hi, int k) {
        /**
         * value -> value的权重
         */
        Map<Integer, Integer> map = new HashMap<>();
        /**
         * value中的元素为[整数的权重,整数值]，这些元素优先按照权重升序排列，如果权重相等的按照值升序排列
         */
        Queue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        for (int i = lo; i <= hi; i++) {
            /**
             * 计算i的权重
             */
            int power = getPower(i, map);
            queue.offer(new int[]{power, i});
        }
        /**
         * 去除队列头部的k-1个元素，此时队列头部的元素即为所求
         */
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.peek()[1];
    }

    /**
     * 计算整数value的权重
     *
     * @param value
     * @param map
     * @return
     */
    public static int getPower(int value, Map<Integer, Integer> map) {
        if (value == 1) {
            return 0;
        } else if ((value & 1) == 0) {
            /**
             * 如果之前已经计算过value/2的权重，直接从map中获得，避免重复递归计算
             */
            if (map.containsKey(value / 2)) {
                return map.get(value / 2) + 1;
            } else {
                int power = getPower(value / 2, map);
                map.put(value / 2, power);
                return power + 1;
            }
        } else {
            /**
             * 如果之前已经计算过value*3+1的权重，直接从map中获得，避免重复递归计算
             */
            if (map.containsKey(value * 3 + 1)) {
                return map.get(value * 3 + 1) + 1;
            } else {
                int power = getPower(value * 3 + 1, map);
                map.put(value * 3 + 1, power);
                return power + 1;
            }
        }
    }
}
