package leetcode.algorithms;

/**
 * Description: 813. Largest Sum of Averages
 *
 * @author Baltan
 * @date 2022/11/14 09:49
 */
public class LargestSumOfAverages {
    public static void main(String[] args) {
        System.out.println(largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
        System.out.println(largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
    }

    public static double largestSumOfAverages(int[] nums, int k) {
        int length = nums.length;
        /**
         * dp[i][j]表示将数组nums的前i个数分成j组得到的每个组平均数最大总和，所求即为dp[length][k]
         */
        double[][] dp = new double[length + 1][k + 1];
        /**
         * 数组nums的前缀和prefixSums[i]表示数组nums的前i个元素的和
         */
        int[] prefixSums = new int[length + 1];

        for (int i = 0; i < length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
            /**
             * 将数组的前i+1个元素分到一组，这部分元素的平均数
             */
            dp[i + 1][1] = prefixSums[i + 1] * 1.0 / (i + 1);
        }
        /**
         * dp[numCount][groupCount]=max{
         *      dp[groupCount-1][groupCount-1]+avg(nums[groupCount-1]+nums[groupCount]+……+nums[numCount-1]),
         *      dp[groupCount][groupCount-1]+avg(nums[groupCount]+nums[groupCount+1]+……+nums[numCount-1]),
         *      ……,
         *      dp[numCount-1][groupCount-1]+avg(nums[numCount-1])
         * }
         */
        for (int groupCount = 2; groupCount <= k; groupCount++) {
            for (int numCount = groupCount; numCount <= length; numCount++) {
                /**
                 * 前groupCount-1个分组的元素个数至少有groupCount-1个，至多有numCount-1个
                 */
                for (int i = groupCount - 1; i < numCount; i++) {
                    dp[numCount][groupCount] = Math.max(dp[numCount][groupCount], dp[i][groupCount - 1] + (prefixSums[numCount] - prefixSums[i]) * 1.0 / (numCount - i));
                }
            }
        }
        return dp[length][k];
    }
}
