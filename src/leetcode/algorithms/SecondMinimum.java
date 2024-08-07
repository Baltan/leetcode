package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2045. Second Minimum Time to Reach Destination
 *
 * @author baltan
 * @date 2024/8/1 17:27
 */
public class SecondMinimum {
    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        System.out.println(secondMinimum(5, edges1, 3, 5));

        int[][] edges2 = {{1, 2}};
        System.out.println(secondMinimum(2, edges2, 3, 2));

        int[][] edges3 = {{1, 2}};
        System.out.println(secondMinimum(2, edges3, 1, 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/second-minimum-time-to-reach-destination/solutions/1229095/gong-shui-san-xie-yi-ti-shuang-jie-dui-y-88np/"></a>
     *
     * @param n
     * @param edges
     * @param time
     * @param change
     * @return
     */
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        long currentTime = 0;
        int distance = 0;
        /**
         * graph[i]表示与节点i相邻的所有节点
         */
        List<Integer>[] graph = new List[n + 1];
        /**
         * firstDistances[i]表示到达节点i的最短时间
         */
        int[] firstDistances = new int[n + 1];
        /**
         * secondDistances[i]表示到达节点i的第二短时间
         */
        int[] secondDistances = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.setAll(graph, i -> new ArrayList<>());
        Arrays.fill(firstDistances, Integer.MAX_VALUE);
        Arrays.fill(secondDistances, Integer.MAX_VALUE);
        /**
         * 初始时位于节点1
         */
        queue.offer(1);
        firstDistances[1] = 0;
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        /**
         * 计算到达每个节点的最短时间和第二短时间
         */
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int next : graph[curr]) {
                    if (firstDistances[next] == Integer.MAX_VALUE) {
                        firstDistances[next] = distance;
                        queue.offer(next);
                        /**
                         * 到达节点next的第二短时间必须晚于到达节点next的最短时间
                         */
                    } else if (secondDistances[next] == Integer.MAX_VALUE && distance > firstDistances[next]) {
                        secondDistances[next] = distance;
                        queue.offer(next);
                    }
                }
            }
        }

        for (int i = 1; i < secondDistances[n]; i++) {
            /**
             * 到达当前节点的时刻
             */
            currentTime += time;
            long lo = 0;
            long hi = Integer.MAX_VALUE;
            /**
             * 绿灯的时间段为[0,change)、[2*change,3*change)、[4*change,5*change)……二分计算从当前节点离开的时刻
             */
            while (lo < hi) {
                long mid = (lo + hi) / 2;
                /**
                 * 当前时刻currentTime晚于时间区间[2*mid*change,2*mid*change+change)，只能在更靠后的绿灯时间区间离开
                 */
                if (mid * 2 * change + change <= currentTime) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            /**
             * 如果时刻currentTime已经位于一个绿灯时间区间中，则在currentTime时刻可以离开节点，否则需要等红灯结束后在下一个绿灯的起始时
             * 刻2*lo*change离开
             */
            currentTime = Math.max(currentTime, lo * 2 * change);
        }
        /**
         * 上一个节点的离开时刻为currentTime，再经过时间time到达节点n
         */
        return (int) (currentTime + time);
    }
}
