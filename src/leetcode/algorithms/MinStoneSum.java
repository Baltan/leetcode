package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1962. Remove Stones to Minimize the Total
 *
 * @author Baltan
 * @date 2022/2/3 12:24
 */
public class MinStoneSum {
    public static void main(String[] args) {
        System.out.println(minStoneSum(new int[]{5, 4, 9}, 2));
        System.out.println(minStoneSum(new int[]{4, 3, 6, 7}, 3));
    }

    public static int minStoneSum(int[] piles, int k) {
        int result = 0;
        int length = piles.length;
        /**
         * 将所有石头堆按照石头的数量倒序排列
         */
        Queue<Integer> pq = new PriorityQueue<>(length, (x, y) -> y - x);

        for (int pile : piles) {
            pq.offer(pile);
        }
        /**
         * 每次循环将当前石头堆中石头最多的那一堆的石头数量减半，即队首的那堆石头
         */
        while (k-- > 0) {
            int pile = pq.poll();
            pile -= Math.floor(pile / 2);
            pq.offer(pile);
        }
        /**
         * 计算剩余石头的总数量
         */
        for (int pile : pq) {
            result += pile;
        }
        return result;
    }
}
