package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1235. Maximum Profit in Job Scheduling
 *
 * @author Baltan
 * @date 2019-10-23 08:42
 */
public class JobScheduling {
    public static void main(String[] args) {
        int[] startTime1 = {1, 2, 3, 3};
        int[] endTime1 = {3, 4, 5, 6};
        int[] profit1 = {50, 10, 40, 70};
        System.out.println(jobScheduling(startTime1, endTime1, profit1));

        int[] startTime2 = {1, 2, 3, 4, 6};
        int[] endTime2 = {3, 5, 10, 6, 9};
        int[] profit2 = {20, 20, 100, 70, 60};
        System.out.println(jobScheduling(startTime2, endTime2, profit2));

        int[] startTime3 = {1, 1, 1};
        int[] endTime3 = {2, 3, 4};
        int[] profit3 = {5, 6, 4};
        System.out.println(jobScheduling(startTime3, endTime3, profit3));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int jobCount = startTime.length;
        int[][] jobTable = new int[jobCount][3];
        int[] dp = new int[jobCount];

        for (int i = 0; i < jobCount; i++) {
            jobTable[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        /**
         * 将所有工作按照结束时间递增排序，如果结束时间相等，按照开始时间递增排序
         */
        Arrays.sort(jobTable, (x, y) -> {
            if (x[1] == y[1]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });

        dp[0] = jobTable[0][2];

        for (int i = 1; i < jobCount; i++) {
            /**
             * 如果不做第i份工作可以获得的最大收益
             */
            int undoMaxProfit = dp[i - 1];
            /**
             * 如果做第i份工作可以获得的最大收益
             */
            int doMaxProfit = jobTable[i][2];
            int start = jobTable[i][0];
            /**
             * 如果做第i份工作，向前查找第i份工作之前可以完成的最后一份工作
             */
            for (int j = i - 1; j >= 0; j--) {
                if (jobTable[j][1] <= start) {
                    doMaxProfit += dp[j];
                    break;
                }
            }
            dp[i] = Math.max(undoMaxProfit, doMaxProfit);
        }
        return dp[jobCount - 1];
    }
}
