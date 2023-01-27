package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1986. Minimum Number of Work Sessions to Finish the Tasks
 *
 * @author Baltan
 * @date 2023/1/26 18:03
 */
public class MinSessions {
    public static void main(String[] args) {
        System.out.println(minSessions(new int[]{1, 2, 3}, 3));
        System.out.println(minSessions(new int[]{3, 1, 3, 1, 1}, 8));
        System.out.println(minSessions(new int[]{1, 2, 3, 4, 5}, 15));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-number-of-work-sessions-to-finish-the-tasks/solutions/965175/zhuang-ya-dpshi-shi-hou-xue-xi-yi-xia-li-q4mk/"></a>
     *
     * @param tasks
     * @param sessionTime
     * @return
     */
    public static int minSessions(int[] tasks, int sessionTime) {
        int length = tasks.length;
        /**
         * max的二进制值表示0b11……11（共length个1），从低到高第i位为1时表示tasks[i]在子集中，否则表示不在子集中
         */
        int max = (1 << length) - 1;
        /**
         * 假设i的二进制值表示了tasks的子集中元素的情况，dp[i]表示完成子集i的所有工作的最少工作时间段，所求即为dp[max]
         */
        int[] dp = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        /**
         * 初始化计算每个子集中的所有工作是否能在1个工作时间段中完成
         */
        for (int i = 1; i <= max; i++) {
            int value = i;
            /**
             * 完成子集中所有工作的总时间
             */
            int time = 0;
            int index = 0;

            while (value > 0) {
                if ((value & 1) == 1) {
                    time += tasks[index];
                }
                value >>= 1;
                index++;
            }
            /**
             * 当前子集中的所有工作能在1个工作时间段中完成
             */
            if (time <= sessionTime) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i <= max; i++) {
            /**
             * 已得到完成子集i的所有工作的最少工作时间段
             */
            if (dp[i] != Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 1; j < i; j++) {
                /**
                 * 说明子集j是子集i的子集
                 */
                if ((i | j) == i) {
                    /**
                     * dp[i^j]为子集i中，子集j的补集（或者直接i-j）
                     */
                    dp[i] = Math.min(dp[i], dp[j] + dp[i ^ j]);
                }
            }
        }
        return dp[max];
    }
}
