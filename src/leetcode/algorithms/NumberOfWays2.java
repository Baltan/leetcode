package leetcode.algorithms;

import java.util.stream.IntStream;

/**
 * Description: 2787. Ways to Express an Integer as Sum of Powers
 *
 * @author Baltan
 * @date 2023/7/26 19:57
 */
public class NumberOfWays2 {
    public static void main(String[] args) {
        System.out.println(numberOfWays(10, 2));
        System.out.println(numberOfWays(4, 1));
    }

    public static int numberOfWays(int n, int x) {
        int mod = 1000000007;
        /**
         * 计算可选的正整数底数的范围
         */
        int base = 1;

        while (pow(base, x) <= n) {
            base++;
        }
        /**
         * 底数范围[1,base-1]都是可能被选中的，所以可以用来求和的数字范围为1^x、2^x、3^x、……、(base-1)^x
         */
        int[] nums = IntStream.rangeClosed(1, base - 1).map(i -> pow(i, x)).toArray();
        /**
         * dp[i][j]表示在前i块石头中选择，使得总和为j的方法数
         */
        long[][] dp = new long[nums.length + 1][n + 1];
        /**
         * 对于前i块石头来说，最终都只有一种方法使得总和为0
         */
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= n; j++) {
                /**
                 * 如果不取第i块石头nums[i-1]，则需要在前i-1块石头中选择，使得总和为j，方法数为dp[i-1][j]
                 */
                dp[i][j] += dp[i - 1][j];

                if (j - nums[i - 1] >= 0) {
                    /**
                     * 如果选择了第i块石头nums[i-1]，则需要在前i-1块石头中选择，是的总和为j-nums[i-1]，方法数为dp[i-1][j-nums[i-1]]
                     */
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return (int) (dp[nums.length][n] % mod);
    }

    /**
     * 计算base的exponent次方的值
     *
     * @param base
     * @param exponent
     * @return
     */
    public static int pow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (base == 1 || exponent == 1) {
            return base;
        }
        int half = exponent / 2;
        int power = pow(base, half);
        return power * power * pow(base, exponent - (half << 1));
    }
}
