package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1696. Jump Game VI
 *
 * @author Baltan
 * @date 2022/8/26 09:13
 */
public class MaxResult {
    public static void main(String[] args) {
        System.out.println(maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
        System.out.println(maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3));
        System.out.println(maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/jump-game-vi/solution/java-dong-tai-gui-hua-jian-zhi-7msji-bai-lscm/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxResult(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        /**
         * dp[i]表示到达nums[i]时可以获得的最大分数
         */
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];

        for (int i = 0; i < length; i++) {
            /**
             * nums[j]为从nums[i]可以直接跳到的位置
             */
            for (int j = i + 1; j < length && j <= i + k; j++) {
                int score = dp[i] + nums[j];
                dp[j] = Math.max(dp[j], score);
                /**
                 * 剪枝，再后面的nums[j+1]可能可以从nums[i]跳到（只要j+1<length并且j+1<=i+k），也一定可以从nums[j]跳到，
                 * 但是由于dp[j]已经不小于dp[i]了，从nums[j]跳到nums[j+1]的分数一定更大，所以不需要再考虑从nums[i]跳到
                 * nums[j]后面的这些位置的情况了
                 */
                if (dp[j] >= dp[i]) {
                    break;
                }
            }
        }
        return dp[length - 1];
    }
}
