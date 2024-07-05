package leetcode.algorithms;

/**
 * Description: 3202. Find the Maximum Length of Valid Subsequence II
 *
 * @author Baltan
 * @date 2024/7/2 22:56
 * @see MaximumLength5
 */
public class MaximumLength6 {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3));
    }

    public static int maximumLength(int[] nums, int k) {
        int result = 0;
        /**
         * dp[i][j]表示对于数组nums中的某个数字之前已有的正确序列中，最后一个数字为j，倒数第二个数字为i的序列的长度
         */
        int[][] dp = new int[k][k];

        for (int num : nums) {
            int remainder = num % k;
            /**
             * 对于当前数字num除以k的余数remainder，只可能拼接在之前已有的，最后两个数字为[remainder,0]或[remainder,1]或……或
             * [remainder,k-1]的正确序列之后，并且拼接后会得到最后两个数字为[0,remainder]或[1,remainder]或……或[k-1,remainder]的正
             * 确序列，并且长度为之前的正确序列长度加1
             */
            for (int i = 0; i < k; i++) {
                /**
                 * 正确序列remainder,i,remainder,i,……
                 */
                dp[i][remainder] = dp[remainder][i] + 1;
                result = Math.max(result, dp[i][remainder]);
            }
        }
        return result;
    }
}
