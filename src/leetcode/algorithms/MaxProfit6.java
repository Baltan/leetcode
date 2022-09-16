package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Description: 1648. Sell Diminishing-Valued Colored Balls
 *
 * @author Baltan
 * @date 2022/9/15 20:25
 */
public class MaxProfit6 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{497978859, 167261111, 483575207, 591815159}, 836556809));
        System.out.println(maxProfit(new int[]{2, 5}, 4));
        System.out.println(maxProfit(new int[]{3, 5}, 6));
    }

    public static int maxProfit(int[] inventory, int orders) {
        long result = 0L;
        int mod = 1000000007;
        int[] indexes = IntStream.range(0, inventory.length).toArray();
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> inventory[y] - inventory[x]);

        for (int index : indexes) {
            pq.offer(index);
        }

        while (orders > 0) {
            if (pq.size() == 1) {
                int firstIndex = pq.poll();
                int start = inventory[firstIndex];
                int count = orders;
                int end = start - count + 1;
                long sum = getValue(start, end, count);
                result = (result + sum) % mod;
                orders = 0;
            } else {
                int firstIndex = pq.poll();
                int secondIndex = pq.poll();
                int start = inventory[firstIndex];
                int count = Math.min(orders, inventory[firstIndex] - inventory[secondIndex] + 1);
                int end = start - count + 1;
                long sum = getValue(start, end, count);
                result = (result + sum) % mod;
                orders -= count;
                inventory[firstIndex] -= count;
                pq.offer(secondIndex);

                if (inventory[firstIndex] > 0) {
                    pq.offer(firstIndex);
                }
            }
        }
        return (int) result;
    }

    /**
     * 求数列和
     *
     * @param start
     * @param end
     * @param count
     * @return
     */
    public static long getValue(int start, int end, int count) {
        return 1L * (start + end) * count / 2;
    }
}
