package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Description: 3169. Count Days Without Meetings
 *
 * @author Baltan
 * @date 2024/6/2 14:00
 */
public class CountDays {
    public static void main(String[] args) {
        System.out.println(countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}}));
        System.out.println(countDays(5, new int[][]{{2, 4}, {1, 3}}));
        System.out.println(countDays(6, new int[][]{{1, 6}}));
    }

    public static int countDays(int days, int[][] meetings) {
        int result = days;
        /**
         * 将所有会议优先按照开始时间升序排列，开始时间相同时按照结束时间升序排列
         */
        Arrays.sort(meetings, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        /**
         * 将所有时间有交集的会议合并到一起后的会议时刻表
         */
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(meetings[0]);

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] >= deque.peekLast()[0] && meetings[i][0] <= deque.peekLast()[1]) {
                /**
                 * 当前会议meetings[i]的开始时间介于此前最后一个会议时间区间内，则两个会议时间区间可以合并，会议结束时间取两个时间区间的较大值
                 */
                deque.peekLast()[1] = Math.max(meetings[i][1], deque.peekLast()[1]);
            } else {
                /**
                 * 当前会议meetings[i]和此前最后一个会议时间区间不衔接
                 */
                deque.offerLast(meetings[i]);
            }
        }
        /**
         * 扣除所有会议天数
         */
        while (!deque.isEmpty()) {
            int[] meeting = deque.pollFirst();
            result -= (meeting[1] - meeting[0] + 1);
        }
        return result;
    }
}
