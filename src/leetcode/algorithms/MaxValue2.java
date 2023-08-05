package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 1751. Maximum Number of Events That Can Be Attended II
 *
 * @author Baltan
 * @date 2023/8/1 22:48
 */
public class MaxValue2 {
    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{{1, 3, 4}, {2, 4, 1}, {1, 1, 4}, {3, 5, 1}, {2, 5, 5}}, 3));
        System.out.println(maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}}, 2));
        System.out.println(maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 10}}, 2));
        System.out.println(maxValue(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}}, 3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/solutions/1913087/dong-tai-gui-hua-er-fen-cha-zhao-you-hua-fuip/"></a>
     *
     * @param events
     * @param k
     * @return
     */
    public static int maxValue(int[][] events, int k) {
        int length = events.length;
        /**
         * dp[i][j]表示在前i个会议中参加j个会议的最大价值
         */
        int[][] dp = new int[length + 1][k + 1];
        /**
         * 将所有会议按照结束时间升序排列
         */
        Arrays.sort(events, Comparator.comparingInt(x -> x[1]));
        /**
         * 当只能选择参加1个会议时，总是在可选范围内选择价值最大的那一个
         */
        for (int i = 1; i <= length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], events[i - 1][2]);
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 2; j <= i && j <= k; j++) {
                int index = binarySearch(events, events[i - 1][0]);
                /**
                 * 如果不参加会议events[i-1]，则在前i个会议中选择参加j个会议的最大价值等于在前i-1个会议中选择参加j个会议的最大价值，即
                 * dp[i-1][j]；如果参加会议events[i-1]，则这场会议前最晚可以参加的会议为events[index]（如果index=-1，则说明在会议
                 * events[i-1]前不能参加任何其他会议，在参加events[i-1]前的总价值只能为0），则在前i个会议中选择参加j个会议的最大价值等
                 * 于在前index+1个会议中选择参加j-1个会议，再加上参加events[i-1]的价值
                 */
                dp[i][j] = Math.max(dp[i - 1][j], (index == -1 ? 0 : dp[index + 1][j - 1]) + events[i - 1][2]);
                /**
                 * 因为至多可以参加j个会议，所以如果参加的会议少于j，但是能得到更大的价值，则可以不参加完j个会议
                 */
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
        return dp[length][k];
    }

    /**
     * 在events中二分查找结束时间小于start且最晚结束的会议
     *
     * @param events
     * @param start
     * @return
     */
    public static int binarySearch(int[][] events, int start) {
        /**
         * 不存在结束时间小于start的会议
         */
        if (events[0][1] >= start) {
            return -1;
        }
        int lo = 0;
        int hi = events.length - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (events[mid][1] < start) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
