package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1353. Maximum Number of Events That Can Be Attended
 *
 * @author Baltan
 * @date 2020-03-14 11:08
 */
public class MaxEvents {
    public static void main(String[] args) {
        int[][] events1 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(maxEvents(events1));

        int[][] events2 = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        System.out.println(maxEvents(events2));

        int[][] events3 = {{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        System.out.println(maxEvents(events3));

        int[][] events4 = {{1, 100000}};
        System.out.println(maxEvents(events4));

        int[][] events5 = {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}};
        System.out.println(maxEvents(events5));

        int[][] events6 = {{1, 3}, {1, 3}, {1, 3}, {3, 4}};
        System.out.println(maxEvents(events6));
    }

    public static int maxEvents(int[][] events) {
        int result = 0;
        /**
         * 将所有会议按照结束日期递增排序，如果结束日期相等的话，按照开始日期递减排序
         */
        Arrays.sort(events, (x, y) -> x[1] == y[1] ? y[0] - x[0] : x[1] - y[1]);
        /**
         * isVisited[i]表示第i天是否安排了会议
         */
        boolean[] isVisited = new boolean[100001];
        /**
         * 遍历排序后的所有会议，每一个会议选择尽可能早的一天参加
         */
        for (int[] event : events) {
            for (int i = event[0]; i <= event[1]; i++) {
                if (!isVisited[i]) {
                    result++;
                    isVisited[i] = true;
                    break;
                }
            }
        }
        return result;
    }
}
