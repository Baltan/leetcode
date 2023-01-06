package leetcode.algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Description: 2406. Divide Intervals Into Minimum Number of Groups
 *
 * @author Baltan
 * @date 2022/12/22 09:29
 */
public class MinGroups {
    public static void main(String[] args) {
        int[][] intervals1 = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        System.out.println(minGroups(intervals1));

        int[][] intervals2 = {{1, 3}, {5, 6}, {8, 10}, {11, 13}};
        System.out.println(minGroups(intervals2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/divide-intervals-into-minimum-number-of-groups/solutions/1816294/by-endlesscheng-ze3t/"></a>
     *
     * @param intervals
     * @return
     */
    public static int minGroups(int[][] intervals) {
        int length = intervals.length;
        /**
         * 保存每个分组中最后一个区间的右端点
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        /**
         * 将所有区间按照左端点升序排列，左端点相等时按照右端点升序排列
         */
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i = 0; i < length; i++) {
            if (pq.isEmpty()) {
                /**
                 * 新创建一个分组
                 */
                pq.offer(intervals[i][1]);
            } else {
                if (intervals[i][0] > pq.peek()) {
                    /**
                     * 将当前区间追加到队列中的第一个分组的后面
                     */
                    pq.poll();
                    pq.offer(intervals[i][1]);
                } else {
                    /**
                     * 新创建一个分组
                     */
                    pq.offer(intervals[i][1]);
                }
            }
        }
        return pq.size();
    }
}
