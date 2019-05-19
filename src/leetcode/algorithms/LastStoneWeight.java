package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: Last Stone Weight
 *
 * @author Baltan
 * @date 2019-05-19 14:04
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeight(new int[]{43, 5, 4, 2, 54, 76, 54, 4, 23, 13, 64, 67, 76}));
        System.out.println(lastStoneWeight(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);

        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a > b) {
                queue.offer(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
