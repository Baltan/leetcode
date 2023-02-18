package leetcode.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2335. Minimum Amount of Time to Fill Cups
 *
 * @author Baltan
 * @date 2023/2/15 10:27
 */
public class FillCups {
    public static void main(String[] args) {
        System.out.println(fillCups(new int[]{1, 4, 2}));
        System.out.println(fillCups(new int[]{5, 4, 4}));
        System.out.println(fillCups(new int[]{5, 0, 0}));
    }

    public static int fillCups(int[] amount) {
        int result = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int count : amount) {
            if (count != 0) {
                pq.offer(count);
            }
        }
        /**
         * 不需要装水
         */
        if (pq.isEmpty()) {
            return result;
        }
        /**
         * 只需要装一种类型的水，每次装一杯
         */
        if (pq.size() == 1) {
            return pq.poll();
        }
        /**
         * 每次总是选择最多数量的两种类型的水，各装满一杯，直到所有杯子都装满或者只剩一种类型的水
         */
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            result++;

            if (first != 1) {
                pq.offer(first - 1);
            }

            if (second != 1) {
                pq.offer(second - 1);
            }
        }
        /**
         * 剩下的一种类型的水，每次装一杯
         */
        if (!pq.isEmpty()) {
            result += pq.poll();
        }
        return result;
    }
}
