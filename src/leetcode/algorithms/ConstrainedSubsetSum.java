package leetcode.algorithms;

import java.util.LinkedList;

/**
 * Description: 1425. Constrained Subsequence Sum
 *
 * @author Baltan
 * @date 2020-05-04 10:19
 */
public class ConstrainedSubsetSum {
    public static void main(String[] args) {
        System.out.println(constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2));
        System.out.println(constrainedSubsetSum(new int[]{-1, -2, -3}, 1));
        System.out.println(constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/constrained-subsequence-sum/solution/dong-tai-gui-hua-hua-dong-chuang-kou-dan-diao-dui-/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int constrainedSubsetSum(int[] nums, int k) {
        int result = nums[0];
        int length = nums.length;
        /**
         * dp[i]表示最后一个元素为nums[i]的子序列的所有元素的和，则dp[i]=max{dp[i-1]+nums[i],
         * dp[i-2]+nums[i],dp[i-3]+nums[i],……,dp[i-k]+nums[i],nums[i]}。也就是说dp[i]的最大值
         * 和dp[i-1]、dp[i-2]、……、dp[i-k]这些值有关。
         */
        int[] dp = new int[length];
        dp[0] = nums[0];
        /**
         * list为一个单调递减队列，队首元素为窗口中dp[i-1]、dp[i-2]、……、dp[i-k]这些值中的的最大值
         */
        LinkedList<Integer> list = new LinkedList<>();
        list.offerLast(nums[0]);

        for (int i = 1; i < k; i++) {
            dp[i] = Math.max(list.peekFirst() + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
            /**
             * 移除list中所有小于dp[i]的值
             */
            while (!list.isEmpty() && list.peekLast() < dp[i]) {
                list.pollLast();
            }
            /**
             * 将dp[i]加入list中
             */
            list.offerLast(dp[i]);
        }

        for (int i = k; i < length; i++) {
            dp[i] = Math.max(list.peekFirst() + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
            /**
             * 移除list中所有小于dp[i]的值
             */
            while (!list.isEmpty() && list.peekLast() < dp[i]) {
                list.pollLast();
            }
            /**
             * 将dp[i]加入list中
             */
            list.offerLast(dp[i]);
            /**
             * 下一个dp[i+1]的子序列中包含nums[i+1]，子序列中倒数第二个数字不可能为nums[i-k]，所以
             * 要将dp[i-k]从list中移除
             */
            if (dp[i - k] == list.peekFirst()) {
                list.pollFirst();
            }
        }
        return result;
    }
}
