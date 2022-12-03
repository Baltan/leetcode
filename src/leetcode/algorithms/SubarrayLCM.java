package leetcode.algorithms;

/**
 * Description: 2470. Number of Subarrays With LCM Equal to K
 *
 * @author Baltan
 * @date 2022/11/30 09:31
 */
public class SubarrayLCM {
    public static void main(String[] args) {
        System.out.println(subarrayLCM(new int[]{773, 613, 11, 8, 103}, 40));
        System.out.println(subarrayLCM(new int[]{3, 6, 2, 7, 1}, 6));
        System.out.println(subarrayLCM(new int[]{3}, 2));
    }

    public static int subarrayLCM(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        /**
         * dp[i][j]表示nums[i]、nums[i+1]、……、nums[j]这j-i+1个数字的最小公倍数
         */
        int[][] dp = new int[length][length];
        /**
         * nums[i]的最小公倍数就是自身
         */
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];

            if (dp[i][i] == k) {
                result++;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                long lcm = lcm(dp[i][j - 1], nums[j]);
                /**
                 * 后面再追加数字，得到的最小公倍数只会更大，不可能等于k了，不需要继续计算
                 */
                if (lcm > k) {
                    break;
                }
                dp[i][j] = (int) lcm;

                if (dp[i][j] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 计算num1和num2的最小公倍数
     *
     * @param num1
     * @param num2
     * @return
     */
    public static long lcm(int num1, int num2) {
        int gcd = gcd(num1, num2);
        /**
         * num1和num2的最小公倍数为(num1/gcd)*(num2/gcd)*gcd
         */
        return 1L * num1 * num2 / gcd;
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
