package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3066. Minimum Operations to Exceed Threshold Value II
 *
 * @author baltan
 * @date 2024/3/11 14:08
 * @see
 */
public class MinOperations19 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 1, 1, 3, 15}, 13));
        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 20));
    }

    public static int minOperations(int[] nums, int k) {
        int result = 0;
        /**
         * 升序保存数组nums中剩余的所有元素
         */
        Queue<Long> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer((long) num);
        }

        while (pq.peek() < k) {
            result++;
            long x = pq.poll();
            long y = pq.poll();
            pq.offer(Math.min(x, y) * 2 + Math.max(x, y));
        }
        return result;
    }
}
