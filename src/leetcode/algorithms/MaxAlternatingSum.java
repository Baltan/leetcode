package leetcode.algorithms;

/**
 * Description: 1911. Maximum Alternating Subsequence Sum
 *
 * @author Baltan
 * @date 2022/3/4 23:24
 */
public class MaxAlternatingSum {
    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[]{4, 2, 5, 3}));
        System.out.println(maxAlternatingSum(new int[]{5, 6, 7, 8}));
        System.out.println(maxAlternatingSum(new int[]{6, 2, 1, 2, 4, 5}));
    }

    /**
     * 参考：<a href="https://leetcode-cn.com/problems/maximum-alternating-subsequence-sum/"></a>
     *
     * @param nums
     * @return
     */
    public static long maxAlternatingSum(int[] nums) {
        int length = nums.length;
        /**
         * oddDp[i]表示数组nums的子序列nums[0],nums[1],……nums[i]的最大交替和，其中子序列中最后一个元素的索引为奇数
         */
        long[] oddDp = new long[length];
        /**
         * evenDp[i]表示数组nums的子序列nums[0],nums[1],……nums[i]的最大交替和，其中子序列中最后一个元素的索引为偶数
         */
        long[] evenDp = new long[length];
        oddDp[0] = 0;
        evenDp[0] = nums[0];

        for (int i = 1; i < length; i++) {
            /**
             * 当不选择nums[i]时，evenDp[i]=evenDp[i-1]；当选择nums[i]时，新的子序列的倒数第二个元素索引在[0,i-1]中且该
             * 元素的索引为奇数，则evenDp[i]=oddDp[i-1]+nums[i]。两者取较大值为当前子序列最后一个元素索引为偶数时的最大交替
             * 和
             */
            evenDp[i] = Math.max(evenDp[i - 1], oddDp[i - 1] + nums[i]);
            /**
             * 当不选择nums[i]时，oddDp[i]=oddDp[i-1]；当选择nums[i]时，新的子序列的倒数第二个元素索引在[0,i-1]中且该元素
             * 的索引为偶数，则oddDp[i]=evenDp[i-1]-nums[i]。两者取较大值为当前子序列最后一个元素索引为奇数时的最大交替和
             */
            oddDp[i] = Math.max(oddDp[i - 1], evenDp[i - 1] - nums[i]);
        }
        /**
         * 拥有最大交替和的子序列的最后一个元素索引一定不为奇数，因为奇数索引意味着要减去该元素的值，可以不选择该元素，直接让子序
         * 列在倒数第二个元素索引为偶数时结束
         */
        return evenDp[length - 1];
    }
}
