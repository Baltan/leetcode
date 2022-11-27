package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2462. Total Cost to Hire K Workers
 *
 * @author Baltan
 * @date 2022/11/24 13:57
 */
public class TotalCost {
    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{69, 10, 63, 24, 1, 71, 55, 46, 4, 61, 78, 21, 85, 52, 83, 77, 42, 21, 73, 2, 80, 99, 98, 89, 55, 94, 63, 50, 43, 62, 14}, 21, 31));
        System.out.println(totalCost(new int[]{28, 35, 21, 13, 21, 72, 35, 52, 74, 92, 25, 65, 77, 1, 73, 32, 43, 68, 8, 100, 84, 80, 14, 88, 42, 53, 98, 69, 64, 40, 60, 23, 99, 83, 5, 21, 76, 34}, 32, 12));
        System.out.println(totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        System.out.println(totalCost(new int[]{1, 2, 4, 1}, 3, 3));
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        long result = 0L;
        int length = costs.length;
        /**
         * 如果工人数不多余candidates个，直接从所有工人中选出价格最低的k个即可
         */
        if (length <= candidates) {
            Queue<Integer> pq = new PriorityQueue<>(length);

            for (int cost : costs) {
                pq.offer(cost);
            }

            while (k-- > 0) {
                result += pq.poll();
            }
            return result;
        }
        /**
         * 初始时最前面的工人数
         */
        int count1 = Math.min(length, candidates);
        /**
         * 初始时最后面的工人数
         */
        int count2 = Math.min(candidates, length - count1);
        Queue<Integer> pq1 = new PriorityQueue<>(count1);
        Queue<Integer> pq2 = new PriorityQueue<>(count2);
        int next1 = 0;
        int next2 = length - 1;
        /**
         * 最前面的count1个工人，按照价格升序排列
         */
        for (int i = 0; i < count1; i++) {
            pq1.offer(costs[next1++]);
        }
        /**
         * 最后面的count2个工人，按照价格升序排列
         */
        for (int i = 0; i < count2; i++) {
            pq2.offer(costs[next2--]);
        }

        while (k > 0) {
            /**
             * 如果最前面的工人和最后面的工人连在了一起，可以从所有剩余的工人中直接选出剩下的k的个工人
             */
            if (next1 > next2) {
                Queue<Integer> mergedPq = new PriorityQueue<>(pq1.size() + pq2.size());
                mergedPq.addAll(pq1);
                mergedPq.addAll(pq2);

                while (k-- > 0) {
                    result += mergedPq.poll();
                }
                return result;
            }
            /**
             * 从最前面或者最后面中选择价格最低的工人
             */
            if (pq1.peek() <= pq2.peek()) {
                result += pq1.poll();
                pq1.offer(costs[next1++]);
            } else {
                result += pq2.poll();
                pq2.offer(costs[next2--]);
            }
            k--;
        }
        return result;
    }
}
