package leetcode.algorithms;

/**
 * Description: 3366. Minimum Array Sum
 *
 * @author Baltan
 * @date 2024/11/30 23:01
 */
public class MinArraySum {
    public static void main(String[] args) {
        System.out.println(minArraySum(new int[]{1, 3, 5, 7, 9, 12, 12, 12, 13, 15, 15, 15, 16, 17, 19, 20}, 11, 15, 4));
        System.out.println(minArraySum(new int[]{3}, 6, 0, 1));
        System.out.println(minArraySum(new int[]{2, 8, 3, 19, 3}, 3, 1, 1));
        System.out.println(minArraySum(new int[]{2, 4, 3}, 3, 2, 1));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-array-sum/solutions/2998867/jiao-ni-yi-bu-bu-si-kao-dpcong-ji-yi-hua-0pc5/"></a>
     *
     * @param nums
     * @param k
     * @param op1
     * @param op2
     * @return
     */
    public static int minArraySum(int[] nums, int k, int op1, int op2) {
        /**
         * dp[i][j][l]表示对数组nums的前i个元素最多进行j次操作1和l次操作2后，这i个元素之和的最小值
         */
        int[][][] dp = new int[nums.length + 1][op1 + 1][op2 + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= op1; j++) {
                for (int l = 0; l <= op2; l++) {
                    /**
                     * 对元素nums[i]不进行任何操作
                     */
                    dp[i + 1][j][l] = dp[i][j][l] + nums[i];
                    /**
                     * 对元素nums[i]进行一次操作1，则前i-1个元素最多进行j-1次操作1和l次操作2
                     */
                    if (j > 0) {
                        dp[i + 1][j][l] = Math.min(dp[i + 1][j][l], dp[i][j - 1][l] + (nums[i] + 1) / 2);
                    }
                    /**
                     * 对元素nums[i]进行一次操作2，则前i-1个元素最多进行j次操作1和l-1次操作2
                     */
                    if (l > 0 && nums[i] >= k) {
                        dp[i + 1][j][l] = Math.min(dp[i + 1][j][l], dp[i][j][l - 1] + nums[i] - k);
                    }
                    /**
                     * 对元素nums[i]进行一次操作1和一次操作2，则前i-1个元素最多进行j-1次操作1和l-1次操作2。对于操作1和操作2的执行顺序，
                     * 如果执行完操作1后仍可以执行操作2，则先执行操作1再执行操作2肯定小于先执行操作2再执行操作1，所以优先考虑选择前者
                     */
                    if (j > 0 && l > 0) {
                        if ((nums[i] + 1) / 2 >= k) {
                            dp[i + 1][j][l] = Math.min(dp[i + 1][j][l], dp[i][j - 1][l - 1] + (nums[i] + 1) / 2 - k);
                        } else if (nums[i] >= k) {
                            dp[i + 1][j][l] = Math.min(dp[i + 1][j][l], dp[i][j - 1][l - 1] + (nums[i] - k + 1) / 2);
                        }
                    }
                }
            }
        }
        return dp[nums.length][op1][op2];
    }
}
