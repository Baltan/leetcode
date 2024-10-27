package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 956. Tallest Billboard
 *
 * @author Baltan
 * @date 2024/10/26 17:58
 */
public class TallestBillboard {
    public static void main(String[] args) {
        System.out.println(tallestBillboard(new int[]{61, 45, 43, 54, 40, 53, 55, 47, 51, 59, 42}));
        System.out.println(tallestBillboard(new int[]{102, 101, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
        System.out.println(tallestBillboard(new int[]{1, 2, 3, 6}));
        System.out.println(tallestBillboard(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(tallestBillboard(new int[]{1, 2}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/tallest-billboard/solutions/368725/yi-quan-ji-ben-mei-shuo-ming-bai-de-zhe-pian-kan-l/"></a>
     *
     * @param rods
     * @return
     */
    public static int tallestBillboard(int[] rods) {
        /**
         * 所有钢筋连接在一起的总长度
         */
        int total = 0;

        for (int rod : rods) {
            total += rod;
        }
        /**
         * 题意等同于将数组rods的每个元素乘以-1或0或1后，将操作后元素相加，当总和为0时，使得操作后非负元素之和最大。所以数组操作后所有元素之
         * 和∈[-total,total]。dp[i]表示当数组操作后所有元素之和为i时，其中非负元素之和的最大值，题目所求即为dp[0]（考虑到i可能为负数，实
         * 际代码实现时，需要加上total个单位的偏移量）
         */
        int[] dp = new int[2 * total + 1];
        /**
         * 初始化dp[i]为Integer.MIN_VALUE表示数组操作后所有元素之和为i的情况还不存在，但是当一根钢筋都没有时，dp[0]=0
         */
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[total] = 0;

        for (int rod : rods) {
            int[] clone = dp.clone();

            for (int i = -total; i <= total; i++) {
                /**
                 * 此前数组操作后所有元素之和为i的情况还不存在，不用考虑在这种情况上叠加rod的情况
                 */
                if (dp[i + total] == Integer.MIN_VALUE) {
                    continue;
                }
                /**
                 * 如果对元素rod乘以1，则在dp[i]的基础上，数组操作后所有元素之和为i+rod，其中非负元素之和为dp[i]+rod；如果对元素rod乘以
                 * 0，则情况没有变化；如果对元素rod乘以-1，则在dp[i]的基础上，数组操作后所有元素之和为i-rod，其中非负元素之和为dp[i]
                 */
                clone[i + rod + total] = Math.max(clone[i + rod + total], dp[i + total] + rod);
                clone[i - rod + total] = Math.max(clone[i - rod + total], dp[i + total]);
            }
            dp = clone;
        }
        return dp[total];
    }
}
