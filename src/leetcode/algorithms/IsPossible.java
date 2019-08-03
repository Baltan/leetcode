package leetcode.algorithms;

import java.util.*;

/**
 * Description: 659. Split Array into Consecutive Subsequences
 *
 * @author Baltan
 * @date 2019-08-03 16:39
 */
public class IsPossible {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 3, 4, 5};
        System.out.println(isPossible(num1));

        int[] num2 = {1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(isPossible(num2));

        int[] num3 = {1, 2, 3, 4, 4, 5};
        System.out.println(isPossible(num3));

        int[] num4 = {4, 5, 6, 7, 7, 8, 8, 9, 10, 11};
        System.out.println(isPossible(num4));
    }

    public static boolean isPossible(int[] nums) {
        /**
         * 以每个子序列最大值作为key，value为一个PriorityQueue，
         * PriorityQueue中保存以当前key作为子序列最大值的各个子序列的长度
         */
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                Queue<Integer> queue = map.get(num - 1);
                /**
                 * 如果PriorityQueue不为空，获得以num-1作为子序列最大值的最短子序列
                 */
                int count = queue.isEmpty() ? 0 : queue.poll();

                if (map.containsKey(num)) {
                    map.get(num).offer(count + 1);
                } else {
                    Queue<Integer> q = new PriorityQueue<>();
                    q.offer(count + 1);
                    map.put(num, q);
                }
            } else {
                if (map.containsKey(num)) {
                    map.get(num).offer(1);
                } else {
                    Queue<Integer> queue = new PriorityQueue<>();
                    queue.offer(1);
                    map.put(num, queue);
                }
            }
        }
        /**
         * 遍历所有子序列，如果有长度小于3的子序列就返回false
         */
        for (int num : map.keySet()) {
            Queue<Integer> queue = map.get(num);

            for (int count : queue) {
                if (count < 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
