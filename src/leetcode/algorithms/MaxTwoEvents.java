package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: 2054. Two Best Non-Overlapping Events
 *
 * @author Baltan
 * @date 2023/1/24 16:03
 */
public class MaxTwoEvents {
    public static void main(String[] args) {
        int[][] events1 = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(maxTwoEvents(events1));

        int[][] events2 = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        System.out.println(maxTwoEvents(events2));

        int[][] events3 = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}};
        System.out.println(maxTwoEvents(events3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/two-best-non-overlapping-events/solutions/1075386/yong-you-xian-dui-lie-wei-hu-ling-yi-ge-8ld3x/"></a>
     *
     * @param events
     * @return
     */
    public static int maxTwoEvents(int[][] events) {
        int result = 0;
        /**
         * 将所有活动按照开始时间升序排列
         */
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        /**
         * 保存已经计算过的开始时间较小的那部分活动，并且按照结束时间升序排列
         */
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int max = 0;

        for (int[] event : events) {
            int start = event[0];
            int value = event[2];
            /**
             * 查找结束时间小于start的所有活动中的最大价值
             */
            while (!minHeap.isEmpty() && minHeap.peek()[1] < start) {
                max = Math.max(max, minHeap.poll()[2]);
            }
            result = Math.max(result, max + value);
            minHeap.offer(event);
        }
        return result;
    }
}
