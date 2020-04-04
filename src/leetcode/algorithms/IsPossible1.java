package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1354. Construct Target Array With Multiple Sums
 *
 * @author Baltan
 * @date 2020-04-04 11:04
 */
public class IsPossible1 {
    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{9, 3, 5}));
        System.out.println(isPossible(new int[]{1, 1, 1, 2}));
        System.out.println(isPossible(new int[]{8, 5}));
        System.out.println(isPossible(new int[]{9, 9, 9}));
        System.out.println(isPossible(new int[]{1, 1000000000}));
    }

    public static boolean isPossible(int[] target) {
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int currentSum = 0;

        for (int value : target) {
            currentSum += value;
            queue.offer(value);
        }

        while (queue.peek() > 1) {
            int prevSum = queue.poll();
            int oldValue = prevSum - (currentSum - prevSum);

            if (oldValue < 1) {
                return false;
            }
            queue.offer(oldValue);
            currentSum = prevSum;
        }
        return currentSum == target.length;
    }
}
