package leetcode.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2815. Max Pair Sum in an Array
 *
 * @author baltan
 * @date 2023/8/16 23:09
 */
public class MaxSum1 {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{84, 91, 18, 59, 27, 9, 81, 33, 17, 58}));
        System.out.println(maxSum(new int[]{51, 71, 17, 24, 42}));
        System.out.println(maxSum(new int[]{1, 2, 3, 4}));
    }

    public static int maxSum(int[] nums) {
        int result = -1;
        /**
         * queues[i]保存数组nums中数位上最大值为i的数字，队列中的所有数字按降序排列
         */
        Queue<Integer>[] queues = new Queue[10];

        for (int i = 0; i < 10; i++) {
            queues[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int num : nums) {
            /**
             * 备份当前的数字
             */
            int copy = num;
            /**
             * 数字nums各数位上的最大值
             */
            int maxDigit = 0;

            while (num > 0) {
                maxDigit = Math.max(maxDigit, num % 10);
                num /= 10;
            }
            queues[maxDigit].offer(copy);
        }

        for (Queue<Integer> queue : queues) {
            if (queue.size() >= 2) {
                /**
                 * 将队列中最大的两个数字出队求和
                 */
                result = Math.max(result, queue.poll() + queue.poll());
            }
        }
        return result;
    }
}
