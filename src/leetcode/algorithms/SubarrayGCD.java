package leetcode.algorithms;

/**
 * Description: 2447. Number of Subarrays With GCD Equal to K
 *
 * @author Baltan
 * @date 2022/12/4 14:03
 * @see SubarrayLCM
 */
public class SubarrayGCD {
    public static void main(String[] args) {
        System.out.println(subarrayGCD(new int[]{9, 3, 1, 2, 6, 3}, 3));
        System.out.println(subarrayGCD(new int[]{4}, 7));
    }

    public static int subarrayGCD(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        /**
         * dp[i][j]表示nums[i]、nums[i+1]、……、nums[j]这j-i+1个数字的最大公约数
         */
        int[][] dp = new int[length][length];
        /**
         * nums[i]的最大公约数就是自身
         */
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];

            if (dp[i][i] == k) {
                result++;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = gcd(dp[i][j - 1], nums[j]);
                /**
                 * 后面再追加数字，得到的最大公约数只会更小，不可能等于k了，不需要继续计算
                 */
                if (dp[i][j] < k) {
                    break;
                }

                if (dp[i][j] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 求num1和num2的最大公约数
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int gcd(int num1, int num2) {
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
