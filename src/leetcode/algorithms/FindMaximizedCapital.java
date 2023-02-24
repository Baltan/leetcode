package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Description: 502. IPO
 *
 * @author Baltan
 * @date 2023/2/24 13:59
 */
public class FindMaximizedCapital {
    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        /**
         * 项目的索引
         */
        int index = 0;
        /**
         * 当前资本下可以启动的项目的索引队列，按照项目的利润降序排列
         */
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> profits[y] - profits[x]);
        Integer[] indexes = IntStream.range(0, profits.length).boxed().toArray(Integer[]::new);
        /**
         * 将所有项目索引按照项目需要的资本升序排列
         */
        Arrays.sort(indexes, Comparator.comparingInt(x -> capital[x]));

        for (int i = 0; i < k; i++) {
            /**
             * 将所有所需资本不大于w的项目的索引加入队列中
             */
            while (index < indexes.length && capital[indexes[index]] <= w) {
                pq.offer(indexes[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                /**
                 * 从队列中选择利润最高的项目执行
                 */
                int taskIndex = pq.poll();
                w += profits[taskIndex];
            } else {
                break;
            }
        }
        return w;
    }
}
