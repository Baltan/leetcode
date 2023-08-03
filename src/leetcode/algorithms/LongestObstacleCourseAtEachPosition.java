package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1964. Find the Longest Valid Obstacle Course at Each Position
 *
 * @author Baltan
 * @date 2023/7/30 23:20
 */
public class LongestObstacleCourseAtEachPosition {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2}));
        OutputUtils.print1DIntegerArray(longestObstacleCourseAtEachPosition(new int[]{2, 2, 1}));
        OutputUtils.print1DIntegerArray(longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-the-longest-valid-obstacle-course-at-each-position/solutions/2263719/javascriptdong-tai-gui-hua-er-fen-by-uni-ag1w/"></a>
     *
     * @param obstacles
     * @return
     */
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] result = new int[obstacles.length];
        /**
         * dp[i]表示长度为i+1的最长递增子序列的最后一个元素可能的最小值，显然数组dp中任意两个相邻的元素都是非递减的
         */
        int[] dp = new int[obstacles.length];
        /**
         * obstacles[0]自身构成一个长度为1的最长递增子序列
         */
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = obstacles[0];
        result[0] = 1;

        for (int i = 1; i < obstacles.length; i++) {
            if (obstacles[i] < dp[0]) {
                /**
                 * 之前得到的所有的最长递增子序列的最后一个元素都大于obstacles[i]，obstacles[i]只能单独构成一个长度为1的最长递增子序列
                 */
                dp[0] = obstacles[i];
                result[i] = 1;
            } else if (obstacles[i] >= dp[i - 1]) {
                /**
                 * 之前得到的所有的最长递增子序列的最后一个元素都不大于obstacles[i]，可在长度为i最后一个元素为dp[i-1]的最长递增子序列后
                 * 追加元素obstacles[i]，得到一个长度为i+1的最长递增子序列
                 */
                dp[i] = obstacles[i];
                result[i] = i + 1;
            } else {
                int lo = 0;
                int hi = i - 1;
                /**
                 * 在dp[0]到dp[i-1]这部分子数组中二分查找第一个大于obstacles[i]的元素的索引位置
                 */
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (dp[mid] <= obstacles[i]) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                /**
                 * 将此前得到的长度为lo+1的最长递增子序列的最后一个元素变为obstacles[i]
                 */
                dp[lo] = obstacles[i];
                /**
                 * 以obstacles[i]结尾的最长递增子序列的长度为lo+1
                 */
                result[i] = lo + 1;
            }
        }
        return result;
    }
}
