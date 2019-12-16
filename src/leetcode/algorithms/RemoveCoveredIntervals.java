package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1288. Remove Covered Intervals
 *
 * @author Baltan
 * @date 2019-12-16 08:59
 */
public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(removeCoveredIntervals(intervals1));

        int[][] intervals2 = {{1, 4}, {3, 6}, {2, 8}, {1, 3}, {2, 5}, {2, 3}, {4, 9}};
        System.out.println(removeCoveredIntervals(intervals2));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        /**
         * 对区间列表按照左端点递增排序，如果左端点相同，按照右端点递减排序
         */
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            } else {
                return x[0] - y[0];
            }
        });
        /**
         * 初始化结果为1，排序后的第一个区间一定没被覆盖
         */
        int result = 1;
        /**
         * 当前覆盖区间的右端点
         */
        int right = intervals[0][1];
        int length = intervals.length;

        for (int i = 1; i < length; i++) {
            int[] interval = intervals[i];
            /**
             * 如果当前区间的右端点大于当前覆盖区间的右端点了，就将覆盖区间的右端点更新为当前区间的
             * 右端点，当前区间一定没被覆盖，将结果计数加1。例如：
             *
             * ---------------（结果加1）
             * ----------
             *   ----------------（更新覆盖区间右端点，结果加1）
             *   -----------
             *     ----
             *       -----------------（更新覆盖区间右端点，结果加1）
             */
            if (interval[1] > right) {
                right = interval[1];
                result++;
            }
        }
        return result;
    }
}
