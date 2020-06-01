package leetcode.algorithms;

/**
 * Description: 1043. Partition Array for Maximum Sum
 *
 * @author Baltan
 * @date 2020-06-01 13:52
 */
public class MaxSumAfterPartitioning1 {
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/partition-array-for-maximum-sum/solution/1043-fen-ge-shu-zu-yi-de-dao-zui-da-he-partition-a/"></a>
     *
     * @param A
     * @param K
     * @return
     */
    public static int maxSumAfterPartitioning(int[] A, int K) {
        int length = A.length;
        /**
         * dp[i]表示A.subarray(0,i+1)按照题意分隔可以得到的最大和
         */
        int[] dp = new int[length];
        dp[0] = A[0];

        for (int i = 1; i < length; i++) {
            /**
             * 最后一个子数组中的最大值
             */
            int max = 0;
            /**
             * 最后一个子数组的长度最短为1，最长不超过K，且不超过A.subarray(0,i+1)的长度
             */
            for (int j = 1; j <= Math.min(K, i + 1); j++) {
                max = Math.max(max, A[i - j + 1]);
                /**
                 * 如果最后一个子数组的长度正好为A.subarray(0,i+1)的长度，即数组A不做分隔，则得到的最大和就
                 * 是max*j
                 */
                dp[i] = Math.max(dp[i], (i - j < 0 ? 0 : dp[i - j]) + max * j);
            }
        }
        return dp[length - 1];
    }
}
