package leetcode.algorithms;

/**
 * Description: 3599. Partition Array to Minimize XOR
 *
 * @author baltan
 * @date 2025/7/25 10:34
 */
public class MinXor {
    public static void main(String[] args) {
        System.out.println(minXor(new int[]{1, 2, 3}, 2));
        System.out.println(minXor(new int[]{2, 3, 3, 2}, 3));
        System.out.println(minXor(new int[]{1, 1, 2, 3, 1}, 2));
    }

    public static int minXor(int[] nums, int k) {
        int length = nums.length;
        /**
         * dp[i][j]表示包含数组nums的前i个元素的前缀子数组分割成j个子数组后，j个子数组中最大XOR的最小值，所求即为dp[length][k]
         */
        int[][] dp = new int[length + 1][k + 1];
        /**
         * 当分割后的子数组个数为1时，相当于不对原数组做任何操作，直接计算前缀子数组中所有元素按位异或的值
         */
        for (int i = 1; i <= length; i++) {
            dp[i][1] = dp[i - 1][1] ^ nums[i - 1];
        }

        for (int i = 2; i <= length; i++) {
            /**
             * 当数组nums的前缀子数组中包含i个元素，将前缀子数组分割成j个子数组，则j不大于i，且j不大于k
             */
            for (int j = 2; j <= i && j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                /**
                 * 分割后前j-1个子数组中一共包含前缀子数组中的元素个数为l，则l至少为j-1，至多为i-1
                 */
                for (int l = j - 1; l < i; l++) {
                    /**
                     * 前缀子数组中前l个元素分割成j-1个子数组后，这j-1个子数组中最大XOR的最小值为dp[l][j-1]，前缀子数组中最后i-l个元素
                     * 构成第j个子数组，这部分元素按位异或的值为dp[i][1]^dp[l][1]，两者的较大值即为当前分割状态下，这j个子数组各自按位异
                     * 或计算后的最大XOR值。最终需要确保这个最大XOR值尽可能小，需要和此前已有的分割结果取较小值
                     */
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[l][j - 1], dp[i][1] ^ dp[l][1]));
                }
            }
        }
        return dp[length][k];
    }
}
