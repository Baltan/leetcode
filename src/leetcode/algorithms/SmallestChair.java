package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1942. The Number of the Smallest Unoccupied Chair
 *
 * @author Baltan
 * @date 2022/2/18 10:59
 */
public class SmallestChair {
    public static void main(String[] args) {
        int[][] times1 = {{1, 4}, {2, 3}, {4, 6}};
        System.out.println(smallestChair(times1, 1));

        int[][] times2 = {{3, 10}, {1, 5}, {2, 6}};
        System.out.println(smallestChair(times2, 0));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        /**
         * 最坏的情况是所有用户都入座后，才有第一个用户离开，所以最多需要的座位数为用户数
         */
        int maxChairCount = times.length;
        /**
         * 按照到达时间升序排列
         */
        Queue<int[]> inMinHeap = new PriorityQueue<>(times.length, Comparator.comparingInt(x -> x[0]));
        /**
         * 按照离开时间升序排列
         */
        Queue<int[]> outMinHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        /**
         * 保存所有空座位的索引，按照座位索引升序排列
         */
        Queue<Integer> emptyChairMinHeap = new PriorityQueue<>(maxChairCount);
        /**
         * 初始化保存所有到达用户的小顶堆
         */
        for (int i = 0; i < maxChairCount; i++) {
            emptyChairMinHeap.offer(i);
        }
        /**
         * 初始化保存所有到达时间的小顶堆
         */
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            /**
             * [到达时间,离开时间,用户索引,座位索引]
             */
            inMinHeap.offer(new int[]{time[0], time[1], i, -1});
        }

        while (!inMinHeap.isEmpty() || !outMinHeap.isEmpty()) {
            /**
             * 如果既有达到的用户也有要离开的用户，需要先比较两者谁优先
             */
            if (!inMinHeap.isEmpty() && !outMinHeap.isEmpty()) {
                int[] inTime = inMinHeap.peek();
                int[] outTime = outMinHeap.peek();

                if (inTime[0] < outTime[1]) {
                    if (inTime[2] == targetFriend) {
                        return emptyChairMinHeap.peek();
                    } else {
                        /**
                         * 到达的用户占用索引最小的空座位，并且加入到离开用户的小顶堆
                         */
                        inTime[3] = emptyChairMinHeap.poll();
                        outMinHeap.offer(inMinHeap.poll());
                    }
                } else if (inTime[0] >= outTime[1]) {
                    /**
                     * 将离开用户的座位重新加入空座位的小顶堆
                     */
                    emptyChairMinHeap.offer(outTime[3]);
                    outMinHeap.poll();
                }
            } else if (!inMinHeap.isEmpty()) {
                int[] inTime = inMinHeap.poll();

                if (inTime[2] == targetFriend) {
                    return emptyChairMinHeap.peek();
                } else {
                    /**
                     * 到达的用户占用索引最小的空座位，并且加入到离开用户的小顶堆
                     */
                    inTime[3] = emptyChairMinHeap.poll();
                    outMinHeap.offer(inTime);
                }
            }
        }
        return -1;
    }
}
