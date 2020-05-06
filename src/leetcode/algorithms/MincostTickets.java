package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 983. Minimum Cost For Tickets
 *
 * @author Baltan
 * @date 2020-05-06 07:57
 */
public class MincostTickets {
    public static void main(String[] args) {
        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] costs1 = {2, 7, 15};
        System.out.println(mincostTickets(days1, costs1));

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs2 = {2, 7, 15};
        System.out.println(mincostTickets(days2, costs2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/"></a>
     *
     * @param days
     * @param costs
     * @return
     */
    public static int mincostTickets(int[] days, int[] costs) {
        /**
         * 第一个旅行的日子
         */
        int firstDay = days[0];
        /**
         * 最后一个旅行的日子
         */
        int lastDay = days[days.length - 1];
        /**
         * 要旅行的日子的集合
         */
        Set<Integer> daySet = new HashSet<>();
        /**
         * dp[i]表示第i天开始完成所有旅行所需的最低票价。之所以要+31是因为在判断最后一个旅行的日子的时候也需要讨论
         * 买为其三十天的车票的情况，此时需要计算dp[i+30]
         */
        int[] dp = new int[lastDay + 31];

        for (int day : days) {
            daySet.add(day);
        }

        for (int i = lastDay; i >= firstDay; i--) {
            /**
             * 如果第i天要旅行
             */
            if (daySet.contains(i)) {
                /**
                 * 如果第i天买为期一天的车票，则需要花费costs[0]元，而第i+1天开始完成所有旅行至少需要dp[i+1]元，
                 * 所以总共需要花费costs[0]+dp[i+1]元；如果第i天买为期七天的车票，则需要花费costs[1]元，第i+1
                 * 天到i+6天的车票也包含在内了，而第i+7天开始完成所有旅行至少需要dp[i+7]元，所以总共需要花费
                 * costs[1]+dp[i+7]元；如果第i天买为期三十天的车票，则需要花费costs[2]元，第i+1天到i+29天的
                 * 车票也包含在内了，而第i+30天开始完成所有旅行至少需要dp[i+30]元，所以总共需要花费costs[2]+
                 * dp[i+30]元。以上三种情况去最小值即可。
                 */
                dp[i] = Math.min(Math.min(dp[i + 1] + costs[0], dp[i + 7] + costs[1]), dp[i + 30] + costs[2]);
            } else {
                /**
                 * 如果第i天不旅行，则不必买票
                 */
                dp[i] = dp[i + 1];
            }
        }
        /**
         * 返回第一个旅行的日子开始完成所有旅行所需的最低票价
         */
        return dp[firstDay];
    }
}
