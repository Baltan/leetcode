package leetcode.algorithms;

/**
 * Description: 2111. Minimum Operations to Make the Array K-Increasing
 *
 * @author Baltan
 * @date 2021/12/22 19:30
 */
public class KIncreasing {
    public static void main(String[] args) {
        System.out.println(kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 2));
        System.out.println(kIncreasing(new int[]{5, 4, 3, 2, 1}, 1));
        System.out.println(kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-k-increasing/solution/shi-shu-zu-k-di-zeng-de-zui-shao-cao-zuo-3e62/"></a>
     *
     * @param arr
     * @param k
     * @return
     */
    public static int kIncreasing(int[] arr, int k) {
        int result = 0;

        for (int i = 0; i < k; i++) {
            /**
             * 数组arr中起始索引为i，步长为k的子数组的长度
             */
            int length = (arr.length - 1 - i) / k + 1;
            int index = 0;
            /**
             * 数组arr中对应的索引位置
             */
            int startIndex = i;
            /**
             * 数组arr中起始索引为i，步长为k的子数组
             */
            int[] subArr = new int[length];

            while (index < length) {
                subArr[index++] = arr[startIndex];
                startIndex += k;
            }
            /**
             * 子数组的长度减去最长非严格递增子数组的长度即为当前子数组需要修改数字的操作次数
             */
            result += length - lengthOfLIS(subArr);
        }
        return result;
    }

    /**
     * 查询数组nums的最长非严格递增子数组
     *
     * @param nums
     * @return
     * @see LengthOfLIS
     */
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        /**
         * dp[i]表示子数组nums.subarray(0,i+1)的最长上升子序列的长度
         */
        int[] dp = new int[length];
        dp[0] = 1;
        int result = 1;

        for (int i = 1; i < length; i++) {
            /**
             * 子数组nums.subarray(0,i+1)的最长上升子序列的长度至少为1，即nums[i]小于前面所有值
             */
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                /**
                 * 如果nums[i]大于前面的某个值nums[j]，则nums[i]可以跟在以nums[j]结尾的最长上升子
                 * 序列的后面，构成一个长度为dp[j]+1的最长上升子序列，如果这个最长上升子序列的长度大
                 * 于当前的dp[i]，就更新dp[i]
                 */
                if (nums[i] >= nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}
