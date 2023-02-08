package leetcode.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2558. Take Gifts From the Richest Pile
 *
 * @author Baltan
 * @date 2023/2/7 09:15
 */
public class PickGifts {
    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{25, 64, 9, 4, 100}, 4));
        System.out.println(pickGifts(new int[]{1, 1, 1, 1}, 4));
    }

    public static long pickGifts(int[] gifts, int k) {
        long result = 0L;
        /**
         * 将各堆礼物按照礼物数量降序排列
         */
        Queue<Integer> maxHeap = new PriorityQueue<>(gifts.length, Collections.reverseOrder());

        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            int max = maxHeap.poll();
            maxHeap.offer((int) Math.sqrt(max));
        }
        /**
         * 计算剩余礼物数量
         */
        for (int gift : maxHeap) {
            result += gift;
        }
        return result;
    }
}
