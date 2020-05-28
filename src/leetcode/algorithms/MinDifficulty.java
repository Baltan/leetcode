package leetcode.algorithms;

/**
 * Description: 1335. Minimum Difficulty of a Job Schedule
 *
 * @author Baltan
 * @date 2020-05-27 22:54
 */
public class MinDifficulty {
    public static void main(String[] args) {
        System.out.println(minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println(minDifficulty(new int[]{9, 9, 9}, 4));
        System.out.println(minDifficulty(new int[]{1, 1, 1}, 3));
        System.out.println(minDifficulty(new int[]{7, 1, 7, 1, 7, 1}, 3));
        System.out.println(minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6));
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        int length = jobDifficulty.length;
        /**
         * 如果工作数少于天数，则不能保证每天至少完成一份工作，返回-1
         */
        if (length < d) {
            return -1;
        }

        /**
         * dp[i][j]表示前i项工作用j天完成的最小难度，则
         * dp[i][j]=min{
         *      dp[i-1][j-1]+jobDifficulty[i],
         *      dp[i-2][j-1]+max{jobDifficulty[i-1],jobDifficulty[i]},
         *      dp[i-3][j-1]+max{jobDifficulty[i-2],jobDifficulty[i-1],jobDifficulty[i]}
         *      ……
         *      dp[j-1][j-1]+max{jobDifficulty[j]……jobDifficulty[i-1],jobDifficulty[i]}
         * }
         */
        int[][] dp = new int[length + 1][d + 1];
        int dayMax = 0;
        /**
         * 1天完成[1,length]份工作的工作难度
         */
        for (int i = 0; i < length; i++) {
            dayMax = Math.max(dayMax, jobDifficulty[i]);
            dp[i + 1][1] = dayMax;
        }

        for (int dayCount = 2; dayCount <= d; dayCount++) {
            for (int jobCount = dayCount; jobCount <= length; jobCount++) {
                dp[jobCount][dayCount] = Integer.MAX_VALUE;
                /**
                 * 最后一天工作的工作难度
                 */
                int lastDayMax = Integer.MIN_VALUE;
                /**
                 * 最后一天可以做[1,jobCount-dayCount+1]份工作，因为至少保证前dayCount-1天有dayCount-1份
                 * 工作可做
                 */
                for (int k = 1; k <= jobCount - dayCount + 1; k++) {
                    lastDayMax = Math.max(lastDayMax, jobDifficulty[jobCount - k]);
                    /**
                     * 如果最后一天完成k份工作，则前dayCount-1天要完成jobCount-k份工作
                     */
                    dp[jobCount][dayCount] = Math.min(dp[jobCount][dayCount],
                            dp[jobCount - k][dayCount - 1] + lastDayMax);
                }
            }
        }
        return dp[length][d];
    }
}
